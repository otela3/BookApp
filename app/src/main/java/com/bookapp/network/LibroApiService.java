package com.bookapp.network;



import com.bookapp.model.LibroResponse;

import retrofit2.http.GET;

import javax.annotation.Generated;
import io.reactivex.rxjava3.core.Observable;

public interface LibroApiService {

    @GET("libros")
    Observable<LibroResponse> getLibros();
}
