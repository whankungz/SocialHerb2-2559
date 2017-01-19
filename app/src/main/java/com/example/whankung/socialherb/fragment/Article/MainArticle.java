package com.example.whankung.socialherb.fragment.Article;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.whankung.socialherb.R;
import com.example.whankung.socialherb.activity.Login;

/**
 * Created by Whankung on 16/1/2560.
 */

public class MainArticle extends android.support.v4.app.Fragment{
    private View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceStat) {
        rootView = inflater.inflate(R.layout.stucture_article, container, false);
        setView();

        return rootView;
    }

    private void setView() {

    }
}
