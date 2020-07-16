package com.ramachandran.articleapp.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ramachandran.articleapp.api.Api;
import com.ramachandran.articleapp.model.ArticleData;
import com.ramachandran.articleapp.model.Document;
import com.ramachandran.articleapp.model.network.CallApi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DataViewModel extends ViewModel {
    CallApi callApi;
    private MutableLiveData<HashMap<String, List<Document>>> articleDataMutableLiveData=new MutableLiveData<>();
    public MutableLiveData<HashMap<String, List<Document>>> getArticleDataMutableLiveData(){
        getDatas();
          return articleDataMutableLiveData;
    }
    private HashMap<String, List<Document>> showValue(ArticleData mArticleData){
        HashMap<String, List<Document>> map=new HashMap<>();
        if(mArticleData != null) {
            for (Document doc : mArticleData.getmResponse().getDocs()) {
                showValueData(map, doc);
            }
        }
        return map;
    }
    private void showValueData(HashMap<String, List<Document>> maps,Document document){
        if(maps.containsKey(document.getJournal())){
            List<Document> docs=maps.get(document.getJournal());
            docs.add(document);
            maps.put(document.getJournal(),docs);
        }
        else{
            List<Document> doc=new ArrayList<>();
            doc.add(document);
            maps.put(document.getJournal(),doc);
        }
    }
    public void getDatas() {
        Api api = CallApi.getRetrofit().create(Api.class);
        Call<ArticleData> call = api.getArticleDatas();
        call.enqueue(new Callback<ArticleData>() {
            @Override
            public void onResponse(Call<ArticleData> call, Response<ArticleData> response) {

                articleDataMutableLiveData.setValue(showValue(response.body()));
            }

            @Override
            public void onFailure(Call<ArticleData> call, Throwable t) {
                Log.v("ERROR", "ERROR :" + t.getMessage());

            }
        });
    }
}
