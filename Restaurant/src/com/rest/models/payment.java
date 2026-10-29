
package com.rest.models;

public class payment {

    public enum PaymentMethod {
        CASH,
        CARD,
        UPI
    }

    public enum PaymentStatus {
        PENDING,
        SUCCESS,
        FAILED
    }

    private int id;
    private int orderId;
    private double amount;
    private PaymentMethod method;
    private PaymentStatus status;

    public payment(int id, int orderId, double amount,
                   PaymentMethod method) {
        this.id = id;
        this.orderId = orderId;
        this.amount = amount;
        this.method = method;
        this.status = PaymentStatus.PENDING;
    }

    public int getid() {
        return id;
    }

    public int getorderId() {
        return orderId;
    }

    public double getamount() {
        return amount;
    }

    public PaymentMethod getmethod() {
        return method;
    }

    public PaymentStatus getstatus() {
        return status;
    }

    public void setstatus(PaymentStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Payment ID: " + id
                + ", Order ID: " + orderId
                + ", Amount: Rs. " + amount
                + ", Method: " + method
                + ", Status: " + status;
    }
}
