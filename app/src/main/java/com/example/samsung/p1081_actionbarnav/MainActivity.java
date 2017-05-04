package com.example.samsung.p1081_actionbarnav;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;

import static android.support.v7.app.ActionBar.OnNavigationListener;
import static android.support.v7.app.ActionBar.Tab;

public class MainActivity extends AppCompatActivity implements
        android.support.v7.app.ActionBar.TabListener,
        OnNavigationListener {

    private final String data[] = {"One", "Two", "Three"};
    private android.support.v7.app.ActionBar actionBar;
    private android.support.v7.app.ActionBar.Tab tab;
    private String message;
    private boolean NAVIGATION_MODE_TABS = false,
            FIRST_INPUT_IN_MODE_TABS = true,
            FIRST_INPUT_IN_MODE_LIST = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actionBar = getSupportActionBar();
        setNavigationMode(NAVIGATION_MODE_TABS);
    }

    private void setNavigationMode(final boolean mode) {

        if (mode) {
            //The navigations mode "Tabs" is enabled
            actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

            if (tab == null) {
                tab = actionBar.newTab();
                tab.setText("Tab 1");
                tab.setTabListener(this);
                actionBar.addTab(tab);

                tab = actionBar.newTab();
                tab.setText("Tab 2");
                tab.setTabListener(this);
                actionBar.addTab(tab);
            }
        } else {
            actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
            ArrayAdapter<String> adapter
                    = new ArrayAdapter<String>(
                    this,
                    android.R.layout.simple_spinner_item,
                    data);
            adapter.setDropDownViewResource(
                    android.R.layout.simple_spinner_dropdown_item);
            actionBar.setListNavigationCallbacks(adapter, this);
        }
    }

    @Override
    public void onTabSelected(Tab tab, FragmentTransaction ft) {

        if (FIRST_INPUT_IN_MODE_TABS) {
            message = "Selected tab: " + tab.getText();
            Messager.sendToAllRecipients(getBaseContext(), message);

            switch (tab.getPosition()) {

                case 1:
                    NAVIGATION_MODE_TABS = false;
                    setNavigationMode(NAVIGATION_MODE_TABS);
                    FIRST_INPUT_IN_MODE_LIST = true;
                default:
                    break;
            }
            FIRST_INPUT_IN_MODE_TABS = false;
        }
    }

    @Override
    public void onTabUnselected(Tab tab, FragmentTransaction ft) {
        message = "Unselected tab: " + tab.getText();
        Messager.sendToAllRecipients(getBaseContext(), message);
        FIRST_INPUT_IN_MODE_TABS = true;
    }

    @Override
    public void onTabReselected(Tab tab, FragmentTransaction ft) {
        message = "Reselected tab: " + tab.getText();
        Messager.sendToAllRecipients(getBaseContext(), message);
    }

    @Override
    public boolean onNavigationItemSelected(int itemPosition, long itemId) {

        switch (itemPosition) {

            case 1:
                NAVIGATION_MODE_TABS = true;
                setNavigationMode(NAVIGATION_MODE_TABS);
                FIRST_INPUT_IN_MODE_TABS = true;
            default:
                FIRST_INPUT_IN_MODE_LIST = true;
                break;
        }

        if (FIRST_INPUT_IN_MODE_LIST) {

            message = "Selected position: " + itemPosition + ", id = " + itemId + ", " + data[itemPosition];
            Messager.sendToAllRecipients(getBaseContext(), message);
            FIRST_INPUT_IN_MODE_LIST = false;
        }

        return false;
    }
}
