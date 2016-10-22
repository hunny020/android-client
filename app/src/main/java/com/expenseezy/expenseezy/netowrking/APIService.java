package com.expenseezy.expenseezy.netowrking;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by hasneetsingh on 18/10/16.
 */

public interface APIService {

    @POST("/login")
    Call<LoginResponse> getLoginPermission(@Body MyLoginRequest myLoginRequest);

    @POST("/signup")
    Call<SignUpResponse> getSignupResponse(@Body MySignUpRequest mySignUpRequest);
}
