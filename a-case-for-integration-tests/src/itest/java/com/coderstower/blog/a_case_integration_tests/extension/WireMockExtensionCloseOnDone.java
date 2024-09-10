package com.coderstower.blog.a_case_integration_tests.extension;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.Options;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.http.JvmProxyConfigurer;
import com.github.tomakehurst.wiremock.junit.DslWrapper;
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo;
import org.junit.jupiter.api.extension.*;

import java.util.Optional;

public class WireMockExtensionCloseOnDone extends DslWrapper implements ParameterResolver, BeforeEachCallback, BeforeAllCallback, AfterEachCallback, AfterAllCallback, ExtensionContext.Store.CloseableResource {
    private ExtensionContext.Namespace wiremockNamespace = ExtensionContext.Namespace.create(
            "com.geniussports.geniuslive.wiremock");
    private static final Options DEFAULT_OPTIONS = WireMockConfiguration.options()
            .dynamicPort();
    private final boolean configureStaticDsl;
    private final boolean failOnUnmatchedRequests;
    private Options options;
    private WireMockServer wireMockServer;
    private WireMockRuntimeInfo runtimeInfo;
    private boolean isNonStatic;
    private Boolean proxyMode;

    private WireMockExtensionCloseOnDone(
            Options options,
            boolean configureStaticDsl,
            boolean failOnUnmatchedRequests,
            boolean proxyMode) {
        this.isNonStatic = false;
        this.options = options;
        this.configureStaticDsl = configureStaticDsl;
        this.failOnUnmatchedRequests = failOnUnmatchedRequests;
        this.proxyMode = proxyMode;
    }

    public static WireMockExtensionCloseOnDone.Builder newInstance() {
        return new Builder();
    }

    public boolean supportsParameter(
            ParameterContext parameterContext,
            ExtensionContext extensionContext) throws ParameterResolutionException {
        return this.parameterIsWireMockRuntimeInfo(
                parameterContext);
    }

    public Object resolveParameter(
            ParameterContext parameterContext,
            ExtensionContext extensionContext) throws ParameterResolutionException {
        return this.parameterIsWireMockRuntimeInfo(
                parameterContext) ? this.runtimeInfo : null;
    }

    private void startServerIfRequired(
            ExtensionContext extensionContext) {
        if (this.wireMockServer == null || !this.wireMockServer.isRunning()) {
            this.wireMockServer = new WireMockServer(
                    Optional.ofNullable(this.options)
                            .orElse(DEFAULT_OPTIONS));
            this.wireMockServer.start();
            this.runtimeInfo = new WireMockRuntimeInfo(
                    this.wireMockServer);
            this.admin = this.wireMockServer;
            this.stubbing = this.wireMockServer;
            if (this.configureStaticDsl) {
                WireMock.configureFor(
                        new WireMock(this));
            }

            this.getStore(extensionContext)
                    .put("WireMockExtensionCloseOnDone",
                            this);
        }

    }

    private void stopServerIfRunning() {
        if (this.wireMockServer.isRunning()) {
            this.wireMockServer.stop();
        }

    }

    private boolean parameterIsWireMockRuntimeInfo(
            ParameterContext parameterContext) {
        return parameterContext.getParameter()
                .getType()
                .equals(WireMockRuntimeInfo.class);
    }

    public final void beforeAll(
            ExtensionContext context) throws Exception {
        this.startServerIfRequired(context);
    }

    public final void beforeEach(
            ExtensionContext context) throws Exception {
        if (this.wireMockServer == null) {
            this.isNonStatic = true;
            this.startServerIfRequired(context);
        } else {
            this.resetToDefaultMappings();
        }

        if (this.proxyMode) {
            JvmProxyConfigurer.configureFor(
                    this.wireMockServer);
        }
    }

    public final void afterAll(
            ExtensionContext context) throws Exception {
        // Do nothing
    }

    public final void afterEach(
            ExtensionContext context) throws Exception {
        if (this.failOnUnmatchedRequests) {
            this.wireMockServer.checkForUnmatchedRequests();
        }

        if (this.isNonStatic) {
            this.stopServerIfRunning();
        }

        if (this.proxyMode) {
            JvmProxyConfigurer.restorePrevious();
        }
    }

    public String url(String path) {
        return this.wireMockServer.url(path);
    }

    private ExtensionContext.Store getStore(
            ExtensionContext context) {
        return context.getRoot()
                .getStore(wiremockNamespace);
    }

    @Override
    public void close() throws Throwable {
        System.out.println(
                "Stops the server after the test suite is finished");

        stopServerIfRunning();
    }

    public static class Builder {
        private Options options = WireMockConfiguration.wireMockConfig()
                .dynamicPort();
        private boolean configureStaticDsl = false;
        private boolean failOnUnmatchedRequests = false;
        private boolean proxyMode = false;

        public Builder() {
        }

        public WireMockExtensionCloseOnDone.Builder options(
                Options options) {
            this.options = options;
            return this;
        }

        public WireMockExtensionCloseOnDone.Builder configureStaticDsl(
                boolean configureStaticDsl) {
            this.configureStaticDsl = configureStaticDsl;
            return this;
        }

        public WireMockExtensionCloseOnDone.Builder failOnUnmatchedRequests(
                boolean failOnUnmatched) {
            this.failOnUnmatchedRequests = failOnUnmatched;
            return this;
        }

        public WireMockExtensionCloseOnDone.Builder proxyMode(
                boolean proxyMode) {
            this.proxyMode = proxyMode;
            return this;
        }

        public WireMockExtensionCloseOnDone build() {
            if (this.proxyMode && !this.options.browserProxySettings()
                    .enabled() && this.options instanceof WireMockConfiguration) {
                ((WireMockConfiguration) this.options).enableBrowserProxying(
                        true);
            }

            return new WireMockExtensionCloseOnDone(
                    this.options,
                    this.configureStaticDsl,
                    this.failOnUnmatchedRequests,
                    this.proxyMode);
        }
    }
}
