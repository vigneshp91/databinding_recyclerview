package com.example.vignesh.myapplication;

import android.databinding.BindingAdapter;
import android.support.v4.content.ContextCompat;
import android.widget.ImageButton;

/**
 * Created by Vignesh on 22/02/2017.
 */

public class CustomSetter {
    @BindingAdapter("ImgSrc")
    public static void setImgSrc(ImageButton view,int rsid){
        view.setImageDrawable(ContextCompat.getDrawable(view.getContext(),rsid));
    }
}
