package com.aks.technowaymachinetest.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aks.technowaymachinetest.R;
import com.aks.technowaymachinetest.loginpkg.HomePageItemsFromWeb;
import com.squareup.picasso.Picasso;

import java.util.List;

public class HomePageAdapter extends RecyclerView.Adapter<HomePageAdapter.HomeViewHolder> {
    List<HomePageItemsFromWeb.ProductsDTO> productsDTOList;
    Context context;

    public HomePageAdapter(Context context, List<HomePageItemsFromWeb.ProductsDTO> productsDTOList) {
        this.context = context;
        this.productsDTOList = productsDTOList;
    }

    public void updateAdapter(List<HomePageItemsFromWeb.ProductsDTO> productsDTOList) {
        this.productsDTOList = productsDTOList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HomePageAdapter.HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_page_view_item, parent, false);
        return new HomeViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull HomePageAdapter.HomeViewHolder holder, int position) {
        holder.tvTitleProducts.setText("Title: " + productsDTOList.get(position).getTitle());
        holder.tvPriceProduct.setText("Price: " + productsDTOList.get(position).getPrice());
        holder.tvProductDescription.setText("Description: " + productsDTOList.get(position).getDescription());
        Picasso.with(context).load(productsDTOList.get(position).getImageUrl()).into(holder.imProductImage);
    }

    @Override
    public int getItemCount() {
        return productsDTOList.size();
    }

    public static class HomeViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitleProducts;
        TextView tvPriceProduct;
        TextView tvProductDescription;
        ImageView imProductImage;

        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitleProducts = itemView.findViewById(R.id.tvTitleProducts);
            tvPriceProduct = itemView.findViewById(R.id.tvPriceProduct);
            tvProductDescription = itemView.findViewById(R.id.tvProductDescription);
            imProductImage = itemView.findViewById(R.id.imProductImage);
        }
    }
}
