package com.bookapp.di;

import android.app.Application;

import androidx.room.Room;

import com.bookapp.db.LibroDB;
import com.bookapp.db.LibroDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;

@Module
@InstallIn(ApplicationComponent.class)
public class DataBaseModule {

    @Provides
    @Singleton
    public static LibroDB povideLibroDB(Application application){
        return Room.databaseBuilder(application,LibroDB.class,"Favorite Database")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();
    }
    @Provides
    @Singleton
    public static LibroDao provideLibroDao(LibroDB libroDB){
        return libroDB.libroDao();
    }
}
