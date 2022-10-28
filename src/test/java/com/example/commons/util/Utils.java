package com.example.commons.util;

import java.util.concurrent.ThreadLocalRandom;
import org.apache.commons.lang3.RandomStringUtils;

public class Utils {

  public static String Unique() {
    return RandomStringUtils.random(10, "abcdefghijklmnopqrstuvwxyz!#$%&'*+-/=?^_`{|}~0123456789")
        + "@qaautosuite.com";
  }

  public static String generateRandomPhoneNumber(int length) {
    length = Math.min(length, 10);

    return (ThreadLocalRandom.current().nextInt(10000000, 999999999) + "99")
        .substring(0, length);
  }
}
