package com.coderstower.blog.web_security_symmetric_and_asymmetric_cryptography;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Base64;

import static org.assertj.core.api.Assertions.assertThat;

public class AsymmetricKeyExamples {
  @Rule
  public ExpectedException expectedException = ExpectedException.none();
  private PrivateKey privateKey;
  private PublicKey publicKey;

  @Before
  public void before()
          throws NoSuchAlgorithmException,
          IOException, InvalidKeySpecException {
    Path pathKeys = Paths.get("src", "test", "resources", "keys");

    if(Files.exists(pathKeys)) {
      KeyFactory keyFactory = KeyFactory.getInstance("RSA");

      X509EncodedKeySpec publicKeyEncoded = new X509EncodedKeySpec(Files.readAllBytes(pathKeys.resolve("publicKey.key")));
      PKCS8EncodedKeySpec privateKeyEncoded = new PKCS8EncodedKeySpec(Files.readAllBytes(pathKeys.resolve("privateKey.key")));

      publicKey = keyFactory.generatePublic(publicKeyEncoded);
      privateKey = keyFactory.generatePrivate(privateKeyEncoded);

    }else{
      KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
      keyGen.initialize(1024);

      KeyPair pair = keyGen.generateKeyPair();

      privateKey = pair.getPrivate();
      publicKey = pair.getPublic();

      Files.createDirectories(pathKeys);
      Files.write(pathKeys.resolve("publicKey.key"), publicKey.getEncoded());
      Files.write(pathKeys.resolve("privateKey.key"), privateKey.getEncoded());
    }

  }

  @Test
  public void encryptWithPublicKey_decryptWithPrivateKey()
          throws NoSuchAlgorithmException,
          UnsupportedEncodingException,
          NoSuchPaddingException, InvalidKeyException,
          BadPaddingException,
          IllegalBlockSizeException {

    String plainText = "love you";

    Cipher cipherEncrypt = Cipher
            .getInstance("RSA/ECB/PKCS1Padding");
    cipherEncrypt.init(Cipher.ENCRYPT_MODE, publicKey);

    String nonSenseText = Base64.getEncoder()
            .encodeToString(cipherEncrypt.doFinal(
                    plainText.getBytes("UTF-8")));

    System.out.println(nonSenseText);

    Cipher cipherDecrypt = Cipher
            .getInstance("RSA/ECB/PKCS1Padding");
    cipherDecrypt.init(Cipher.DECRYPT_MODE, privateKey);

    String newPlainText = new String(
            cipherDecrypt.doFinal(Base64.getDecoder()
                    .decode(nonSenseText)));

    assertThat(newPlainText)
            .isEqualTo(plainText);
  }

  @Test
  public void encryptWithPrivateKey_decryptWithPublicKey()
          throws NoSuchAlgorithmException,
          UnsupportedEncodingException,
          NoSuchPaddingException, InvalidKeyException,
          BadPaddingException,
          IllegalBlockSizeException {

    String plainText = "love you";

    Cipher cipherEncrypt = Cipher
            .getInstance("RSA/ECB/PKCS1Padding");
    cipherEncrypt.init(Cipher.ENCRYPT_MODE, privateKey);

    String nonSenseText = Base64.getEncoder()
            .encodeToString(cipherEncrypt.doFinal(
                    plainText.getBytes("UTF-8")));

    System.out.println(nonSenseText);

    Cipher cipherDecrypt = Cipher
            .getInstance("RSA/ECB/PKCS1Padding");
    cipherDecrypt.init(Cipher.DECRYPT_MODE, publicKey);

    String newPlainText = new String(
            cipherDecrypt.doFinal(Base64.getDecoder()
                    .decode(nonSenseText)));

    assertThat(newPlainText)
            .isEqualTo(plainText);
  }

  @Test
  public void encryptWithPrivateKey_decryptWithPrivateKey()
          throws NoSuchAlgorithmException,
          UnsupportedEncodingException,
          NoSuchPaddingException, InvalidKeyException,
          BadPaddingException,
          IllegalBlockSizeException {

    expectedException.expect(BadPaddingException.class);
    expectedException.expectMessage("Decryption error");

    String plainText = "love you";

    Cipher cipherEncrypt = Cipher
            .getInstance("RSA/ECB/PKCS1Padding");
    cipherEncrypt.init(Cipher.ENCRYPT_MODE, privateKey);

    String nonSenseText = Base64.getEncoder()
            .encodeToString(cipherEncrypt.doFinal(
                    plainText.getBytes("UTF-8")));

    System.out.println(nonSenseText);

    Cipher cipherDecrypt = Cipher
            .getInstance("RSA/ECB/PKCS1Padding");
    cipherDecrypt.init(Cipher.DECRYPT_MODE, privateKey);

    cipherDecrypt.doFinal(Base64.getDecoder()
                    .decode(nonSenseText));
  }

  @Test
  public void encryptWithPublicKey_decryptWithPublicKey()
          throws NoSuchAlgorithmException,
          UnsupportedEncodingException,
          NoSuchPaddingException, InvalidKeyException,
          BadPaddingException,
          IllegalBlockSizeException {

    expectedException.expect(BadPaddingException.class);
    expectedException.expectMessage("Decryption error");

    String plainText = "love you";

    Cipher cipherEncrypt = Cipher
            .getInstance("RSA/ECB/PKCS1Padding");
    cipherEncrypt.init(Cipher.ENCRYPT_MODE, publicKey);

    String nonSenseText = Base64.getEncoder()
            .encodeToString(cipherEncrypt.doFinal(
                    plainText.getBytes("UTF-8")));

    System.out.println(nonSenseText);

    Cipher cipherDecrypt = Cipher
            .getInstance("RSA/ECB/PKCS1Padding");
    cipherDecrypt.init(Cipher.DECRYPT_MODE, publicKey);

    cipherDecrypt.doFinal(Base64.getDecoder()
            .decode(nonSenseText));
  }
}
