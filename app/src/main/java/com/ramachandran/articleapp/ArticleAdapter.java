package com.ramachandran.articleapp;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.ramachandran.articleapp.databinding.ArticleadapterBinding;
import com.ramachandran.articleapp.model.Document;

import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder> {
    List<Document> doceList;
    ArticleadapterBinding articleadapterBinding;
    public void setArticleData(List<Document> docs){
        doceList=docs;
    }
    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        articleadapterBinding = DataBindingUtil.inflate(layoutInflater,R.layout.articleadapter,parent,false);
        return new ArticleViewHolder(articleadapterBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        Document docs=doceList.get(position);
        holder.showDocs(docs);
    }

    @Override
    public int getItemCount() {
        return doceList.size();
    }
    class ArticleViewHolder extends RecyclerView.ViewHolder{
        ArticleadapterBinding articleBinding;
        public ArticleViewHolder(@NonNull ArticleadapterBinding itemView) {
            super(itemView.getRoot());
            articleBinding = itemView;
        }
        public void showDocs(Document docs){
            articleBinding.setDoc(docs);
            articleBinding.executePendingBindings();
        }
    }
}
