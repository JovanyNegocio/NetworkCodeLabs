package com.jovanyguiagmail.networkcodelabs;

import android.content.Context;
import android.support.annotation.NonNull;

import com.jovanyguiagmail.networkcodelabs.data.DataSource;
import com.jovanyguiagmail.networkcodelabs.data.RemoteDataSource;

public class Injection {

    public static DataSource provideDataSource(@NonNull Context context){
        return new RemoteDataSource(BuildConfig.POSTS_URL);
    }
}
