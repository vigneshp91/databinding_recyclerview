package com.example.vignesh.myapplication;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableInt;
import android.support.v7.widget.RecyclerView;
import android.util.ArrayMap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.vignesh.myapplication.databinding.ListItemBinding;

import java.util.ArrayList;

/**
 * Created by Vignesh on 22/02/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Context mcontext;
    private ArrayList<SportViewModel> mList;
    private LayoutInflater mInflater;
    private ListItemBinding binding;

    public RecyclerViewAdapter(Context ctx,ArrayList<SportViewModel> list){
        this.mcontext=ctx;
        this.mList=list;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(mInflater==null)
            mInflater=LayoutInflater.from(parent.getContext());
         binding = DataBindingUtil.inflate(mInflater, R.layout.list_item, parent, false);
        return new ViewHolder(binding);

    }



    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final SportViewModel model=mList.get(position);
        holder.bind(model);

        final ListItemBinding binding=holder.getBinding();
        binding.setHandle(new FavImgCkickHandler() {
            @Override
            public void onFavImageClick() {
                model.resid.set(R.mipmap.ic_launcher);

                Toast.makeText(mcontext, "item tapped", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private ListItemBinding mbinding;

        public ViewHolder(ListItemBinding mlistitembinding) {
            super(mlistitembinding.getRoot());
            mbinding=mlistitembinding;
        }

        public void bind (SportViewModel model)
        {

            mbinding.setViewmodel(model);
        }
        public ListItemBinding getBinding(){
            return mbinding;
        }
    }



}
