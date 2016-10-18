package com.expenseezy.expenseezy.netowrking;

import com.google.gson.annotations.SerializedName;

/**
 * Created by hasneetsingh on 18/10/16.
 */

public class LoginResponse {

    @SerializedName("loginPermission")
    String loginPermission;

    public String getLoginPermissionString() {
        return loginPermission;
    }

}
