package com.ramachandran.articleapp;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ramachandran.articleapp.model.Document;

import java.util.List;

public class ArticleActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.articleactivity);
        String articleType=getIntent().getStringExtra("articleType");
        List<Document> list=ArticleSingleTon.getInstance().getArticleDocs().get(articleType);
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.articlerecycle);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        ArticleAdapter articleAdapter=new ArticleAdapter();
        articleAdapter.setArticleData(list);
        recyclerView.setAdapter(articleAdapter);
    }
}
