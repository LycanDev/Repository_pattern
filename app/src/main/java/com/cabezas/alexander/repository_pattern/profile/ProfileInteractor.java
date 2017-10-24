package com.cabezas.alexander.repository_pattern.profile;

import com.cabezas.alexander.api_example.ExampleApiImpl;
import com.cabezas.alexander.api_example.callbacks.GetUserProfileCallback;
import com.cabezas.alexander.api_example.models.User;

/**
 * Created by alexandercabezas on 20/10/17.
 */

public class ProfileInteractor implements ProfileContracts.Interactor {

    private ProfileContracts.InteractorOutput output;

    public ProfileInteractor(ProfileContracts.InteractorOutput output) {
        this.output = output;
    }

    @Override
    public void getUser(String userName) {
        ExampleApiImpl.getInstance().getProfile(userName, new GetUserProfileCallback() {
            @Override
            public void success(User user) {
                output.getUserSuccess(user);
            }

            @Override
            public void fail(int errorMessage) {
                output.getUserFail(errorMessage);
            }
        });

    }

    @Override
    public void unRegister() {
        output = null;
    }
}
