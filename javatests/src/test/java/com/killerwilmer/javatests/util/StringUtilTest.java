package com.killerwilmer.javatests.util;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilTest {

  @Test
  public void test_repeat_string_once() {

    Assert.assertEquals("hola", StringUtil.repeat("hola", 1));
  }

  @Test
  public void test_repeat_string_multiple_times() {

    Assert.assertEquals("holaholahola", StringUtil.repeat("hola", 3));
  }

  @Test
  public void test_repeat_string_zero_times() {

    Assert.assertEquals("", StringUtil.repeat("hola", 0));
  }

  @Test(expected = IllegalArgumentException.class)
  public void test_repeat_string_negative_times() {

    StringUtil.repeat("hola", -1);
  }

  @Test
  public void test_string_is_not_empty() {

    Assert.assertFalse(StringUtil.isEmpty("text"));
  }

  @Test
  public void test_string_only_double_quotes_is_empty() {

    Assert.assertTrue(StringUtil.isEmpty(""));
  }

  @Test
  public void test_null_is_empty() {

    Assert.assertTrue(StringUtil.isEmpty(null));
  }

  @Test
  public void test_string_only_spaces_is_empty() {

    Assert.assertTrue(StringUtil.isEmpty("     "));
  }
}
