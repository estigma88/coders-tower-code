package com.coderstower.blog.web_security_digital_certificates_and_https;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import static org.assertj.core.api.Assertions.assertThat;

public class LoadCertificateExample {
  @Test
  public void load()
          throws CertificateException, IOException {
    CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");

    X509Certificate cert = (X509Certificate)certificateFactory.generateCertificate(
            Files.newInputStream(Path.of("src/test/resources/coderstower.cer")));

    assertThat(cert).isNotNull();
    assertThat(cert.getPublicKey()).isNotNull();
  }
}
