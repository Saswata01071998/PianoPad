package com.example.pianokids;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface API_Interface {
    @GET("posts")
    Call<List<Word>> getAllWords();

}
