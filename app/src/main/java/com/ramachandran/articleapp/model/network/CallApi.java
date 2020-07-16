package com.ramachandran.articleapp.model.network;

import android.util.Log;

import com.ramachandran.articleapp.api.Api;
import com.ramachandran.articleapp.model.ArticleData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CallApi {
    ArticleData mArticle;
    public static Retrofit getRetrofit(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(Api.BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
       return retrofit;
    }

}
