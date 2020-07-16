package com.ramachandran.articleapp.api;

import com.ramachandran.articleapp.model.ArticleData;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    public static final String BASEURL="http://api.plos.org/";
    @GET("search?q=title:DNA")
    Call<ArticleData> getArticleDatas();
}
