package com.example.botoom_with_nav.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.botoom_with_nav.Activities.MainActivity;
import com.example.botoom_with_nav.R;


public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(){

        HomeFragment fragment = new HomeFragment();
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
        return   inflater.inflate(R.layout.fragment_home, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        iniliazeUicomponet(view);
    }

    private void iniliazeUicomponet(View view) {

        Button button = view.findViewById(R.id.home_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openInstanceFragment();
            }
        });

    }
    private void openInstanceFragment(){
        Home_Instance_Fragment home_instance_fragment = Home_Instance_Fragment.newInstance();
       ((MainActivity)requireActivity()).putFragmentToStack(MainActivity.BACK_STACK_HOME, home_instance_fragment);
        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.home_contaioner,
                home_instance_fragment).commit();

    }


}