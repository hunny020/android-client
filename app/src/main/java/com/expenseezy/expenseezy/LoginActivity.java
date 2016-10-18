package com.expenseezy.expenseezy;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.expenseezy.expenseezy.netowrking.APIService;
import com.expenseezy.expenseezy.netowrking.LoginResponse;
import com.expenseezy.expenseezy.netowrking.MyLoginRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends Activity {

    EditText userId;
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);
    }


    public void loginButtonClicked(View v){
        userId = (EditText) findViewById(R.id.loginUserIdEditTextField);
        password = (EditText) findViewById(R.id.loginPasswordEditTextField);
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.0.2:5000")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        APIService service = retrofit.create(APIService.class);
        MyLoginRequest myLoginRequest = new MyLoginRequest();
        myLoginRequest.setUserId(userId.getText().toString());
        myLoginRequest.setPassword(password.getText().toString());
        Call<LoginResponse> loginResponseCall = service.getLoginPermission(myLoginRequest);
        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                String responseString = response.body().getLoginPermissionString();
                Boolean loginFlag = Boolean.valueOf(responseString);
                if(loginFlag==true){
                    Intent intent = new Intent();
                    intent.setClass(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(LoginActivity.this,"Incorrect Username Or Password",Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });
    }

}
