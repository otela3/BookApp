package com.bookapp.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.bookapp.model.Libro;
import com.bookapp.model.LibroResponse;
import com.bookapp.repository.Repository;

import java.util.ArrayList;

import javax.inject.Inject;

import android.util.Log;

import androidx.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;
public class LibroViewModel extends ViewModel {
    private static final String TAG = "LibrosViewModel";

    private Repository repository;
    private MutableLiveData<ArrayList<Libro>> libroList = new MutableLiveData<>();
    private LiveData<List<Libro>> favoriteLibroList = null;

    @Inject
    public LibroViewModel(Repository repository) {
        this.repository = repository;
        favoriteLibroList = repository.getFavoriteLibro();
    }
    public MutableLiveData<ArrayList<Libro>> getLibroList(){
        return libroList;
    }

    public void getLibros(){
        repository.getLibros()
                .subscribeOn(Schedulers.io())
                .map(new Function<LibroResponse, ArrayList<Libro>>() {
                    @Override
                    public ArrayList<Libro> apply(LibroResponse libroResponse) throws Throwable{
                        ArrayList<Libro> list = libroResponse.getResults();
                        for (Libro libro : list){
                            String url = libro.getUrlDetails();
                            String[] libroIndex = url.split("/");

                        }
                        Log.e(TAG,"apply: "+list.get(2).getUrlDetails());
                        return list;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> libroList.setValue(result),
                        error -> Log.e(TAG,"getLibros: "+error.getMessage()));
    }

    public void insertLibro(Libro libro){
        repository.insertLibro(libro);
    }

    public void deleteLibro(String libroName){
        repository.deleteLibro(libroName);
    }

    public LiveData<List<Libro>> getFavoriteList(){
        return favoriteLibroList;
    }
    public void getFavoriteLibro(){
        favoriteLibroList = repository.getFavoriteLibro();
    }
}
