package com.killerwilmer.lambdas;

public class Main {
  public static void main(String[] args) {

    OnOneListener onOneListener =
        new OnOneListener() {
          @Override
          public void onOne(String message) {

            System.out.println("One: " + message);
          }
        };

    OnOneListener onOneListener1 =
        (String message) -> System.out.println("One lambda :) " + message);

    onOneListener.onOne("Sin Lambda :(");

    onOneListener1.onOne("Con Lambda :)");
  }
}
