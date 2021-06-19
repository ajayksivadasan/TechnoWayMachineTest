package com.aks.technowaymachinetest.loginpkg;

import android.os.Bundle;
import android.util.Base64;

import androidx.appcompat.app.AppCompatActivity;

import com.aks.technowaymachinetest.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    private String convert_toBase64(String passWord) {
        return Base64.encodeToString(passWord.getBytes(), Base64.NO_WRAP);
    }
}