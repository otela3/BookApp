package com.bookapp.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.bookapp.model.Libro;

@Database(entities = {Libro.class},version = 2,exportSchema = false)
public abstract class LibroDB extends RoomDatabase {
    public abstract LibroDao libroDao();
}
