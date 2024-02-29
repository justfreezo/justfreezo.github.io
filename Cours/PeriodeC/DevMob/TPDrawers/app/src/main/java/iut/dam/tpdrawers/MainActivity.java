package iut.dam.tpdrawers;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerDL;
    NavigationView navNV;
    ActionBarDrawerToggle toggle;
    FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerDL = findViewById(R.id.dl_drawer);
        navNV = findViewById(R.id.nv_nav);

        // Set up the ActionBarDrawerToggle to control the drawer layout
        toggle = new ActionBarDrawerToggle(this, drawerDL, R.string.drawer_open, R.string.drawer_close);
        drawerDL.addDrawerListener(toggle);
        toggle.syncState();

        // Enable the home button in the action bar to open/close the drawer
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        fm = getSupportFragmentManager();

        navNV.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.nav_first) {
                    fm.beginTransaction()
                            .replace(R.id.fl_container, new HabitatFragment())
                            .commit();
                    setTitle("Habitats");
                } else if (itemId == R.id.nav_second) {
                    fm.beginTransaction()
                            .replace(R.id.fl_container, new MyHabitatFragment())
                            .commit();
                    setTitle("Mon habitat");
                } else if (itemId == R.id.nav_disconnect) {
                    Intent i = new Intent(MainActivity.this, RelativeActivity.class);
                    startActivity(i);
                }
                Toast.makeText(MainActivity.this, "Navigation item selected: " + item.getTitle(), Toast.LENGTH_SHORT).show();
                drawerDL.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    // Handle opening/closing the drawer when the home button is pressed
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // Close the drawer when the back button is pressed
    @Override
    public void onBackPressed() {
        if (drawerDL.isDrawerOpen(GravityCompat.START)) {
            drawerDL.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
