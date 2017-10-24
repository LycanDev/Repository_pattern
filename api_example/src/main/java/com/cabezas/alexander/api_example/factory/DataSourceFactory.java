package com.cabezas.alexander.api_example.factory;

import com.cabezas.alexander.api_example.data_sources.CloudDataSource;
import com.cabezas.alexander.api_example.data_sources.DataSource;
import com.cabezas.alexander.api_example.data_sources.LocalDataSource;

import android.provider.ContactsContract;

import java.util.Random;

/**
 * Created by alexandercabezas on 24/10/17.
 */

public class DataSourceFactory {

    private static CloudDataSource sCloudDataSource;

    private static LocalDataSource sLocalDataSource;

    private static int chooseDataSource() {
        int min = 1;
        int max = 2;

        Random r = new Random();
        int i1 = r.nextInt(max - min + 1) + min;

        return i1;
    }

    public static DataSource create() {

        int dataSource = chooseDataSource();

        if(dataSource == 1) {

            if(sCloudDataSource == null) {
                sCloudDataSource = new CloudDataSource();
            }

            return sCloudDataSource;

        } else {
            if(sLocalDataSource == null) {
                sLocalDataSource = new LocalDataSource();
            }
            return sLocalDataSource;
        }

    }
}
