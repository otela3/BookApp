package com.bookapp.repository;


import androidx.lifecycle.LiveData;

import io.reactivex.rxjava3.core.Observable;

import com.bookapp.db.LibroDao;
import com.bookapp.model.Libro;
import com.bookapp.model.LibroResponse;
import com.bookapp.network.LibroApiService;

import java.util.List;

import javax.inject.Inject;

public class Repository {

    private LibroDao libroDao;
    private LibroApiService libroApiService;

    @Inject

    public Repository(LibroDao libroDao, LibroApiService libroApiService) {
        this.libroDao = libroDao;
        this.libroApiService = libroApiService;
    }

    public Observable<LibroResponse> getLibros(){
        return libroApiService.getLibros();
    }

    public void insertLibro(Libro libro){
        libroDao.insertLibro(libro);
    }

    public void deleteLibro(String libroName){
        libroDao.deleteLibro(libroName);
    }
    public void deleteAll(){
        libroDao.deletAll();
    }
    public LiveData<List<Libro>> getFavoriteLibro(){
        return libroDao.getFavoriteLibro();
    }
}
