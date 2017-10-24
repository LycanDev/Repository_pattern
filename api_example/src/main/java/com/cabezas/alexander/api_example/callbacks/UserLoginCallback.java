package com.cabezas.alexander.api_example.callbacks;

/**
 * Created by alexandercabezas on 24/10/17.
 */

public interface UserLoginCallback {

    void success();

    void fail(int errorMessage);
}
