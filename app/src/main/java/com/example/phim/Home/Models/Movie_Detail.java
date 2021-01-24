package com.example.phim.Home.Models;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Movie_Detail {

    @SerializedName("director")
    @Expose
    private String director;
    @SerializedName("introduce")
    @Expose
    private String introduce;
    @SerializedName("length")
    @Expose
    private String length;
    @SerializedName("trailer")
    @Expose
    private String trailer;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("countries_name")
    @Expose
    private String countriesName;
    @SerializedName("opening_day")
    @Expose
    private String openingDay;
    @SerializedName("rate")
    @Expose
    private String rate;
    @SerializedName("age_limit")
    @Expose
    private String ageLimit;

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCountriesName() {
        return countriesName;
    }

    public void setCountriesName(String countriesName) {
        this.countriesName = countriesName;
    }

    public String getOpeningDay() {
        return openingDay;
    }

    public void setOpeningDay(String openingDay) {
        this.openingDay = openingDay;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(String ageLimit) {
        this.ageLimit = ageLimit;
    }

}