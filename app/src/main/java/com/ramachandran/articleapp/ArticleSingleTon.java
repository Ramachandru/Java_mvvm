package com.ramachandran.articleapp;

import com.ramachandran.articleapp.model.Document;

import java.util.HashMap;
import java.util.List;

public class ArticleSingleTon {
    private static ArticleSingleTon articleSingleTon;
    private HashMap<String,List<Document>> articleDocs;
    private ArticleSingleTon(){

    }
    public static ArticleSingleTon getInstance(){
        if(articleSingleTon == null){
            synchronized (ArticleSingleTon.class){
                if(articleSingleTon == null){
                    articleSingleTon = new ArticleSingleTon();
                }
            }
        }
        return articleSingleTon;
    }
    public void setArticleList(HashMap<String,List<Document>> articleList){
        articleDocs = articleList;
    }
    public HashMap<String,List<Document>> getArticleDocs(){
        return articleDocs;
    }
}
