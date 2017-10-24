package com.cabezas.alexander.repository_pattern.profile;

import com.cabezas.alexander.api_example.models.User;

import android.app.Activity;

/**
 * Created by alexandercabezas on 20/10/17.
 */

public class ProfilePresenter implements ProfileContracts.Presenter, ProfileContracts.InteractorOutput {
    private ProfileContracts.View mView;
    private ProfileContracts.Interactor interactor;
    private ProfileContracts.Router router;

    ProfilePresenter(ProfileContracts.View view) {
        interactor = new ProfileInteractor(this);
        router = new ProfileRouter((Activity) view);
        mView = view;
    }

    @Override
    public void onDestroy() {
        interactor.unRegister();
        interactor = null;
        router.unRegister();
        router = null;
    }


    @Override
    public void getUserProfile(String userName) {
        interactor.getUser(userName);
    }

    @Override
    public void getUserSuccess(User user) {

    }

    @Override
    public void getUserFail(int error) {
        mView.showError(error);
    }
}
