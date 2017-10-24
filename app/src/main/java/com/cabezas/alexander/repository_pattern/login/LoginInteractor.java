package com.cabezas.alexander.repository_pattern.login;

import com.cabezas.alexander.api_example.ExampleApiImpl;
import com.cabezas.alexander.api_example.callbacks.UserLoginCallback;

/**
 * Created by alexandercabezas on 20/10/17.
 */

public class LoginInteractor implements LoginContracts.Interactor {

    private LoginContracts.InteractorOutput output;

    public LoginInteractor(LoginContracts.InteractorOutput output) {
        this.output = output;
    }

    @Override
    public void loginUser(String userName, String password) {

        ExampleApiImpl.getInstance().loginUser(userName, password, new UserLoginCallback() {
            @Override
            public void success() {
                output.loginResultSuccess();
            }

            @Override
            public void fail(int errorMessage) {
                output.loginResultFail(errorMessage);
            }
        });

    }

    @Override
    public void unRegister() {
        output = null;
    }
}
