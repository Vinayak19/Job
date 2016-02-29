package com.example.vinaya.job;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.vinaya.library.DatabaseHandler;

import java.util.HashMap;

public class Registered extends Activity {

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registered);

        DatabaseHandler db = new DatabaseHandler(getApplicationContext());

        HashMap user = new HashMap();
        user = db.getUserDetails();

        /**
         * Displays the registration details in Text view
         **/

        final TextView fname = (TextView)findViewById(R.id.fname);
        final TextView phone = (TextView)findViewById(R.id.phone);
        final TextView uname = (TextView)findViewById(R.id.uname);
        final TextView email = (TextView)findViewById(R.id.email);
        final TextView created_at = (TextView)findViewById(R.id.regat);
        fname.setText(user.get("fname").toString());
        phone.setText(user.get("phone").toString());
        uname.setText(user.get("uname").toString());
        email.setText(user.get("email").toString());
        created_at.setText(user.get("created_at").toString());

        Button login = (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), Login.class);
                startActivityForResult(myIntent, 0);
                finish();
            }

        });

    }}

