package com.mrbell.autoimageslider_with_viewpager;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class WelcomeActivity extends AppCompatActivity {

    Viewpageradapter viewpageradapter;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        viewPager=findViewById(R.id.welcomeViewpager);

        viewpageradapter=new Viewpageradapter(this);
        viewPager.setAdapter(viewpageradapter);

        Timer timer =  new Timer();

        timer.scheduleAtFixedRate(new Mytimertask(),2000,4000);
    }

    public class Mytimertask extends TimerTask{

        @Override
        public void run() {
            WelcomeActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(viewPager.getCurrentItem()==0){
                        viewPager.setCurrentItem(1);
                    }else if(viewPager.getCurrentItem()==1)
                        viewPager.setCurrentItem(2);
                    else if(viewPager.getCurrentItem()==2)
                        viewPager.setCurrentItem(3);
                    else if(viewPager.getCurrentItem()==3)
                        viewPager.setCurrentItem(4);
                }
            });
        }
    }
}
