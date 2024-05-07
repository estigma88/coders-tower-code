package com.coderstower.blog.a_case_integration_tests.extension;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.test.EmbeddedKafkaBroker;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.kafka.test.utils.ContainerTestUtils;
import org.springframework.kafka.test.utils.KafkaTestUtils;
import org.springframework.test.context.ActiveProfiles;

import java.time.Duration;

@EmbeddedKafka(
        topics = {
                "topic1"
        },
        partitions = 1,
        bootstrapServersProperty = "spring.kafka.bootstrap-servers"
)
@ActiveProfiles(profiles = {"activate-kafka"})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract class KafkaTestConfig extends MockedEdgesConfig {
    private Logger log = LoggerFactory.getLogger(KafkaTestConfig.class);

    @Autowired
    private EmbeddedKafkaBroker kafka;

    @Autowired
    private KafkaTemplate<String, String> template;

    @Autowired
    private KafkaListenerEndpointRegistry kafkaListenerEndpointRegistry;

    @BeforeAll
    public void before() {
        kafkaListenerEndpointRegistry.getListenerContainers().forEach(container -> {
            log.info("ContainerTestUtils.waitForAssignment: ${it.containerProperties}");
            ContainerTestUtils.waitForAssignment(container, kafka.getPartitionsPerTopic());
        });
    }

    public Consumer<String, String> createConsumer(String name, String topic) {
        var consumerProps =
                KafkaTestUtils.consumerProps(name, "true", kafka);
        consumerProps.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");

        var cf = new DefaultKafkaConsumerFactory<>(
                consumerProps,
                new StringDeserializer(),
                new StringDeserializer()
        );

        var consumer = cf.createConsumer();

        kafka.consumeFromAnEmbeddedTopic(
                consumer,
                topic
        );

        // Clear previous messages in the topic and move the offset to the end
        KafkaTestUtils.getRecords(consumer, Duration.ofSeconds(1), 0);

        return consumer;
    }
}
