package com.coderstower.blog.web_security_hashing;

import org.junit.Test;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static org.assertj.core.api.Assertions.assertThat;

public class HashingExamples {
    @Test
    public void md5() throws NoSuchAlgorithmException {
        String password = "123456";

        MessageDigest messageDigest = MessageDigest.getInstance("MD5");

        byte[] digest = messageDigest.digest(password.getBytes());

        assertThat(DatatypeConverter.printHexBinary(digest))
                .isEqualTo("E10ADC3949BA59ABBE56E057F20F883E");
    }

    @Test
    public void sha() throws NoSuchAlgorithmException {
        String password = "123456";

        MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");

        byte[] digest = messageDigest.digest(password.getBytes());

        assertThat(DatatypeConverter.printHexBinary(digest))
                .isEqualTo("BA3253876AED6BC22D4A6FF53D8406C6AD864195ED144AB5C87621B6C233B548BAEAE6956DF346EC8C17F5EA10F35EE3CBC514797ED7DDD3145464E2A0BAB413");
    }
}
