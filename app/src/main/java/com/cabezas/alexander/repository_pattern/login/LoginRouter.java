package com.cabezas.alexander.repository_pattern.login;


import com.cabezas.alexander.repository_pattern.home.HomeActivity;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by alexandercabezas on 20/10/17.
 */

public class LoginRouter implements LoginContracts.Router {

    private Activity activity;

    public LoginRouter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void unRegister() {
        activity = null;
    }

    @Override
    public void presentHomeScreen() {
        Intent intent = new Intent(activity, HomeActivity.class);
        activity.startActivity(intent);
    }
}
