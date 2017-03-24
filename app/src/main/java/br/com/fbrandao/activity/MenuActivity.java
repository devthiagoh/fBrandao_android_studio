package br.com.fbrandao.activity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;

import com.fbrandao.R;

import br.com.fbrandao.util.Util;

public class MenuActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Util util;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        /*
         * adicionando o cabeçalho da home
         */
        Toolbar toolbar = (Toolbar) findViewById(R.id.home_header);
        setSupportActionBar(toolbar);

        /*
         * adicionando ação ao botão email do rodapé da home
         */
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.home_bottom);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Email enviado com sucesso!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        /*
         * adicionando ação toggle no menu lateral
         */
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.menu);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        /*
         * adicionando a barra de menu lateral
         */
        NavigationView navigationView = (NavigationView) findViewById(R.id.barra_lateral);
        navigationView.setNavigationItemSelectedListener(this);

        /*
         * montar ViewFlipper da página home
         */
        util = new Util();
        util.loadViewFlipperHome(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.menu);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu_home; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
/*
        //noinspection SimplifiableIfStatement
        if (id == R.id.menu_action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.menu_home) {

        } else if (id == R.id.menu_sobre) {

        } else if (id == R.id.menu_servicos) {

        } else if (id == R.id.menu_portifolio) {

        } else if (id == R.id.menu_opinioes_clientes) {

        } else if (id == R.id.menu_orcamentos) {

        } else if (id == R.id.menu_contatos) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.menu);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
