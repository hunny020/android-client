package com.expenseezy.expenseezy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by hasneetsingh on 16/10/16.
 */

public class SplashScreenFragmentAdapter extends FragmentPagerAdapter {

    public SplashScreenFragmentAdapter(FragmentManager fm) {
        super(fm);
    }


    public static class MyCustomViewPagerFragment extends Fragment{

        public final static String ImageResourceName ="image_resource";
        public final static String splashText="splash_text";
        ImageView splashImage;
        TextView splashContentText;
        public static MyCustomViewPagerFragment newInstance(String splashTextMessage,int ImageResource,int position) {
            Bundle args = new Bundle();
            
            MyCustomViewPagerFragment fragment = new MyCustomViewPagerFragment();
            args.putInt(ImageResourceName,ImageResource);
            args.putString(splashText,splashTextMessage);
            args.putInt("positionFragment",position);
            fragment.setArguments(args);
            return fragment;
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.custom_view_pager_fragment,container,false);
            splashImage = (ImageView) v.findViewById(R.id.imageView);
            splashContentText = (TextView) v.findViewById(R.id.textView);
            splashImage.setImageResource(getArguments().getInt(ImageResourceName));
            splashContentText.setText(getArguments().getString(splashText));
            Log.i("buttonIdTag","onCreateView "+ splashContentText);
          //  Toast.makeText(getContext(), "onCreateView "+ getArguments().getInt("positionFragment"),Toast.LENGTH_SHORT).show();
            return v;
        }
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return MyCustomViewPagerFragment.newInstance("Message 1",R.drawable.code_image,position);
            case 1: return  MyCustomViewPagerFragment.newInstance("Message 2",R.drawable.movie_maniac,position);
            case 2: return MyCustomViewPagerFragment.newInstance("Message 3",R.drawable.take_one,position);
        }

        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
