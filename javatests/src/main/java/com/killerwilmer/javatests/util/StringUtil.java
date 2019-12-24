package com.killerwilmer.javatests.util;

public class StringUtil {

  public static String repeat(String str, int times) {

    if (times < 0) {
      throw new IllegalArgumentException("negative times not allowed");
    }

    String result = "";

    for (int i = 0; i < times; i++) {
      result += str;
    }
    return result;
  }

  public static boolean isEmpty(String str) {

    if (str == null) return true;

    if (str.trim().length() > 0) {
      return false;
    } else {
      return true;
    }
  }
}
