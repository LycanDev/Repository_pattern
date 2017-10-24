package com.cabezas.alexander.api_example;

import com.cabezas.alexander.api_example.callbacks.GetUserProfileCallback;
import com.cabezas.alexander.api_example.callbacks.UserLoginCallback;

/**
 * Created by alexandercabezas on 24/10/17.
 */

public interface ExampleApi {

    void loginUser(String username, String password, UserLoginCallback userLoginCallback);

    void getProfile(String userName, GetUserProfileCallback getUserProfileCallback);
}
