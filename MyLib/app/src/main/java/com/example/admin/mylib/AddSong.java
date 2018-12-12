package com.example.admin.mylib;

public class AddSong {
    private String song;
    private String singer;
    private String url_song;
    private String genres;

    public AddSong(String song, String singer, String url_song, String genres) {
        this.song = song;
        this.singer = singer;
        this.url_song = url_song;
        this.genres = genres;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getUrl_song() {
        return url_song;
    }

    public void setUrl_song(String url_song) {
        this.url_song = url_song;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }
}
