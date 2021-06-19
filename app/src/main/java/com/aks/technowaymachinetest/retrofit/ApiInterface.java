package com.aks.technowaymachinetest.retrofit;

import com.aks.technowaymachinetest.loginpkg.HomePageItemsFromWeb;
import com.aks.technowaymachinetest.loginpkg.LoginDataItems;
import com.aks.technowaymachinetest.loginpkg.LoginSendData;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {
    @POST("TESTAPI/api/Users/UserAuthentication")
    Call<LoginDataItems> callLoginDataItemsCall(@Body LoginSendData data);

    @GET("v3/bd26945d-228e-45b4-94a3-04c74f085e40")
    Call<HomePageItemsFromWeb> caHomePageItemsFromWebCall();
}
