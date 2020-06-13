package com.coderstower.blog.web_security_digital_signatures;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.security.*;

import static org.assertj.core.api.Assertions.assertThat;

public class SignaturesExample {
  @Rule
  public ExpectedException expectedException = ExpectedException.none();
  private PrivateKey privateKey;
  private PublicKey publicKey;

  @Before
  public void before()
          throws NoSuchAlgorithmException{

    KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
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

    byte[] bytes = "love you".getBytes();

    sign.update(bytes);

    byte[] digitalSignature = sign.sign();

    Signature signVerifier = Signature
            .getInstance("SHA256withRSA");
    signVerifier.initVerify(publicKey);

    signVerifier.update(bytes);

    boolean isCorrect = signVerifier.verify(digitalSignature);

    assertThat(isCorrect).isTrue();
  }
}
