package com.cabezas.alexander.repository_pattern.profile;

import com.cabezas.alexander.api_example.models.User;

/**
 * Created by alexandercabezas on 20/10/17.
 */

public class ProfileContracts {

    interface View {
        void onDestroy();

        void showError(int id);
    }

    interface Presenter {
        void onDestroy();

        void getUserProfile(String userName);
    }

    interface Interactor {
        void getUser(String userName);

        void unRegister();
    }

    interface InteractorOutput {
        void getUserSuccess(User user);

        void getUserFail(int error);
    }


    interface Router {
        void unRegister();
    }
}
