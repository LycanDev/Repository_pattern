package com.cabezas.alexander.api_example;

import com.cabezas.alexander.api_example.callbacks.GetUserProfileCallback;
import com.cabezas.alexander.api_example.callbacks.UserLoginCallback;
import com.cabezas.alexander.api_example.repository.DataRepository;

/**
 * Created by alexandercabezas on 24/10/17.
 */

public class ExampleApiImpl implements ExampleApi {

    private static ExampleApi sExampleApi;

    private ExampleApiImpl() {
        //only exists ti defeat instantiation
    }

    public static ExampleApi getInstance() {

        if(sExampleApi == null) {
            sExampleApi = new ExampleApiImpl();
        }

        return sExampleApi;

    }

    @Override
    public void loginUser(String username, String password, UserLoginCallback userLoginCallback) {
        DataRepository.getInstance().loginUser(username, password, userLoginCallback);
    }

    @Override
    public void getProfile(String userName, GetUserProfileCallback getUserProfileCallback) {

        DataRepository.getInstance().getUserProfile(userName, getUserProfileCallback);
    }
}
