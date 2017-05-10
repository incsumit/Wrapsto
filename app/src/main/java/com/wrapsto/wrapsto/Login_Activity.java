package com.wrapsto.wrapsto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.HashMap;
import java.util.Map;

public class Login_Activity extends AppCompatActivity {
    Firebase ref;
    EditText address,phone;
    Button proceed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);
        Firebase.setAndroidContext(this);
        ref=new Firebase("http://wrapsto.firebaseio.com");
        address=(EditText)findViewById(R.id.ed1);
        phone=(EditText)findViewById(R.id.ed2);
        proceed=(Button)findViewById(R.id.b1);
    }
    public void onProceed(View v) {
        int length = phone.getText().length();
        if(length==10)
        {
        ref.authAnonymously(new Firebase.AuthResultHandler() {
            @Override
            public void onAuthenticated(AuthData authData) {
                Map<String, String> map = new HashMap<String, String>();
                map.put("Address", address.getText().toString());
                map.put("Phone", phone.getText().toString());
                ref.child("orders").child(authData.getUid()).setValue(map);
                Intent i = new Intent(Login_Activity.this, NavigationActivity.class);
                startActivity(i);
            }

            @Override
            public void onAuthenticationError(FirebaseError firebaseError) {
                Toast.makeText(Login_Activity.this, "Session denied! Check your internet connection and please try again!", Toast.LENGTH_SHORT).show();
            }
        });
    }
        else
        {
            Toast.makeText(Login_Activity.this, "Invalid Phone Number", Toast.LENGTH_SHORT).show();
        }
    }
}

