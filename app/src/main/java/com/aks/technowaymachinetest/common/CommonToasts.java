package com.aks.technowaymachinetest.common;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

import com.aks.technowaymachinetest.R;


public class CommonToasts {
    public static final String SOMETHING_ERROR_OCCURRED = "SOMETHING ERROR OCCURRED";
    public static final String IMAGE_NOT_AVAILABLE = "Image NOT available";
    public static final String INTERNET_NOT_AVAILABLE = "Internet Not Available";
    public static final String SUCCESSFULLY_UPDATED = "Successfully Updated";
    public static final String NOTHING_TO_UPLOAD = "Nothing To Upload";
    final Context context;

    public CommonToasts(Context context) {
        this.context = context;
    }

    public void setToastMessage(String message) {
        Toast toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        toast.setText(message);
        toast.setDuration(Toast.LENGTH_SHORT);
        View view = toast.getView();
        view.setBackgroundColor(ContextCompat.getColor(context, R.color.basicColor));
        view.setBackground(ContextCompat.getDrawable(context, R.drawable.et_bg_login));
        TextView text = view.findViewById(android.R.id.message);
        text.setTextColor(ContextCompat.getColor(context, R.color.black));
        toast.show();
    }
}
