package com.example.saurabh.twelfthman;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,ResultFromUrl {
    Home hm = new Home();
    Football ft =new Football();
    Cricket cr =new Cricket();
    OtherSports ot = new OtherSports();
    More mr =new More();
    Fanzone fn = new Fanzone();
    SignIn sn = new SignIn();
    Share sh = new Share();
    Contact cn =new Contact();

    Button btnSignIn,btnSignUp;
    LoginDatabaseAdapter loginDatabaseAdapter;

    OkHttpClient client = new OkHttpClient();

    public String url= "https://reqres.in/api/users/2";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTransaction t = getFragmentManager().beginTransaction();
        t.replace(R.id.fr1, hm);
        t.commit();

        loginDatabaseAdapter = new LoginDatabaseAdapter(this);
        loginDatabaseAdapter = loginDatabaseAdapter.open();


        btnSignIn = findViewById(R.id.buttonSignIN);
        btnSignUp = findViewById(R.id.buttonSignUP);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentSignUP = new Intent(getApplicationContext(),sign_up.class);
                startActivity(intentSignUP);

            }
        });

        OkHttpHandler okHttpHandler= new OkHttpHandler(this);
        okHttpHandler.execute(url);
        //bt1=findViewById(R.id.bt1);
        //bt1.setOnClickListener(new View.OnClickListener() {
         //   @Override
           // public void onClick(View view) {
             //   AlertDialog.Builder ab = new AlertDialog.Builder(MainActivity.this);
              //  ab.setTitle("Do you want to exit..!!");
               // ab.setCancelable(false);

                //ab.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                  //  @Override
                    //public void onClick(DialogInterface dialogInterface, int i) {
                   //     finish();

                   // }
              //  });
               // ab.setNegativeButton("No", new DialogInterface.OnClickListener() {
                 //   @Override
                  //  public void onClick(DialogInterface dialogInterface, int i) {
                   //     dialogInterface.cancel();
                 //   }
               // });

   //             AlertDialog c = ab.create();
  //              c.show();
//
 //           }
//        };




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
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    //Databse//


     public void SignIn(View v)
     {
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.signin);
        dialog.setTitle("Sign IN");

         final EditText editTextUserName = dialog.findViewById(R.id.editTextUserNameToLogin);
         final EditText editTextPassword = dialog.findViewById(R.id.editTextPasswordToLogin);

         Button btnSignIn = dialog.findViewById(R.id.buttonSignIN);
         btnSignIn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String userName= editTextUserName.getText().toString();
                 String password= editTextPassword.getText().toString();

                 String storedPassword = loginDatabaseAdapter.getSingleEntry(userName);

                 if (password.equals(storedPassword))
                 {
                     Intent in = new Intent
                             (MainActivity.this,LoggedData.class);
                     in.putExtra("name",userName);
                     in.putExtra("password",password);
                     startActivity(in);

                     Toast.makeText(MainActivity.this,"Login Successfull",
                             Toast.LENGTH_LONG).show();
                     dialog.dismiss();
                 }
                 else {
                     Toast.makeText(MainActivity.this,
                             "User Name or Password not Match",Toast.LENGTH_LONG).show();
                 }

             }
         });
         dialog.show();
     }
        @Override
        protected void onDestroy(){
        super.onDestroy();
        loginDatabaseAdapter.close();
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
        getMenuInflater().inflate(R.menu.main, menu);
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

        if (id == R.id.nav_home) {
            FragmentTransaction t = getFragmentManager().beginTransaction();
            t.replace(R.id.fr1,hm);
            t.commit();
        } else if (id == R.id.nav_foot) {
            FragmentTransaction t1 = getFragmentManager().beginTransaction();
            t1.replace(R.id.fr1,ft);
            t1.commit();

        } else if (id == R.id.nav_cric) {
            FragmentTransaction t2 = getFragmentManager().beginTransaction();
            t2.replace(R.id.fr1,cr);
            t2.commit();

        } else if (id == R.id.nav_other) {
            FragmentTransaction t3 =getFragmentManager().beginTransaction();
            t3.replace(R.id.fr1,ot);
            t3.commit();

        } else if (id == R.id.nav_more) {
            FragmentTransaction t4 =getFragmentManager().beginTransaction();
            t4.replace(R.id.fr1,mr);
            t4.commit();

        } else if (id == R.id.nav_fan) {
            FragmentTransaction t5 =getFragmentManager().beginTransaction();
            t5.replace(R.id.fr1,fn);
            t5.commit();

        } else if (id ==R.id.nav_sign) {
            FragmentTransaction t6 =getFragmentManager().beginTransaction();
            t6.replace(R.id.fr1,sn);
            t6.commit();

        } else if (id ==R.id.nav_share) {
            FragmentTransaction t7 =getFragmentManager().beginTransaction();
            t7.replace(R.id.fr1,sh);
            t7.commit();

        } else if (id ==R.id.nav_cont) {
            FragmentTransaction t8= getFragmentManager().beginTransaction();
            t8.replace(R.id.fr1,cn);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public String retunA(String str) {
        Log.d("TAGS",str);
        return null;
    }
}
