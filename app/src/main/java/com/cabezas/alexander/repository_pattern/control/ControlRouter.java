package com.cabezas.alexander.repository_pattern.control;


import com.cabezas.alexander.repository_pattern.login.LoginActivity;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by alexandercabezas on 20/10/17.
 */

public class ControlRouter implements ControlContracts.Router {

    private Activity activity;

    public ControlRouter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void unRegister() {
        activity = null;
    }

    @Override
    public void presentLoginScreen() {
        Intent intent = new Intent(activity, LoginActivity.class);
        activity.startActivity(intent);
    }
}
