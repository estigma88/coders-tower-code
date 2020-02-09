package com.coderstower.blog.unit_testing_vs_integration_testing.main;

import com.coderstower.blog.unit_testing_vs_integration_testing.abstraction.TemplateProcess;
import com.coderstower.blog.unit_testing_vs_integration_testing.abstraction.TemplateRender;
import com.coderstower.blog.unit_testing_vs_integration_testing.abstraction.aggregator.BasicResumeDataAggregator;
import com.coderstower.blog.unit_testing_vs_integration_testing.abstraction.aggregator.DataAggregator;
import com.coderstower.blog.unit_testing_vs_integration_testing.abstraction.aggregator.LongResumeDataAggregator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class TemplatesFactory {
    @Bean
    public DataAggregator basicResume() {
        return new BasicResumeDataAggregator();
    }

    @Bean
    public DataAggregator longResume() {
        return new LongResumeDataAggregator();
    }

    @Bean
    public TemplateRender templateRender() {
        return new BasicTemplateRender();
    }

    @Bean
    public TemplateProcess resumeTemplateProcess(
            TemplateRender templateRender,
            Map<String, DataAggregator> dataAggregators) {
        return new TemplateProcess(templateRender,
                dataAggregators);
    }
}
