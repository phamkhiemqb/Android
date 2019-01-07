package com.example.user.salon;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface OnApiInterface {
    @GET("hodela/list_salon")
    Call<Example> getlistsalon();
    @POST("hodela/register_users")
    Call<Object> postNewSong(@Body Register s);
    @POST("hodela/login_authenticate")
    Call<Token> active(@Body  Login a);

}
