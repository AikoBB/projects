package com.iko.android.weather.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Aigerim on 4/6/2018.
 */

public class ForeCast implements Serializable{

    @SerializedName("code")
    @Expose
    private String code;

    @SerializedName("date")
    @Expose
    private String date;

    @SerializedName("day")
    @Expose
    private String day;

    @SerializedName("high")
    @Expose
    private String high;

    @SerializedName("low")
    @Expose
    private String low;

    @SerializedName("text")
    @Expose
    private String text;

    public ForeCast(String day, String high, String low, String text) {
        this.day = day;
        this.high = high;
        this.low = low;
        this.text = text;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}