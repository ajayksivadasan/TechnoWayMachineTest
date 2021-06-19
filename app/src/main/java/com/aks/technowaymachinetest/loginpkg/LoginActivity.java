package com.aks.technowaymachinetest.loginpkg;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.aks.technowaymachinetest.MainActivity;
import com.aks.technowaymachinetest.R;
import com.aks.technowaymachinetest.common.CommonToasts;
import com.aks.technowaymachinetest.retrofit.ApiClient;
import com.aks.technowaymachinetest.retrofit.ApiInterface;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    Context context;
    CommonToasts commonToasts;
    ApiInterface apiInterface;
    private EditText etUserName;
    private EditText etPassword;
    private Button btLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_login);
        initIds();
        commonToasts = new CommonToasts(context);
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        btLogin.setOnClickListener(view -> {
            if (etUserName.getText() != null || !etUserName.getText().toString().trim().equals("") || etPassword.getText() != null || !etPassword.getText().toString().trim().equals("")) {
                LoginSendData sendData = new LoginSendData();
                sendData.setUserID(etUserName.getText().toString().trim());
                try {
                    sendData.setPassword(convertToBase64(etPassword.getText().toString().trim()));
                } catch (Exception e) {
                    sendData.setPassword("");
                    e.printStackTrace();
                }
                Call<LoginDataItems> dataItemsCall = apiInterface.callLoginDataItemsCall(sendData);
                dataItemsCall.enqueue(new Callback<LoginDataItems>() {
                    @Override
                    public void onResponse(@NotNull Call<LoginDataItems> call, @NotNull Response<LoginDataItems> response) {
                        if (response.code() == 200) {
                            Intent intent = new Intent(context, MainActivity.class);
                            startActivity(intent);
                        } else {
                            commonToasts.setToastMessage("Error " + response.message());
                        }
                    }

                    @Override
                    public void onFailure(@NotNull Call<LoginDataItems> call, @NotNull Throwable t) {
                        commonToasts.setToastMessage("Error" + t.getMessage());
                    }
                });
            } else {
                commonToasts.setToastMessage(getString(R.string.user_name_or_password));
            }
        });
    }

    private void initIds() {
        etUserName = findViewById(R.id.etUserName);
        etPassword = findViewById(R.id.etPassword);
        btLogin = findViewById(R.id.btLogin);
    }

    private String convertToBase64(String passWord) {
        return Base64.encodeToString(passWord.getBytes(), Base64.NO_WRAP);
    }
}