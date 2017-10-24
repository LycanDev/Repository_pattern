package com.cabezas.alexander.repository_pattern.home;


import com.cabezas.alexander.repository_pattern.profile.ProfileActivity;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by alexandercabezas on 20/10/17.
 */

public class HomeRouter implements HomeContracts.Router {

    private Activity activity;

    public HomeRouter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void unRegister() {
        activity = null;
    }

    @Override
    public void presentProfileScreen() {
        Intent intent = new Intent(activity, ProfileActivity.class);
        activity.startActivity(intent);
    }
}
