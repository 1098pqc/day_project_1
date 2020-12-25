package com.example.day_project_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.day_project_1.fragment.ClassifyFragment;
import com.example.day_project_1.fragment.HomeFragment;
import com.example.day_project_1.fragment.MyFragment;
import com.example.day_project_1.fragment.ShoppingFragment;
import com.example.day_project_1.fragment.SpecialFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private HomeFragment homeFragment;
    private SpecialFragment specialFragment;
    private ClassifyFragment classifyFragment;
    private ShoppingFragment shoppingFragment;
    private MyFragment myFragment;
    private Fragment[] fragments;
    private int lastFragment;//用于记录上个选择的Fragment

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //权限检查和申请
        initFragment();
    }

    //初始化fragment和fragment数组
    private void initFragment()
    {

        homeFragment = new HomeFragment();
        specialFragment = new SpecialFragment();
        classifyFragment = new ClassifyFragment();
        shoppingFragment = new ShoppingFragment();
        myFragment = new MyFragment();

        fragments = new Fragment[]{homeFragment,specialFragment,classifyFragment,shoppingFragment,myFragment};
        lastFragment = 0;
        getSupportFragmentManager().beginTransaction().replace(R.id.ll,homeFragment).show(homeFragment).commit();
        bottomNavigationView = findViewById(R.id.bnv);

        bottomNavigationView.setOnNavigationItemSelectedListener(changeFragment);
    }
    //判断选择的菜单
    private BottomNavigationView.OnNavigationItemSelectedListener changeFragment= new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId())
            {
                case R.id.menu1:
                {
                    if(lastFragment!=0)
                    {
                        switchFragment(lastFragment,0);
                        lastFragment=0;
                    }
                    return true;
                }
                case R.id.menu2:
                {
                    if(lastFragment!=1)
                    {
                        switchFragment(lastFragment,1);
                        lastFragment=1;

                    }

                    return true;
                }
                case R.id.menu3:
                {
                    if(lastFragment!=2)
                    {
                        switchFragment(lastFragment,2);
                        lastFragment=2;

                    }

                    return true;
                }
                case R.id.menu4:
                {
                    if(lastFragment!=3)
                    {
                        switchFragment(lastFragment,3);
                        lastFragment=3;

                    }

                    return true;
                }
                case R.id.menu5:
                {
                    if(lastFragment!=4)
                    {
                        switchFragment(lastFragment,4);
                        lastFragment=4;

                    }

                    return true;
                }

            }


            return false;
        }
    };


    //切换Fragment
    private void switchFragment(int lastfragment,int index)
    {
        FragmentTransaction transaction =getSupportFragmentManager().beginTransaction();
        transaction.hide(fragments[lastfragment]);//隐藏上个Fragment

        if(fragments[index].isAdded()==false)
        {
            transaction.add(R.id.ll,fragments[index]);
        }
        transaction.show(fragments[index]).commitAllowingStateLoss();


    }
}