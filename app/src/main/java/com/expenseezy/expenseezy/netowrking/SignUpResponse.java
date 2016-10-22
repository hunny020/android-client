package com.expenseezy.expenseezy.netowrking;

import com.google.gson.annotations.SerializedName;

/**
 * Created by hasneetsingh on 18/10/16.
 */

public class SignUpResponse {
    @SerializedName("signUpSuccess")
    String signUpSuccess;

    public String getSignUpSuccessResponse() {
        return signUpSuccess;
    }
}
