package com;
/*
 * @auther Renic.
 * @version 1.0
 */

public class CatNotFoundException extends RuntimeException {
    public CatNotFoundException(String message) {
        super(message);
    }
}
