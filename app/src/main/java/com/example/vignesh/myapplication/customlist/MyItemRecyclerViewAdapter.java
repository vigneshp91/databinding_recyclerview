package com.example.vignesh.myapplication.customlist;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vignesh.myapplication.R;
import com.example.vignesh.myapplication.customlist.dummy.DummyContent.DummyItem;
import com.example.vignesh.myapplication.databinding.SampleItemBinding;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the

 * TODO: Replace the implementation with code for your data type.
 */
public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    private final List<DummyItem> mValues;
    LayoutInflater  mInflater;
    SampleItemBinding mbinding;
//    private final OnListFragmentInteractionListener mListener;

    public MyItemRecyclerViewAdapter(List<DummyItem> items) {
        mValues = items;
//        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
/*        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);*/

        if(mInflater==null)
            mInflater=LayoutInflater.from(parent.getContext());
        mbinding = DataBindingUtil.inflate(mInflater, R.layout.sample_item, parent, false);
        return new ViewHolder(mbinding);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final DummyItem model=mValues.get(position);
        holder.bind(model);

        final SampleItemBinding binding=holder.getBinding();
        holder.mItem = mValues.get(position);
//        binding.content.setText(mValues.get(position).content);
        binding.setHandler(new ListCkickHandler() {
            @Override
            public void ItemClickHandler(View view) {
                Log.d("click","clicked"+position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public DummyItem mItem;
        SampleItemBinding mSbinding;



        public ViewHolder(SampleItemBinding mlistitembinding) {
            super(mlistitembinding.getRoot());
            mSbinding=mlistitembinding;
        }


        public void bind (DummyItem model)
        {

            mSbinding.setViewmodel(model);
        }
        public SampleItemBinding getBinding(){
            return mSbinding;
        }
    }



    public interface ListCkickHandler {
        void ItemClickHandler(View view);
    }
}
