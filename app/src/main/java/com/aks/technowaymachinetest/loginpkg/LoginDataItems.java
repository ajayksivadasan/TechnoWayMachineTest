package com.aks.technowaymachinetest.loginpkg;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class LoginDataItems {
    @SerializedName("UserID")
    private Object UserID;
    @SerializedName("UserName")
    private Object UserName;
    @SerializedName("RoleID")
    private int RoleID;
    @SerializedName("DeptID")
    private int DeptID;
    @SerializedName("RetValue")
    private int RetValue;
    @SerializedName("Status")
    private boolean Status;
    @SerializedName("ErrorDescription")
    private String ErrorDescription;

    public static LoginDataItems objectFromData(String str) {

        return new Gson().fromJson(str, LoginDataItems.class);
    }

    public Object getUserID() {
        return UserID;
    }

    public void setUserID(Object UserID) {
        this.UserID = UserID;
    }

    public Object getUserName() {
        return UserName;
    }

    public void setUserName(Object UserName) {
        this.UserName = UserName;
    }

    public int getRoleID() {
        return RoleID;
    }

    public void setRoleID(int RoleID) {
        this.RoleID = RoleID;
    }

    public int getDeptID() {
        return DeptID;
    }

    public void setDeptID(int DeptID) {
        this.DeptID = DeptID;
    }

    public int getRetValue() {
        return RetValue;
    }

    public void setRetValue(int RetValue) {
        this.RetValue = RetValue;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean Status) {
        this.Status = Status;
    }

    public String getErrorDescription() {
        return ErrorDescription;
    }

    public void setErrorDescription(String ErrorDescription) {
        this.ErrorDescription = ErrorDescription;
    }
}
