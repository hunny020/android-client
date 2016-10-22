package com.expenseezy.expenseezy;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.expenseezy.expenseezy.netowrking.APIService;
import com.expenseezy.expenseezy.netowrking.MySignUpRequest;
import com.expenseezy.expenseezy.netowrking.SignUpResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignUpActivity extends Activity {

    EditText username;
    EditText userId;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    /* Hits the server with the entered username, loginId and password and returns a String (true) or (false)
   * which is type casted to boolean.
   * if(true) launches new activity otherwise show Toast*/

    public void signUpSubmitButtonClicked(View v){
        username = (EditText) findViewById(R.id.signUpUsernameEditTextField);
        userId = (EditText) findViewById(R.id.signUpUserIdEditTextField);
        password = (EditText) findViewById(R.id.signUpPasswordEditTextField);
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.43.164:5000")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        APIService service = retrofit.create(APIService.class);
        MySignUpRequest mySignUpRequest = new MySignUpRequest();
        mySignUpRequest.setUsername(username.getText().toString());
        mySignUpRequest.setUserId(userId.getText().toString());
        mySignUpRequest.setPassword(password.getText().toString());
        Call<SignUpResponse> signUpResponseCall = service.getSignupResponse(mySignUpRequest);
        signUpResponseCall.enqueue(new Callback<SignUpResponse>() {
            @Override
            public void onResponse(Call<SignUpResponse> call, Response<SignUpResponse> response) {
                Boolean signUpSuccess = Boolean.valueOf(response.body().getSignUpSuccessResponse());
                if(signUpSuccess==true){
                    Toast.makeText(SignUpActivity.this,"SUCCESSFULLY SIGNED UP",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent();
                    intent.setClass(SignUpActivity.this,MainActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(SignUpActivity.this,"UNSUCCESSFUL TO SIGN UP",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<SignUpResponse> call, Throwable t) {
                Toast.makeText(SignUpActivity.this,"signUp OnFailure",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
