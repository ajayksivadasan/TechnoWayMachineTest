package com.aks.technowaymachinetest.loginpkg;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class LoginSendData {
    @SerializedName("UserID")
    private String UserID;
    @SerializedName("Password")
    private String Password;

    public static LoginSendData objectFromData(String str) {

        return new Gson().fromJson(str, LoginSendData.class);
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
}
