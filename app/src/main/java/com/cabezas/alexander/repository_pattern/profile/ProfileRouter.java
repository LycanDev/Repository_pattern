package com.cabezas.alexander.repository_pattern.profile;

import android.app.Activity;

/**
 * Created by alexandercabezas on 20/10/17.
 */

public class ProfileRouter implements ProfileContracts.Router {


    private Activity activity;

    public ProfileRouter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void unRegister() {
        activity = null;
    }
}
