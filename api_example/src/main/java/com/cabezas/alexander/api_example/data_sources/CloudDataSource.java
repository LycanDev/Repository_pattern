package com.cabezas.alexander.api_example.data_sources;

import com.cabezas.alexander.api_example.R;
import com.cabezas.alexander.api_example.callbacks.GetUserProfileCallback;
import com.cabezas.alexander.api_example.callbacks.UserLoginCallback;
import com.cabezas.alexander.api_example.models.User;

/**
 * Created by alexandercabezas on 24/10/17.
 */

public class CloudDataSource implements DataSource{
    @Override
    public void loginUser(String userName, String password, UserLoginCallback userLoginCallback) {
        if(userName.equals("username") && password.equals("12345")) {
            userLoginCallback.success();
        } else {
            userLoginCallback.fail(R.string.login_failed);
        }
    }

    @Override
    public void getUserProfile(String userName, GetUserProfileCallback userProfileCallback) {
        if(userName.equals("username")) {

            User user = new User();
            user.setId("123");
            user.setName("name");
            user.setLastName("lastName");
            user.setUserName("username");

            userProfileCallback.success(user);
        } else {
            userProfileCallback.fail(R.string.profile_failed);
        }
    }
}
