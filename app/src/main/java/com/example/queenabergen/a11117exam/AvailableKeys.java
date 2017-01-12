package com.example.queenabergen.a11117exam;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by queenabergen on 1/11/17.
 */

public class AvailableKeys {

    @SerializedName("name")
    @Expose
    private String mName;
    @SerializedName("textColor")
    @Expose
    private String mTextColor;
    @SerializedName("url")
    @Expose
    private String mUrl;

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmTextColor() {
        return mTextColor;
    }

    public void setmTextColor(String mTextColor) {
        this.mTextColor = mTextColor;
    }

    public String getmUrl() {
        return mUrl;
    }

    public void setmUrl(String mUrl) {
        this.mUrl = mUrl;
    }
}
