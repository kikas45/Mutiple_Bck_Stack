package com.example.botoom_with_nav.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.botoom_with_nav.Activities.MainActivity;
import com.example.botoom_with_nav.R;


public class SettingFragment extends Fragment {

    public static SettingFragment newInstance() {

        SettingFragment fragment = new SettingFragment();
        return fragment;

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Button setting_btn;
        FragmentManager fragment;
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_setting, container, false);
        setting_btn = view.findViewById(R.id.setting_btn);
        setting_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

             /*   Home_Instance_Fragment nextFrag= Home_Instance_Fragment.newInstance();
                ((MainActivity)requireActivity()).putFragmentToStack(MainActivity.BACK_STACK_SETTINGS, nextFrag);
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.setting_contaioner, nextFrag, "findThisFragment")
                        .addToBackStack(null)
                        .commit();
*/
              Home_Instance_Fragment nextFrag = Home_Instance_Fragment.newInstance();
                ((MainActivity)requireActivity()).putFragmentToStack(MainActivity.BACK_STACK_SETTINGS, nextFrag);
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.setting_contaioner,
                        nextFrag).commit();

            }
        });


        return view;
    }


}