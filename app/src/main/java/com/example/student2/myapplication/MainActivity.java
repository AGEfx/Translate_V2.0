package com.example.student2.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


import retrofit2.*;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    String apikey = "trnsl.1.1.20170425T145422Z.50255e37fd0f3be2.193e26f527cdd0bbf1653c5005ab887b18eb05ec";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        translate("cat","en-ru");
    }
    void translate(String text,String lang){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://translate.yandex.net/api/v1.5/tr.json/").addConverterFactory(GsonConverterFactory.create()).build();
        TranslationInterface api = retrofit.create(TranslationInterface.class);
        Call<Translate> call = api.getTranslation(text, lang,apikey);
        call.enqueue(new Callback<Translate>() {
            @Override
            public void onResponse(Call<Translate> call, Response<Translate> response) {

                Translate translate = response.body();
                TextView tv = (TextView)findViewById(R.id.tv);
                        tv.setText(translate.getText().get(0));
            }

            @Override
            public void onFailure(Call<Translate> call, Throwable t) {

            }
        });

        }
    }

