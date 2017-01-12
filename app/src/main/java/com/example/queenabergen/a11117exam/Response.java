package com.example.queenabergen.a11117exam;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by queenabergen on 1/11/17.
 */

public class Response {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("available keys")
    @Expose
    private List<AvailableKeys> majorKey = null;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<AvailableKeys> getMajorKey() {
        return majorKey;
    }

    public void setMajorKey(List<AvailableKeys> majorKey) {
        this.majorKey = majorKey;
    }
}
