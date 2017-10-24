package com.cabezas.alexander.repository_pattern.home;

/**
 * Created by alexandercabezas on 20/10/17.
 */

public class HomeContracts {

    interface View {
        void onDestroy();
    }

    interface Presenter {
        void goProfileScreen();

        void onDestroy();
    }

    interface Interactor {
        void unRegister();
    }

    interface Router {
        void unRegister();

        void presentProfileScreen();
    }

}
