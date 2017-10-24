package com.cabezas.alexander.repository_pattern.login;

/**
 * Created by alexandercabezas on 20/10/17.
 */

public class LoginContracts {

    interface View {
        void onDestroy();

        void showError(int id);
    }

    interface Presenter {
        void onDestroy();

        void onLoginButtonPressed(String userName, String password);
    }

    interface Interactor {
        void loginUser(String userName, String password);

        void unRegister();
    }

    interface InteractorOutput {
        void loginResultSuccess();

        void loginResultFail(int error);
    }


    interface Router {
        void unRegister();

        void presentHomeScreen();
    }
}
