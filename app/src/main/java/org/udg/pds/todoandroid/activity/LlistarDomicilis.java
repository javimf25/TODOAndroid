package org.udg.pds.todoandroid.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import org.udg.pds.todoandroid.R;
import org.udg.pds.todoandroid.TodoApp;
import org.udg.pds.todoandroid.entity.Domicili;
import org.udg.pds.todoandroid.entity.Task;
import org.udg.pds.todoandroid.entity.User;
import org.udg.pds.todoandroid.entity.UserLogin;
import org.udg.pds.todoandroid.fragment.TaskList;
import org.udg.pds.todoandroid.rest.TodoApi;
import org.udg.pds.todoandroid.util.AdapterLListarDomicilis;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class  LlistarDomicilis extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {

    TodoApi mTodoService;
    private GestureDetector gestureDetector;
    private RecyclerView llistatDomicilis;
    private Button afegirDomicili;
    private RecyclerView.LayoutManager layoutManager;
    private AdapterLListarDomicilis mAdapter;
    private List<Domicili> domicilis;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nd);
        mTodoService = ((TodoApp) this.getApplication()).getAPI();
        mAdapter = new AdapterLListarDomicilis(getApplicationContext());
        Call<List<Domicili>> call = mTodoService.getDomicilis("1");
        call.enqueue(new Callback<List<Domicili>>() {
            @Override
            public void onResponse(Call<List<Domicili>> call, Response<List<Domicili>> response) {
                if (response.isSuccessful()) {
                    domicilis = response.body();
                    mAdapter.setData(domicilis);

                } else {

                }
            }

            @Override
            public void onFailure(Call<List<Domicili>> call, Throwable t) {
                Toast toast1 =
                        Toast.makeText(getApplicationContext(),
                                "Peticio de llistar cases fallida", Toast.LENGTH_SHORT);
                toast1.show();
            }

        });
        llistatDomicilis = findViewById(R.id.llistadomicilis);
        llistatDomicilis.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        llistatDomicilis.setLayoutManager(layoutManager);
        // specify an adapter (see also next example)
        llistatDomicilis.setAdapter(mAdapter);
        afegirDomicili = findViewById(R.id.afegirDomicili);

        this.afegirDomicili.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Toast toast1 =
                        Toast.makeText(getApplicationContext(),
                                "Afegir cases no disponible,agregat al seguent sprint", Toast.LENGTH_SHORT);
                toast1.show();


            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nd, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }


    }





