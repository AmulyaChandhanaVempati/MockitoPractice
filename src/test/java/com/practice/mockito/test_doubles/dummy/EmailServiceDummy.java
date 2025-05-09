package com.practice.mockito.test_doubles.dummy;

public class EmailServiceDummy implements EmailService {
    @Override
    public void sendEmail(String message) {
        throw new AssertionError("Method not implemented !!!");
    }
}
