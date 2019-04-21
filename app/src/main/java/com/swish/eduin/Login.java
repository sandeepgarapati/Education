package com.swish.eduin;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;

public class Login extends AppCompatActivity {

    DataBaseHelper helper = new DataBaseHelper(this);
    Button button;
    EditText username, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        button = (Button) findViewById(R.id.login);
        username = (EditText) findViewById(R.id.user);
        pass = (EditText) findViewById(R.id.pass) ;



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(username.getText())) {
                    Toast toast = new Toast(Login.this);
                    Toast.makeText(Login.this, "Enter all the fields", Toast.LENGTH_LONG).show();
                    toast.setGravity(Gravity.TOP | Gravity.LEFT, 20, 20);
                    username.setError("username");
                }
                else if (TextUtils.isEmpty(pass.getText())){
                    Toast toast1 = new Toast(Login.this);
                    Toast.makeText(Login.this, "Enter all the fields", Toast.LENGTH_LONG).show();
                    toast1.setGravity(Gravity.TOP | Gravity.LEFT, 20, 20);
                    pass.setError("password");
                }
                else{
                    String uname=username.getText().toString();
                    String password = pass.getText().toString();
                    String md5Pass=md5(password);
                    int dbPass=helper.searchPass(uname,password);

                    if(dbPass>0){
                        Intent intent = new Intent(Login.this, Screen2.class);
                        intent.putExtra("Username", uname);
                        startActivity(intent);
                        Toast toast = new Toast(Login.this);
                        Toast.makeText(Login.this, "Login successful", Toast.LENGTH_LONG).show();
                        toast.setGravity(Gravity.TOP | Gravity.LEFT, 20, 20);

                    }
                    else{
                        Toast toast3 = new Toast(Login.this);
                        Toast.makeText(Login.this, "wrong password and username", Toast.LENGTH_LONG).show();
                        toast3.setGravity(Gravity.TOP | Gravity.LEFT, 20, 20);

                    }
                }

            }
        });

    }
    public void register(View view){
        Intent intent2 = new Intent(Login.this, Registration.class);
        startActivity(intent2);
    }
    private static final String md5 ( final String password){
        try {

            MessageDigest digest = MessageDigest
                    .getInstance("MD5");
            digest.update(password.getBytes());
            byte messageDigest[] = digest.digest();

            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < messageDigest.length; i++) {
                String h = Integer.toHexString(0xFF & messageDigest[i]);
                while (h.length() < 2)
                    h = "0" + h;
                hexString.append(h);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";


    }
}




