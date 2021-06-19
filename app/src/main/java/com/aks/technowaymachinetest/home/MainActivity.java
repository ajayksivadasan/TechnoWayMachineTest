package com.aks.technowaymachinetest.home;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aks.technowaymachinetest.R;
import com.aks.technowaymachinetest.common.CommonToasts;
import com.aks.technowaymachinetest.loginpkg.HomePageItemsFromWeb;
import com.aks.technowaymachinetest.retrofit.ApiClient;
import com.aks.technowaymachinetest.retrofit.ApiInterface;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    CommonToasts commonToasts;
    ApiInterface apiInterface;
    List<HomePageItemsFromWeb.ProductsDTO> productsDTOList = new ArrayList<>();
    HomePageAdapter homePageAdapter;
    private RecyclerView rvHomePageItems;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initIds();
        homePageAdapter = new HomePageAdapter(context, productsDTOList);
        commonToasts = new CommonToasts(context);
        apiInterface = ApiClient.getApiClient1().create(ApiInterface.class);
        rvHomePageItems.setLayoutManager(new LinearLayoutManager(context));
        rvHomePageItems.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));
        rvHomePageItems.setAdapter(homePageAdapter);
        Call<HomePageItemsFromWeb> productsDTOCall = apiInterface.caHomePageItemsFromWebCall();
        productsDTOCall.enqueue(new Callback<HomePageItemsFromWeb>() {
            @Override
            public void onResponse(@NotNull Call<HomePageItemsFromWeb> call, @NotNull Response<HomePageItemsFromWeb> response) {
                if (response.code() == 200) {
                    if (response.body() != null) {
                        if (response.body().isStatus()) {
                            productsDTOList = response.body().getProducts();
                            homePageAdapter.updateAdapter(productsDTOList);
                        } else {
                            commonToasts.setToastMessage("" + response.body().getMsg());
                        }
                    }
                } else {
                    commonToasts.setToastMessage("Error" + response.message());
                }
            }

            @Override
            public void onFailure(@NotNull Call<HomePageItemsFromWeb> call, @NotNull Throwable t) {
                commonToasts.setToastMessage("Error" + t.getMessage());
            }
        });
    }

    private void initIds() {
        context = this;
        rvHomePageItems = findViewById(R.id.rvHomePageItems);
    }
}