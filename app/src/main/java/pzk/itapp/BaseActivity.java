package pzk.itapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Spinner;

public class BaseActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            /*Main Nav menu*/
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                final String appPackageName = getPackageName();

                //switch statement to control navigation in the drawer menu.
                switch (item.getItemId()) {

                    case R.id.nav_home:
                        Intent home = new Intent(getApplicationContext(), MainActivity.class);
                        drawerLayout.closeDrawers();
                        startActivity(home);
                        finish();
                        break;

                    case R.id.nav_printers:
                        Intent printers = new Intent(getApplicationContext(), Printers.class);
                        drawerLayout.closeDrawers();
                        startActivity(printers);
                        finish();

                        break;
                    case R.id.nav_compreq:
                        Intent compSpecs = new Intent(getApplicationContext(), ComputerSpecs.class);
                        startActivity(compSpecs);
                        finish();
                        drawerLayout.closeDrawers();
                        break;
                    //case R.id.nav_labInfo:
                      //  Intent labInfo = new Intent(getApplicationContext(), LabInformation.class);
                        //startActivity(labInfo);
                        //finish();
                        //drawerLayout.closeDrawers();
                    case R.id.nav_labtopCheckout:
                        Intent laptopCheckout = new Intent(getApplicationContext(), LaptopCheckout.class);
                        startActivity(laptopCheckout);
                        finish();
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.nav_chat:
                        Intent liveChat = new Intent(getApplicationContext(), LiveChat.class);
                        startActivity(liveChat);
                        finish();
                        drawerLayout.closeDrawers();
                        break;
                    //case R.id.nav_makeTicket:
                      //  Intent makeTicket = new Intent(getApplicationContext(), makeTicket.class);
                        //startActivity(makeTicket);
//                        finish();
                        //drawerLayout.closeDrawers();
                }
                return false;
            }
        });
    }
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void finish() {
       super.finish();
       overridePendingTransitionExit();
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransitionEnter();
    }
    /**
     * Overrides the pending Activity transition by performing the "Enter" animation.
     */
    protected void overridePendingTransitionEnter() {
        overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
    }
    /**
     * Overrides the pending Activity transition by performing the "Exit" animation.
     */
    protected void overridePendingTransitionExit() {
        overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
    }
}

