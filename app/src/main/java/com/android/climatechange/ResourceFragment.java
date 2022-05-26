package com.android.climatechange;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.Callable;


public class ResourceFragment extends Fragment {

    public CardView cd_1,cd_2,cd_3;
    public TextView plastic,resources,readmore;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_resource, container, false);

        TextView readmore = (TextView)  view.findViewById(R.id.readmore);
        TextView readmore1 = (TextView)  view.findViewById(R.id.readmore1);
        TextView readmore2 = (TextView) view.findViewById(R.id.readmore2);

        readmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ResourceFragment.this.getContext(), Webview1.class));
            }
        });
        readmore1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ResourceFragment.this.getContext(),Webview2.class));
            }
        });
        readmore2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ResourceFragment.this.getContext(),Webview3.class));

            }
        });


        return view;
        



    }

   
}