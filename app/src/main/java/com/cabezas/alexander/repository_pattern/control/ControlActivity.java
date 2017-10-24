package com.cabezas.alexander.repository_pattern.control;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class ControlActivity extends AppCompatActivity implements ControlContracts.View {

    private ControlContracts.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter = new ControlPresenter(this);
        mPresenter.goToLoginScreen();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }
}
