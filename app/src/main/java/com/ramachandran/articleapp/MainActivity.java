package com.ramachandran.articleapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ramachandran.articleapp.model.Document;
import com.ramachandran.articleapp.viewmodel.DataViewModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnDataListeners{
    RecyclerView recyclerView;
    List<String> articleType;
    MainAdapter mainAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        articleType=new ArrayList<>();
        recyclerView=(RecyclerView) findViewById(R.id.recycle);
        DataViewModel viewModel=  ViewModelProviders.of(this).get(DataViewModel.class);
        viewModel.getArticleDataMutableLiveData().observe(this, new Observer<HashMap<String, List<Document>>>() {
            @Override
            public void onChanged(HashMap<String, List<Document>> stringListHashMap) {
                articleType = new ArrayList<String> (stringListHashMap.keySet());
                ArticleSingleTon.getInstance().setArticleList(stringListHashMap);
                mainAdapter.setData(articleType);
                mainAdapter.notifyDataSetChanged();
            }
        });
        mainAdapter=new MainAdapter(this);
        mainAdapter.setData(articleType);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(mainAdapter);
    }

    @Override
    public void onData(String data) {
        Intent lIntent=new Intent(MainActivity.this,ArticleActivity.class);
        lIntent.putExtra("articleType",data);
        startActivity(lIntent);
        Toast.makeText(MainActivity.this,data,Toast.LENGTH_LONG).show();
    }
}
