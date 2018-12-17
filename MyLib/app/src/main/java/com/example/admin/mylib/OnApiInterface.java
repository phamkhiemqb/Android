package com.example.admin.mylib;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface OnApiInterface {

    @GET("hodela/list_song")
    Call<SongList> getListSongs();

//    @FormUrlEncoded
//    @POST("hodela/add_music")
//    Call<Song> postNewSong(@Field("song") String song, @Field("singer") String sing,
//                           @Field("url_song") String url, @Field("genres") String gen);

    @POST("hodela/add_music")
    Call<Object> postNewSong(@Body AddSong s);
}
