package com.example.samsung.p1081_actionbarnav;

import android.app.ActionBar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import static android.support.v7.app.ActionBar.*;

public class MainActivity extends AppCompatActivity implements android.support.v7.app.ActionBar.TabListener {

    private android.support.v7.app.ActionBar actionBar;
    private android.support.v7.app.ActionBar.Tab tab;
    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        tab = actionBar.newTab();
        tab.setText("Tab 1");
        tab.setTabListener(this);
        actionBar.addTab(tab);

        tab = actionBar.newTab();
        tab.setText("Tab 2");
        tab.setTabListener(this);
        actionBar.addTab(tab);

    }

    @Override
    public void onTabSelected(Tab tab, FragmentTransaction ft) {
        message = "Selected tab: " + tab.getText();
        Messager.sendToAllRecipients(getBaseContext(), message);
    }

    @Override
    public void onTabUnselected(Tab tab, FragmentTransaction ft) {
        message = "Unselected tab: " + tab.getText();
        Messager.sendToAllRecipients(getBaseContext(), message);
    }

    @Override
    public void onTabReselected(Tab tab, FragmentTransaction ft) {
        message = "Reselected tab: " + tab.getText();
        Messager.sendToAllRecipients(getBaseContext(), message);
    }
}
