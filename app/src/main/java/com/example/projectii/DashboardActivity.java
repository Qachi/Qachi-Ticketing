package com.example.projectii;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class DashboardActivity extends AppCompatActivity {

    Toolbar toolbar;
    BottomNavigationView bottom_nav;



    public void logout() {
        Intent intent = new Intent(DashboardActivity.this,MainActivity.class);
        startActivity(intent);

    }
    // for the customer service chat
    public void menuAlertDialog(){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("ENQUIRES / COMPLAINS");
        EditText cs = new EditText(this);
        builder.setView(cs);
        builder.setIcon(android.R.drawable.ic_menu_view);
        builder.setPositiveButton("SEND", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                localNotification();
                Toast.makeText(DashboardActivity.this, "Message Sent", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.show();


    }

    public void localNotification(){
        Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(),1,intent,0);

        Notification notification = new Notification.Builder(getApplicationContext())
                .setContentTitle("QACHI")
                .setContentText("Thank you for contacting us")
                .setContentIntent(pendingIntent)
//                .addAction(android.R.drawable.sym_action_chat,pendingIntent)
                .setSmallIcon(android.R.drawable.sym_action_chat)
                .build();

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(1,notification);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        toolbar = findViewById(R.id.toolbar);
        toolbar = findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.toolbar_menu);
        toolbar.setTitle("Qachi");
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.holo_orange_dark));
        toolbar.setLogo(R.drawable.ic_notifications_black_24dp);
        bottom_nav =findViewById(R.id.bottom_nav);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_test,new HomeFragment()).commit();


        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.about_Us) {
                    Toast.makeText(DashboardActivity.this, "About Us Clicked", Toast.LENGTH_SHORT).show();

                } else if (item.getItemId() == R.id.transactions) {
                    Toast.makeText(DashboardActivity.this, "Transactions Clicked", Toast.LENGTH_SHORT).show();                }

                return true;
            }

        });

        bottom_nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

//                Fragment selectedFragment =null;

                switch (menuItem.getItemId()) {
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_test,new HomeFragment()).commit();

//                        selectedFragment = new HomeFragment();

                        break;
                    case R.id.profile:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_test,new ProfileFragment()).commit();

//                        selectedFragment = new ProfileFragment();

                        break;
                    case R.id.logout:
                        logout();

                        break;

                    case R.id.support:
                        menuAlertDialog();

                        break;

                        default:
                            return false;



//                } if (menuItem.getItemId() == R.id.support){
//                    logout();
//                    Toast.makeText(DashboardActivity.this, "support", Toast.LENGTH_SHORT).show();
                }
//                 getSupportFragmentManager().beginTransaction().replace(R.id.fragment_test,selectedFragment).addToBackStack(null).commit();

                return true;


            }


        });


    }
}
