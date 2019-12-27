package com.killerwilmer.javatests.numbers;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FizzBuzzTest {

  @Test
  public void test_return_fizz_when_number_is_divisible_by_3_number_3() {

    FizzBuzz fizzBuzz = new FizzBuzz();

    assertThat(fizzBuzz.getFizzBuzz(3), is("Fizz"));
  }

  @Test
  public void test_return_fizz_when_number_is_divisible_by_3_number_6() {

    FizzBuzz fizzBuzz = new FizzBuzz();

    assertThat(fizzBuzz.getFizzBuzz(6), is("Fizz"));
  }

  @Test
  public void test_return_buzz_when_number_is_divisible_by_5_number_5() {

    FizzBuzz fizzBuzz = new FizzBuzz();

    assertThat(fizzBuzz.getFizzBuzz(5), is("Buzz"));
  }

  @Test
  public void test_return_buzz_when_number_is_divisible_by_5_number_10() {

    FizzBuzz fizzBuzz = new FizzBuzz();

    assertThat(fizzBuzz.getFizzBuzz(10), is("Buzz"));
  }

  @Test
  public void test_return_FizzBuzz_when_number_is_divisible_by_3_and_5_number_15() {

    FizzBuzz fizzBuzz = new FizzBuzz();

    assertThat(fizzBuzz.getFizzBuzz(15), is("FizzBuzz"));
  }

  @Test
  public void test_return_FizzBuzz_when_number_is_divisible_by_3_and_5_number_30() {

    FizzBuzz fizzBuzz = new FizzBuzz();

    assertThat(fizzBuzz.getFizzBuzz(30), is("FizzBuzz"));
  }

  @Test
  public void test_return_same_number_when_number_is_other_number_2() {

    FizzBuzz fizzBuzz = new FizzBuzz();

    assertThat(fizzBuzz.getFizzBuzz(2), is("2"));
  }

  @Test
  public void test_return_same_number_when_number_is_other_number_16() {

    FizzBuzz fizzBuzz = new FizzBuzz();

    assertThat(fizzBuzz.getFizzBuzz(16), is("16"));
  }
}
