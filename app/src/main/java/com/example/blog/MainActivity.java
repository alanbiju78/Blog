package com.example.blog;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2;
    AppCompatButton bt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        SharedPreferences preferences=getSharedPreferences("MyPrefs",MODE_PRIVATE);
        String user=preferences.getString("user","null");
        if(user!="null"){
            Intent i=new Intent(getApplicationContext(), Homepage.class);
            startActivity(i);
        }
        e1=(EditText) findViewById(R.id.uname);
        e2=(EditText) findViewById(R.id.pass);
        bt1=(AppCompatButton) findViewById(R.id.logbt);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getUsername = e1.getText().toString();
                String getPassword = e2.getText().toString();
                if(getUsername.equals("admin")&&getPassword.equals("12345"))
                {
                    SharedPreferences preferences=getSharedPreferences("MyPrefs",MODE_PRIVATE);
                    SharedPreferences.Editor editor=preferences.edit();
                    editor.putString("user","admin");
                    editor.apply();
                    Intent i=new Intent(getApplicationContext(), Homepage.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Invalid Credentials",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}