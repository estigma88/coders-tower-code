package com.coderstower.blog.web_security_symmetric_and_asymmetric_cryptography;

import org.junit.Before;
import org.junit.Test;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import static org.assertj.core.api.Assertions.assertThat;

public class SymmetricKeyExamples {
  private SecretKeySpec secretKey;

  @Before
  public void before()
          throws UnsupportedEncodingException,
          NoSuchAlgorithmException {
    String plainKey = "my secret";

    byte[] key = plainKey.getBytes("UTF-8");

    MessageDigest sha = MessageDigest
            .getInstance("SHA-1");
    key = sha.digest(key);
    key = Arrays.copyOf(key, 16);

    secretKey = new SecretKeySpec(key,
            "AES");
  }

  @Test
  public void encrypt()
          throws NoSuchAlgorithmException,
          UnsupportedEncodingException,
          NoSuchPaddingException, InvalidKeyException,
          BadPaddingException,
          IllegalBlockSizeException {

    String plainText = "love you";

    Cipher cipher = Cipher
            .getInstance("AES/ECB/PKCS5Padding");
    cipher.init(Cipher.ENCRYPT_MODE, secretKey);

    String nonSenseText = Base64.getEncoder()
            .encodeToString(cipher.doFinal(
                    plainText.getBytes("UTF-8")));

    assertThat(nonSenseText)
            .isEqualTo("8wFONZ+k8VTBh7c0RFhBRg==");
  }

  @Test
  public void decrypt()
          throws NoSuchAlgorithmException,
          NoSuchPaddingException,
          UnsupportedEncodingException,
          InvalidKeyException, BadPaddingException,
          IllegalBlockSizeException {

    String nonSenseText = "8wFONZ+k8VTBh7c0RFhBRg==";

    Cipher cipher = Cipher
            .getInstance("AES/ECB/PKCS5Padding");
    cipher.init(Cipher.DECRYPT_MODE, secretKey);

    String plainText = new String(
            cipher.doFinal(Base64.getDecoder()
                    .decode(nonSenseText)));

    assertThat(plainText).isEqualTo("love you");
  }
}
