package com.expenseezy.expenseezy;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class NavigationDrawerFragment extends Fragment {
    DrawerLayout mDrawerLayout;
    ActionBarDrawerToggle mDrawerToggle;
    private boolean mUserLearnedDrawer;
    private boolean mSavedInstanceState;
    View containerView;
    private final static String PREFERENCE_NAME = "my_shared_pref";
    private final static String KEY_USER_LEARNED_DRAWER = "user_learned_drawer";

    public NavigationDrawerFragment() {
        // Required empty public constructor
    }

    /*
    * assign mUserLearnedDrawer (true) if the user has seen the drawer already
    * otherwise return (false)
    * */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUserLearnedDrawer = Boolean.valueOf(readFromPreference(getActivity(),KEY_USER_LEARNED_DRAWER,"false"));
        if(savedInstanceState!=null){
            mSavedInstanceState=true;
        }
    }

    /*
    * return fragment_navigation_drawer layout to the fragment in the activity_main
    * */

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
    }

    public void setUp(int fragmentId, DrawerLayout drawerLayout, final Toolbar toolBar) {
       containerView = getActivity().findViewById(fragmentId);
        mDrawerLayout = drawerLayout;
        mDrawerToggle = new ActionBarDrawerToggle(getActivity(),drawerLayout,toolBar, R.string.open_drawer,R.string.close_drawer){


            /*
            * if the drawer is opened for the first time (mUserLearnedDrawer is false) set mUserLearnedDrawer (true)
            * and save the mUserLearnedDrawer state to shared preferences
            * */
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                if(!mUserLearnedDrawer){
                    mUserLearnedDrawer=true;
                    saveToPreference(getActivity(),KEY_USER_LEARNED_DRAWER,mUserLearnedDrawer+"");
                }
                getActivity().invalidateOptionsMenu();

            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getActivity().invalidateOptionsMenu();
            }

            /*
            * fades the background when the navigation drawer slides into the activity
            * */
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                if(slideOffset<0.6){
                    toolBar.setAlpha(1-slideOffset);
                }

            }
        };

        if(!mUserLearnedDrawer&&!mSavedInstanceState){
            drawerLayout.openDrawer(containerView);
        }
        mDrawerLayout.addDrawerListener(mDrawerToggle);
        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });
    }

    /*
    * Method to save the mUserLearnedDrawer state to shared preferences
    * */
    public void saveToPreference(Context context,String preferenceName,String preferenceValue){
        SharedPreferences sp = context.getSharedPreferences(PREFERENCE_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(preferenceName,preferenceValue);
        editor.commit();
    }

    /*
    * read data from shared preferences*/
    public String readFromPreference(Context context,String preferenceName,String defaultValue){
        SharedPreferences sp = context.getSharedPreferences(PREFERENCE_NAME,Context.MODE_PRIVATE);
        return  sp.getString(preferenceName,defaultValue);
    }
}
