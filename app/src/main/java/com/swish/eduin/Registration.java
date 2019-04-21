package com.swish.eduin;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
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

public class Registration extends AppCompatActivity {


    EditText urname, urpswd, ConfirmPassword,phoneNo;
    DataBaseHelper helper=new DataBaseHelper(this);

    @SuppressLint("WrongViewCast")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);

        urname = (EditText) findViewById(R.id.userName);
        phoneNo = (EditText) findViewById(R.id.phoneNo);
        urpswd = (EditText) findViewById(R.id.password);
        Button button = (Button) findViewById(R.id.register1);
        ConfirmPassword = (EditText) findViewById(R.id.confirm);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String username = urname.getText().toString();
                String password = urpswd.getText().toString();
                String phone = phoneNo.getText().toString();
                String confirmPassword = ConfirmPassword.getText().toString();

                if (TextUtils.isEmpty(urname.getText())) {

                    Toast toast1 = new Toast(Registration.this);
                    Toast.makeText(Registration.this, "Enter all the fields", Toast.LENGTH_LONG).show();
                    toast1.setGravity(Gravity.TOP | Gravity.LEFT, 20, 20);
                    urname.setError("username");
                }
                else if (TextUtils.isEmpty(phoneNo.getText())) {
                    Toast toast2 = new Toast(Registration.this);
                    Toast.makeText(Registration.this, "Enter all the fields", Toast.LENGTH_LONG).show();
                    toast2.setGravity(Gravity.TOP | Gravity.LEFT, 20, 20);
                    phoneNo.setError("phone number");
                }

                else if (TextUtils.isEmpty(urpswd.getText())){
                    Toast toast3 = new Toast(Registration.this);
                    Toast.makeText(Registration.this, "Enter all the fields", Toast.LENGTH_LONG).show();
                    toast3.setGravity(Gravity.TOP | Gravity.LEFT, 20, 20);
                    urpswd.setError("password");

                }
                else if (TextUtils.isEmpty(ConfirmPassword.getText())) {
                    Toast toast3 = new Toast(Registration.this);
                    Toast.makeText(Registration.this, "Enter all the fields", Toast.LENGTH_LONG).show();
                    toast3.setGravity(Gravity.TOP | Gravity.LEFT, 20, 20);
                    ConfirmPassword.setError("phone number");
                }
                else if (!password.equals(confirmPassword)) {
                    Toast toast2 = new Toast(Registration.this);
                    Toast.makeText(Registration.this, "wrong password", Toast.LENGTH_LONG).show();
                    toast2.setGravity(Gravity.TOP | Gravity.LEFT, 20, 20);
                }
                else
                {
                    Contact c = new Contact();
                    c.setName(username);
                    c.setPhone_No(phone);
                    c.setPassword(password);
                    helper.insertLoginDB(c);

                    Intent intent3 = new Intent(Registration.this,Screen2.class);
                    startActivity(intent3);

                }
            }
        });
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


