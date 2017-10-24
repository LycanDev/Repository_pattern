package com.cabezas.alexander.repository_pattern.home;

import android.app.Activity;

/**
 * Created by alexandercabezas on 20/10/17.
 */

public class HomePresenter implements HomeContracts.Presenter {

    private HomeContracts.Interactor interactor;
    private HomeContracts.Router router;

    HomePresenter(HomeContracts.View view) {
        interactor = new HomeInteractor();
        router = new HomeRouter((Activity) view);
    }

    @Override
    public void onDestroy() {
        interactor.unRegister();
        interactor = null;
        router.unRegister();
        router = null;
    }

    @Override
    public void goProfileScreen() {
        router.presentProfileScreen();
    }

}
