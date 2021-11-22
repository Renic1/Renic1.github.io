package com;
/*
 * @auther Renic.
 * @version 1.0
 */

public class InsufficientBalanceException extends RuntimeException {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}
