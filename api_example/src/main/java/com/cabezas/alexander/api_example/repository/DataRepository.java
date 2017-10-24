package com.cabezas.alexander.api_example.repository;

import com.cabezas.alexander.api_example.callbacks.GetUserProfileCallback;
import com.cabezas.alexander.api_example.callbacks.UserLoginCallback;
import com.cabezas.alexander.api_example.data_sources.DataSource;
import com.cabezas.alexander.api_example.factory.DataSourceFactory;

/**
 * Created by alexandercabezas on 24/10/17.
 */

public class DataRepository implements Repository{

    private static Repository sRepository;

    private DataRepository(){
        //only to defeat instantiation
    }

    public static Repository getInstance() {

        if(sRepository == null) {
            sRepository = new DataRepository();
        }
        return  sRepository;
    }

    @Override
    public void loginUser(String userName, String password, UserLoginCallback userLoginCallback) {
        DataSource dataSource = DataSourceFactory.create();
        dataSource.loginUser(userName, password, userLoginCallback);
    }

    @Override
    public void getUserProfile(String username, GetUserProfileCallback userProfileCallback) {
        DataSource dataSource = DataSourceFactory.create();
        dataSource.getUserProfile(username, userProfileCallback);

    }
}
