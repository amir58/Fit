package com.amirmohammed.fit.requests;

import android.net.Uri;

import com.google.gson.annotations.SerializedName;

import okhttp3.RequestBody;

public class RegisterRequestBody {

    @SerializedName("Goal_Type")
    private RequestBody goalType;

    @SerializedName("Email")
    private RequestBody email;

    @SerializedName("Hours")
    private RequestBody hours;

    @SerializedName("Effort")
    private RequestBody effort;

    @SerializedName("Gender")
    private RequestBody gender;

    @SerializedName("Image")
    private String imageUri;

    @SerializedName("Weight")
    private RequestBody weight;

    @SerializedName("Name")
    private RequestBody name;

    @SerializedName("Sport")
    private RequestBody sport;

    @SerializedName("Username")
    private RequestBody username;

    @SerializedName("Height")
    private RequestBody height;

    @SerializedName("Goal_Weight")
    private RequestBody goalWeight;

    @SerializedName("Train")
    private RequestBody train;

    @SerializedName("Age")
    private RequestBody age;

    @SerializedName("Password")
    private RequestBody password;

    @SerializedName("password2")
    private RequestBody confirmPassword;


    public RequestBody getGoalType() {
        return goalType;
    }

    public void setGoalType(RequestBody goalType) {
        this.goalType = goalType;
    }

    public RequestBody getEmail() {
        return email;
    }

    public void setEmail(RequestBody email) {
        this.email = email;
    }

    public RequestBody getHours() {
        return hours;
    }

    public void setHours(RequestBody hours) {
        this.hours = hours;
    }

    public RequestBody getEffort() {
        return effort;
    }

    public void setEffort(RequestBody effort) {
        this.effort = effort;
    }

    public RequestBody getGender() {
        return gender;
    }

    public void setGender(RequestBody gender) {
        this.gender = gender;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    public RequestBody getWeight() {
        return weight;
    }

    public void setWeight(RequestBody weight) {
        this.weight = weight;
    }

    public RequestBody getName() {
        return name;
    }

    public void setName(RequestBody name) {
        this.name = name;
    }

    public RequestBody getSport() {
        return sport;
    }

    public void setSport(RequestBody sport) {
        this.sport = sport;
    }

    public RequestBody getUsername() {
        return username;
    }

    public void setUsername(RequestBody username) {
        this.username = username;
    }

    public RequestBody getHeight() {
        return height;
    }

    public void setHeight(RequestBody height) {
        this.height = height;
    }

    public RequestBody getGoalWeight() {
        return goalWeight;
    }

    public void setGoalWeight(RequestBody goalWeight) {
        this.goalWeight = goalWeight;
    }

    public RequestBody getTrain() {
        return train;
    }

    public void setTrain(RequestBody train) {
        this.train = train;
    }

    public RequestBody getAge() {
        return age;
    }

    public void setAge(RequestBody age) {
        this.age = age;
    }

    public RequestBody getPassword() {
        return password;
    }

    public void setPassword(RequestBody password) {
        this.password = password;
    }

    public RequestBody getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(RequestBody confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Override
    public String toString() {
        return "RegisterRequestBody{" +
                "goalType=" + goalType +
                ", email=" + email +
                ", hours=" + hours +
                ", effort=" + effort +
                ", gender=" + gender +
                ", imageUri='" + imageUri + '\'' +
                ", weight=" + weight +
                ", name=" + name +
                ", sport=" + sport +
                ", username=" + username +
                ", height=" + height +
                ", goalWeight=" + goalWeight +
                ", train=" + train +
                ", age=" + age +
                ", password=" + password +
                '}';
    }
}
