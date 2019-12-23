package com.killerwilmer.javatests.payments;

public interface PaymentGateway {

  PaymentResponse requestPayment(PaymentRequest request);
}
