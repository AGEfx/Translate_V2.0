package com.example.student2.myapplication;



import retrofit2.Call;
import retrofit2.http.GET;

import retrofit2.http.Query;

/**
 * Created by creator on creation with creative creativity
 * .
 */

public interface TranslationInterface {
    @GET("translate")
    public Call<Translate> getTranslation (@Query("text") String text, @Query("lang") String lang, @Query("key") String apikey);
}
