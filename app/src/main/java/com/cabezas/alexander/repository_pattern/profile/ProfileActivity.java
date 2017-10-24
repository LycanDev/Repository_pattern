package com.cabezas.alexander.repository_pattern.profile;


import com.cabezas.alexander.repository_pattern.R;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity implements ProfileContracts.View {

    private ProfileContracts.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mPresenter = new ProfilePresenter(this);
        mPresenter.getUserProfile("username");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void showError(int id) {
        String message = getResources().getString(id);
        Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);
        toast.show();
    }
}
