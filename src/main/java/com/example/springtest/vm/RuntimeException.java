package com.example.springtest.vm;

public class RuntimeException extends Exception {
    private String _msg;

    public RuntimeException(String msg) {
        this._msg = msg;
    }

}
