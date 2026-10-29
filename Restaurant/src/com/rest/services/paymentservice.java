
package com.rest.services;

import com.rest.models.payment;
import com.rest.repository.paymentrepository;

import java.util.List;

public class paymentservice {

    private final paymentrepository repository;
    private int nextPaymentId = 1;

    public paymentservice() {
        repository = new paymentrepository();
    }

    public payment createPayment(
            int orderId,
            double amount,
            payment.PaymentMethod method) {

        if (orderId <= 0) {
            throw new IllegalArgumentException(
                "Invalid Order ID!"
            );
        }

        if (amount <= 0) {
            throw new IllegalArgumentException(
                "Payment amount must be greater than zero!"
            );
        }

        if (method == null) {
            throw new IllegalArgumentException(
                "Please select a payment method!"
            );
        }

        payment newPayment = new payment(
            nextPaymentId++,
            orderId,
            amount,
            method
        );

        repository.save(newPayment);

        return newPayment;
    }

    public payment updatePaymentStatus(
            int paymentId,
            payment.PaymentStatus status) {

        payment existingPayment =
                repository.findById(paymentId);

        if (existingPayment == null) {
            throw new IllegalArgumentException(
                "Payment not found!"
            );
        }

        if (status == null) {
            throw new IllegalArgumentException(
                "Invalid payment status!"
            );
        }

        existingPayment.setstatus(status);

        return existingPayment;
    }

    public List<payment> getAllPayments() {
        return repository.findall();
    }

    public payment getPaymentById(int paymentId) {
        return repository.findById(paymentId);
    }
}
