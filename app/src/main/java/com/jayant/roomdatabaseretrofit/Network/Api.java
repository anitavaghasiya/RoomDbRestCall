package com.jayant.roomdatabaseretrofit.Network;

import com.jayant.roomdatabaseretrofit.Modal.Actor;
import com.jayant.roomdatabaseretrofit.Modal.Smartfolder;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    @GET("photos")
    Call<List<Smartfolder>> getAllActors(@Query("client_id") String client_id);
}
