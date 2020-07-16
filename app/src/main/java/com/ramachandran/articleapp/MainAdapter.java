package com.ramachandran.articleapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.ramachandran.articleapp.databinding.MainadapterBinding;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {
    List<String> list;
    MainadapterBinding mainadapterBinding;
    OnDataListeners ondataListeners;
    MainAdapter(Context context)
    {
        ondataListeners=(OnDataListeners)context;
    }
    public void setData(List<String> data){
        list=data;
    }
    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        mainadapterBinding = DataBindingUtil.inflate(layoutInflater,R.layout.mainadapter,parent,false);
        return new MainViewHolder(mainadapterBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        String articleType=list.get(position);
        holder.showValue(articleType);
    }
    public void onClickedData(String data){
        ondataListeners.onData(data);
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
    class MainViewHolder extends RecyclerView.ViewHolder{
        MainadapterBinding mainBinding;
        public MainViewHolder(@NonNull MainadapterBinding itemView) {
            super(itemView.getRoot());
            mainBinding= itemView;
        }
        public void showValue(String articleType){
            mainBinding.setArticleType(articleType);
            mainBinding.setArticleClicked(MainAdapter.this);
            mainBinding.executePendingBindings();
        }
    }
}
