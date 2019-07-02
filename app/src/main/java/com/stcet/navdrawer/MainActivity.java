package com.stcet.navdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    DrawerLayout dl;
    NavigationView nv;
    TextView tv;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize views from the layout
        dl = findViewById(R.id.drawerLayout);
        nv = findViewById(R.id.navigationView);
        tv = findViewById(R.id.textView1);

        //ActionBarDrawerToggle is initialized to sync drawer open and closed states
        toggle = new ActionBarDrawerToggle(this, dl, R.string.open_menu, R.string.close_menu);

        dl.addDrawerListener(toggle);
        toggle.syncState();

        //The Hamburger icon is applied to the action bar for working with the nav drawer
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //On clicking of any menu items, actions will be performed accordingly
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id){
                    case R.id.account:
                        Toast.makeText(MainActivity.this, "This activity", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.settings:
                        startActivity(new Intent(MainActivity.this, SettingsActivity.class));
                        break;
                    case R.id.exit:
                        finish();
                        break;
                    default:
                        return true;
                }
                return true;
            }
        });
    }

    //On clicking any Menu Item this function is called and it returns the ID to the main function
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(toggle.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }
}
