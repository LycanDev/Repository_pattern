package com.cabezas.alexander.api_example.repository;

import com.cabezas.alexander.api_example.callbacks.GetUserProfileCallback;
import com.cabezas.alexander.api_example.callbacks.UserLoginCallback;

/**
 * Created by alexandercabezas on 24/10/17.
 */

public interface Repository {

    void loginUser(String userName, String password, UserLoginCallback userLoginCallback);

    void getUserProfile(String username, GetUserProfileCallback userProfileCallback);
}
