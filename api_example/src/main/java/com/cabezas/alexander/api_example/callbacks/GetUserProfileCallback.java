package com.cabezas.alexander.api_example.callbacks;

import com.cabezas.alexander.api_example.models.User;

/**
 * Created by alexandercabezas on 24/10/17.
 */

public interface GetUserProfileCallback {

    void success(User user);

    void fail(int errorMessage);
}
