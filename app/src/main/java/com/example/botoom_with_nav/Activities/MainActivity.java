package com.example.botoom_with_nav.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.botoom_with_nav.Adapter.RecyclerBottomNavigationAdapter;
import com.example.botoom_with_nav.Listner.OnBottomItemNavigationListner;
import com.example.botoom_with_nav.Model.BottomNavigationModel;
import com.example.botoom_with_nav.R;
import com.example.botoom_with_nav.fragments.DashBoardFragment;
import com.example.botoom_with_nav.fragments.HomeFragment;
import com.example.botoom_with_nav.fragments.SettingFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    public   static  final  String BACK_STACK_HOME = "BACK_STACK_HOME ";
    public   static  final  String BACK_STACK_DASHBOARD = "BACK_STACK_DASHBOARD ";
    public   static  final  String BACK_STACK_SETTINGS = "BACK_STACK_SETTINGS ";
    private String last_back_stack = BACK_STACK_HOME;

    private HashMap< String , Stack<Fragment>> back_Stack;


    private HomeFragment homeFragment;
    private DashBoardFragment dashBoardFragment;
    private SettingFragment settingsFragment;
    private Fragment activeFragment;
    private FragmentManager fragmentManager;


    private ArrayList<BottomNavigationModel> bottomNavigationModel;
   private RecyclerBottomNavigationAdapter recyclerBottomNavigationAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        iniliaze();
    }

    private void iniliaze() {
        filData();
        iniliazeComponet();
        
        inliaze_Fragment();
    }

    private void inliaze_Fragment() {
        homeFragment = HomeFragment.newInstance();
        dashBoardFragment = DashBoardFragment.newInstance();
        settingsFragment = SettingFragment.newInstance();
        activeFragment = homeFragment;

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.containerFragment, homeFragment );
        transaction.add(R.id.containerFragment, dashBoardFragment ).hide(dashBoardFragment);
        transaction.add(R.id.containerFragment, settingsFragment ).hide(settingsFragment);
        transaction.commit();
    }

    private void filData() {

        back_Stack = new HashMap<>();
        back_Stack.put(BACK_STACK_HOME, new Stack<>() );
        back_Stack.put(BACK_STACK_DASHBOARD, new Stack<>() );
        back_Stack.put(BACK_STACK_SETTINGS, new Stack<>() );


        bottomNavigationModel = new ArrayList<>();
        bottomNavigationModel.add(new BottomNavigationModel("Home", R.drawable.ic_home_unclicked, R.drawable.ic_home_clicked));
        bottomNavigationModel.add(new BottomNavigationModel("DASHBOARD", R.drawable.ic_dashboard_clicked, R.drawable.ic_dashboard_unclciked));
        bottomNavigationModel.add(new BottomNavigationModel("SETTING", R.drawable.ic_settings_clicked, R.drawable.ic_settings_unclicked));
    }

    private void iniliazeComponet() {
        RecyclerView recyclerBottomNav = findViewById(R.id.recyclerBottomNavigation);
        recyclerBottomNav.setHasFixedSize(true);
        recyclerBottomNav.setLayoutManager(new GridLayoutManager(this, 3));

        recyclerBottomNavigationAdapter = new RecyclerBottomNavigationAdapter(bottomNavigationModel, this, new OnBottomItemNavigationListner() {
            @Override
            public void OnItemClicked(int position) {
                switch (position){
                    case 0:

                      openHomeFragment();

                        break;

                    case 1:

                       openDashBoardFargment();

                        break;

                    case 2:

                       openSettingFragment();

                        break;
                }

            }
        });
        recyclerBottomNav.setAdapter(recyclerBottomNavigationAdapter);

    }

    private void openSettingFragment() {
        fragmentManager.beginTransaction().hide(activeFragment).show(settingsFragment).commit();
        recyclerBottomNavigationAdapter.changeItem(RecyclerBottomNavigationAdapter.ITEM_SETTINGS);
        if (last_back_stack.equals(BACK_STACK_SETTINGS)){
            clearStack(BACK_STACK_SETTINGS);
        }

        activeFragment = settingsFragment;

        last_back_stack = BACK_STACK_SETTINGS;
    }

    private void openDashBoardFargment() {
        fragmentManager.beginTransaction().hide(activeFragment).show(dashBoardFragment).commit();
        recyclerBottomNavigationAdapter.changeItem(RecyclerBottomNavigationAdapter.ITEM_DASHBOARD);

        if (last_back_stack.equals(BACK_STACK_DASHBOARD)){
            clearStack(BACK_STACK_DASHBOARD);
        }

        activeFragment = dashBoardFragment;
        last_back_stack = BACK_STACK_DASHBOARD;
    }

    private void openHomeFragment() {
        fragmentManager.beginTransaction().hide(activeFragment).show(homeFragment).commit();
        recyclerBottomNavigationAdapter.changeItem(RecyclerBottomNavigationAdapter.ITEM_HOME);


        if (last_back_stack.equals(BACK_STACK_HOME)){
            clearStack(BACK_STACK_HOME);
        }
        activeFragment = homeFragment;
        last_back_stack = BACK_STACK_HOME;
    }

    public  void  putFragmentToStack(String key, Fragment fragment){

        Stack<Fragment> stack = back_Stack.get(key);
        stack.push(fragment);
    }

    private boolean popFragment(String key){
        Stack<Fragment> stack = back_Stack.get(key);
        if (stack!=null && !stack.empty()){
            getSupportFragmentManager().beginTransaction().remove(stack.pop()).commit();
            return  true;
        }

        return  false;

    }

    private void  clearStack(String key){
        while (true){
            if (!popFragment(key)){
                break;
            }
        }
    }

    @Override
    public void onBackPressed() {
        if (!popFragment(last_back_stack)){
        super.onBackPressed();}
    }


}