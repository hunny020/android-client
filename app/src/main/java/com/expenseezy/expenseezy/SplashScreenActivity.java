package com.expenseezy.expenseezy;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.LoginFilter;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

public class SplashScreenActivity extends FragmentActivity {

//    ViewPager viewPager;
//    SplashScreenFragmentAdapter splashScreenFragmentAdapter;
//    RadioGroup radioGroup;

    SliderLayout sliderLayout;
    TextSliderView textSliderView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        sliderLayout = (SliderLayout) findViewById(R.id.slider);
        textSliderView = new TextSliderView(this);
        textSliderView.image("http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");
        sliderLayout.addSlider(textSliderView);
        textSliderView = new TextSliderView(this);
        textSliderView.image("https://pixabay.com/static/uploads/photo/2016/03/28/12/35/cat-1285634_960_720.png");
        sliderLayout.addSlider(textSliderView);
//        viewPager = (ViewPager) findViewById(R.id.splashScreenViewPager);
//        splashScreenFragmentAdapter = new SplashScreenFragmentAdapter(getSupportFragmentManager());
//        viewPager.setAdapter(splashScreenFragmentAdapter);
//        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
////                RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
////                RadioButton radioButton = (RadioButton)findViewById(radioGroup.getChildAt(position).getId());
////               for(int i = 0; i < 2;i++){
////                   if(i!=position){
////                       RadioButton radioButton2 =  (RadioButton)findViewById(radioGroup.getChildAt(i).getId());
////                       radioButton2.setBackgroundColor(Color.BLACK);
////                   }
////               }
//              Log.i("buttonIdTag", "onPageSelected: " + position);
////                radioButton.setBackgroundColor(Color.BLUE);

            }

    public void skipButtonClicked(View v){
        Intent intent = new Intent();
        intent.setClass(this,LoginActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStop() {
        sliderLayout.stopAutoCycle();
        super.onStop();
    }

    //            @Override
//            public void onPageSelected(int position) {
//                Log.i("buttonIdTag", "onPageSelected: " + position);
////  viewPager.getChildAt(position).
//                radioGroup  = (RadioGroup) findViewById(R.id.radioGroup);
//                radioGroup.check(radioGroup.getChildAt(position).getId());
////                RadioButton radioButton = (RadioButton) radioGroup.getChildAt(position);//(RadioButton)findViewById(.getId());
////                for(int i = 0; i < 2;i++){
////                    if(i!=position){
////                        RadioButton radioButton2 = (RadioButton)radioGroup.getChildAt(i);
////                        radioButton2.setBackgroundColor(Color.BLACK);
////                    }
////                }
////                Log.i("buttonIdTag", "onPageSelected: " + position);
////                radioButton.setBackgroundColor(Color.BLUE);
//                Toast.makeText(SplashScreenActivity.this, "onPageScroll "+position,Toast.LENGTH_SHORT).show();
//
//            }

//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }

}
