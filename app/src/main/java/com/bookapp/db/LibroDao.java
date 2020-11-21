package com.bookapp.db;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.Query;

import com.bookapp.model.Libro;

import java.util.List;

public interface LibroDao {

    @Insert
    void insertLibro(Libro libro);

    @Query("DELETE FROM favorite_table WHERE name = :libroName")
    void deleteLibro(String libroName);

    @Query("DELETE FROM favorite_table")
    void deletAll();

    @Query("SELECT * FROM favorite_table")
    LiveData<List<Libro>> getFavoriteLibro();
}
