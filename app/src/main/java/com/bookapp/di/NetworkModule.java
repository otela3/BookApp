package com.bookapp.di;

import android.app.Application;

import androidx.core.content.PermissionChecker;

import com.bookapp.network.LibroApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


@Module
@InstallIn(ApplicationComponent.class)
public class NetworkModule {

    @Provides
    @Singleton
    public static LibroApiService provideLibroApiService(){
        return new Retrofit.Builder()
                .baseUrl("https://www.etnassoft.com/api/v1/get/?num_items=30")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
                .create(LibroApiService.class);
    }
}
