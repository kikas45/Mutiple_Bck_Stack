package com.example.botoom_with_nav.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.botoom_with_nav.Activities.Setting_Theme_Activity;
import com.example.botoom_with_nav.R;


public class Home_Instance_Fragment extends Fragment {

    public Home_Instance_Fragment() {
        // Required empty public constructor
    }

    public static Home_Instance_Fragment newInstance(){

        Home_Instance_Fragment fragment = new Home_Instance_Fragment();
        return  fragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Button button;
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_instance_home, container, false);

     button =view.findViewById(R.id.home_settings_btn);

     button.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Intent intent = new Intent(getActivity(), Setting_Theme_Activity.class);
             startActivity(intent);
         }
     });


        return  view;
    }
}