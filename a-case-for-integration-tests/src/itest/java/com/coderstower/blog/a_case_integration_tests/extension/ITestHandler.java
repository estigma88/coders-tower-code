package com.coderstower.blog.a_case_integration_tests.extension;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo;
import org.springframework.boot.test.system.CapturedOutput;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ITestHandler {
    private ObjectMapper mapper = new ObjectMapper();
    private Path parentPath = Path.of("src/itest/resources/");

    public void loadWiremockMocks(WireMockRuntimeInfo wireMockRuntimeInfo, String mocksPath) {
        var wireMock = wireMockRuntimeInfo.getWireMock();

        var mocksFolder = parentPath.resolve(mocksPath);

        wireMock.loadMappingsFrom(mocksFolder.toFile());
    }

    public void assertEqualsJSON(String expectedResponsePath, String actual) {
        try {
            var expectedTree = mapper.readTree(readFromFile(expectedResponsePath));
            var expectedJSONPretty = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(expectedTree);

            var currentTree = mapper.readTree(actual);
            var currentJSONPretty = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(currentTree);

            assertEquals(expectedJSONPretty, currentJSONPretty);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public String readFromFile(String filePath) throws IOException {
        return Files.readString(parentPath.resolve(filePath));
    }

    public void assertCacheSizeIsLessThanOrEqualTo(CapturedOutput output, Integer maxCacheSize) {
        var text = output.getAll();
        var regex = "Spring test ApplicationContext cache statistics:.*?size\\s*=\\s*(\\d+)";
        var pattern = Pattern.compile(regex);
        var matcher = pattern.matcher(text);

        assertThat(matcher.find())
                .withFailMessage(
                        """
                        Cannot extract the size from ApplicationContext cache statistics,
                        Be sure you have the following config in your test profile:
                        
                        logging:
                          level:
                            org:
                              springframework:
                                test:
                                  context:
                                    cache: DEBUG
                        """
                )
                .isTrue();

        var sizeValue = matcher.group(1);

        assertThat(Integer.parseInt(sizeValue))
                .withFailMessage(
                        """
                        Expected max allowed cache size $maxCacheSize, and actual was $sizeValue.
                        
                        If this assertion failed, it means new ITESTs were created and they are creating
                        new ApplicationContext, which is not cached previously. This causes the ITESTs to be
                        slow.
                        
                        As a suggestion, try to refactor your ITEST to reuse previous ApplicationContext configuration,
                        so, no new ApplicationContext is created.
                        
                        If the refactor is not possible or the use case requires a new ApplicationContext configuration,
                        update this tests to fit the new cache size.
                        """
                )
                .isLessThanOrEqualTo(maxCacheSize);
    }
}
