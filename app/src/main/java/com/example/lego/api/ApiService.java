package com.example.lego.api;

import com.example.lego.api.model.LegoSetResponse;
import com.example.lego.api.model.LegoPartResponse;

import retrofit2.Call;
import retrofit2.http.GET;

import retrofit2.http.Query;

public interface ApiService {


    @GET("lego/sets/")
    Call<LegoSetResponse> getSets(
            @Query("search") String query,
            @Query("page_size") int pageSize

    );


    @GET("lego/parts/")
    Call<LegoPartResponse> getParts(
            @Query("search") String query,
            @Query("page_size") int pageSize

    );
}