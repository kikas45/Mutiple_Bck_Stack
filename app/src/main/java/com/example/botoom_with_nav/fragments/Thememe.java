package com.example.botoom_with_nav.fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;

import com.example.botoom_with_nav.R;


public class Thememe extends Fragment {

    public Thememe() {
        // Required empty public constructor
    }

    public static Thememe newInstance() {

        Thememe fragment = new Thememe();
        return fragment;

    }

/*    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ImageView imageView;
        SwitchCompat switchCompat;
        SharedPreferences sharedPreferences = null;
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_theme, container, false);
        /*Home_Instance_Fragment home_instance_fragment = Home_Instance_Fragment.newInstance();
        ((MainActivity)requireActivity()).putFragmentToStack(MainActivity.BACK_STACK_HOME, set);
*/
        imageView = view.findViewById(R.id.imageView);
        switchCompat = view.findViewById(R.id.switchCompat);

        sharedPreferences = requireContext().getSharedPreferences("night", 0);
        Boolean booleanValue = sharedPreferences.getBoolean("night_mode", true);
        if (booleanValue) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            switchCompat.setChecked(true);
            imageView.setImageResource(R.drawable.ic_settings_unclicked);
        }

        SharedPreferences finalSharedPreferences = sharedPreferences;
        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    switchCompat.setChecked(true);
                    imageView.setImageResource(R.drawable.ic_launcher_background);
                    SharedPreferences.Editor editor = finalSharedPreferences.edit();
                    editor.putBoolean("night_mode", true);
                    editor.commit();


                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    switchCompat.setChecked(false);
                    imageView.setImageResource(R.drawable.ic_dashboard_unclciked);
                    SharedPreferences.Editor editor = finalSharedPreferences.edit();
                    editor.putBoolean("night_mode", false);
                    editor.commit();


                }
            }
        });


        return  view;
    }
}