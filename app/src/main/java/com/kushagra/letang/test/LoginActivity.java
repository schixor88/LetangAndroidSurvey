package com.kushagra.letang.test;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.kushagra.letang.test.model.User;
import com.rey.material.widget.CheckBox;

public class LoginActivity extends AppCompatActivity {

    EditText login_phone,login_pass;
    Button login_btn;
    CheckBox checkBox;

//    FirebaseAuth mAuth;
    FirebaseDatabase database;

    DatabaseReference table_user;

    SharedPreferences mPreferences;
    SharedPreferences.Editor mEditor;

    String sUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().setTitle("Login");

        //sharedpref
        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mPreferences.edit();



        NetworkInfo info = (NetworkInfo) ((ConnectivityManager)
                getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();

        if (info == null)
        {
            Toast.makeText(LoginActivity.this, "Please Connect to Internet", Toast.LENGTH_SHORT).show();
        }
        else
        {
            if(info.isConnected())
            {
                Toast.makeText(LoginActivity.this, " Internet Connection!", Toast.LENGTH_SHORT).show();

            }
            else
            {
                Toast.makeText(LoginActivity.this, "No Internet!", Toast.LENGTH_SHORT).show();
            }

        }


        database = FirebaseDatabase.getInstance();
        table_user = database.getReference("User");



       login_phone = (EditText)findViewById(R.id.login_phone);
       login_pass = (EditText)findViewById(R.id.login_password);
       login_btn = (Button)findViewById(R.id.btn_login);
       //checkBox = (CheckBox)findViewById(R.id.checkRemember);



        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (!login_phone.getText().toString().isEmpty() || !login_pass.getText().toString().isEmpty()) {


                    final ProgressDialog mDialog = new ProgressDialog(LoginActivity.this);
                    mDialog.setMessage("Please Wait!");
                    mDialog.show();
                    mDialog.setCanceledOnTouchOutside(false);


                    String hello = "Hello";


                    table_user.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            if (dataSnapshot.child(login_phone.getText().toString()).exists()) {

                                mDialog.dismiss();

                                User user = dataSnapshot.child(login_phone.getText().toString()).getValue(User.class);

                                if (user.getPassword().equals(login_pass.getText().toString())) {

                                    mEditor.putString("uPhone", login_phone.getText().toString());
                                    mEditor.commit();

                                    Toast.makeText(LoginActivity.this, "Success", Toast.LENGTH_SHORT).show();
                                    Intent i = new Intent(LoginActivity.this, MainActivity.class);
                                    startActivity(i);
                                    finish();

                                } else {
                                    Toast.makeText(LoginActivity.this, "Login Failed!", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                mDialog.dismiss();
                                Toast.makeText(LoginActivity.this, "No User Found!", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                } else {
                    Toast.makeText(LoginActivity.this, "Check Login Credentials!", Toast.LENGTH_SHORT).show();
                }
            }
        });



        }

    @Override
    protected void onStart() {
        super.onStart();

        sUser = mPreferences.getString("uPhone","blank");
        Toast.makeText(this, ""+sUser, Toast.LENGTH_SHORT).show();

        if (!sUser.equals("blank")){
            Intent i = new Intent(LoginActivity.this,MainActivity.class);
            startActivity(i);
            finish();
        }

    }




    }



