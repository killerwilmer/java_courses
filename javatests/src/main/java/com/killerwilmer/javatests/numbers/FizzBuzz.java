package com.killerwilmer.javatests.numbers;

public class FizzBuzz {

  public String getFizzBuzz(int number) {

    String strReturn = "";

    if (number % 3 == 0) {
      strReturn = "Fizz";
    }
    if (number % 5 == 0) {
      strReturn += "Buzz";
    }
    if (strReturn.equals("")) return number + "";
    return strReturn;
  }
}
