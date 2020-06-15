package com.coderstower.blog.web_security_digital_signatures;

import org.junit.Before;
import org.junit.Test;

import java.security.*;

import static org.assertj.core.api.Assertions.assertThat;

public class SignaturesExample {
  private PrivateKey privateKey;
  private PublicKey publicKey;

  @Before
  public void before()
          throws NoSuchAlgorithmException {
    KeyPairGenerator keyGen = KeyPairGenerator
            .getInstance("RSA");
    keyGen.initialize(2048);

    KeyPair pair = keyGen.generateKeyPair();

    privateKey = pair.getPrivate();
    publicKey = pair.getPublic();
  }

  @Test
  public void signAndVerify()
          throws SignatureException,
          NoSuchAlgorithmException,
          InvalidKeyException {

    Signature sign = Signature
            .getInstance("SHA256withRSA");
    sign.initSign(privateKey);

    byte[] originalMessage = "love you".getBytes();
    sign.update(originalMessage);

    byte[] digitalSignature = sign.sign();

    Signature signVerifier = Signature
            .getInstance("SHA256withRSA");
    signVerifier.initVerify(publicKey);

    byte[] currentMessage = "love you".getBytes();

    signVerifier.update(currentMessage);

    boolean isCorrect = signVerifier
            .verify(digitalSignature);

    assertThat(isCorrect).isTrue();
  }

  @Test
  public void signAndVerifyError()
          throws SignatureException,
          NoSuchAlgorithmException,
          InvalidKeyException {

    Signature sign = Signature
            .getInstance("SHA256withRSA");
    sign.initSign(privateKey);

    byte[] originalMessage = "love you".getBytes();
    sign.update(originalMessage);

    byte[] digitalSignature = sign.sign();

    Signature signVerifier = Signature
            .getInstance("SHA256withRSA");
    signVerifier.initVerify(publicKey);

    byte[] currentMessage = "hate you".getBytes();

    signVerifier.update(currentMessage);

    boolean isCorrect = signVerifier
            .verify(digitalSignature);

    assertThat(isCorrect).isFalse();
  }
}
