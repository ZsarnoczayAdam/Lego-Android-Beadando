package com.example.lego.api;

import com.example.lego.api.model.LegoSetResponse;
import com.example.lego.api.model.LegoPartResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface ApiService {


    @GET("lego/sets/")
    Call<LegoSetResponse> getSets(
            @Query("search") String query,       // keresési kulcsszó, pl. "Star Wars"
            @Query("page_size") int pageSize,    // hány találatot adjon
            @Header("Authorization") String apiKey
    );


    @GET("lego/parts/")
    Call<LegoPartResponse> getParts(
            @Query("search") String query,
            @Query("page_size") int pageSize,
            @Header("Authorization") String apiKey
    );
}