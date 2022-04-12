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

    @SerializedName("password2")
    private RequestBody password2;

    @SerializedName("Goal_Weight")
    private RequestBody goalWeight;

    @SerializedName("Train")
    private RequestBody train;

    @SerializedName("Age")
    private RequestBody age;

    @SerializedName("Password")
    private RequestBody password;

    @SerializedName("Image")
    private String image;

    public void setGoalType(RequestBody goalType){
        this.goalType = goalType;
    }

    public RequestBody getGoalType(){
        return goalType;
    }

    public void setEmail(RequestBody email){
        this.email = email;
    }

    public RequestBody getEmail(){
        return email;
    }

    public void setHours(RequestBody hours){
        this.hours = hours;
    }

    public RequestBody getHours(){
        return hours;
    }

    public void setEffort(RequestBody effort){
        this.effort = effort;
    }

    public RequestBody getEffort(){
        return effort;
    }

    public void setGender(RequestBody gender){
        this.gender = gender;
    }

    public RequestBody getGender(){
        return gender;
    }

    public void setWeight(RequestBody weight){
        this.weight = weight;
    }

    public RequestBody getWeight(){
        return weight;
    }

    public void setName(RequestBody name){
        this.name = name;
    }

    public RequestBody getName(){
        return name;
    }

    public void setSport(RequestBody sport){
        this.sport = sport;
    }

    public RequestBody getSport(){
        return sport;
    }

    public void setUsername(RequestBody username){
        this.username = username;
    }

    public RequestBody getUsername(){
        return username;
    }

    public void setHeight(RequestBody height){
        this.height = height;
    }

    public RequestBody getHeight(){
        return height;
    }

    public void setPassword2(RequestBody password2){
        this.password2 = password2;
    }

    public RequestBody getPassword2(){
        return password2;
    }

    public void setGoalWeight(RequestBody goalWeight){
        this.goalWeight = goalWeight;
    }

    public RequestBody getGoalWeight(){
        return goalWeight;
    }

    public void setTrain(RequestBody train){
        this.train = train;
    }

    public RequestBody getTrain(){
        return train;
    }

    public void setAge(RequestBody age){
        this.age = age;
    }

    public RequestBody getAge(){
        return age;
    }

    public void setPassword(RequestBody password){
        this.password = password;
    }

    public RequestBody getPassword(){
        return password;
    }

    public void setImage(String image){
        this.image = image;
    }

    public String getImage(){
        return image;
    }

    @Override
    public String toString(){
        return
                "RegisterRequestBody{" +
                        "goal_Type = '" + goalType + '\'' +
                        ",email = '" + email + '\'' +
                        ",hours = '" + hours + '\'' +
                        ",effort = '" + effort + '\'' +
                        ",gender = '" + gender + '\'' +
                        ",weight = '" + weight + '\'' +
                        ",name = '" + name + '\'' +
                        ",sport = '" + sport + '\'' +
                        ",username = '" + username + '\'' +
                        ",height = '" + height + '\'' +
                        ",password2 = '" + password2 + '\'' +
                        ",goal_Weight = '" + goalWeight + '\'' +
                        ",train = '" + train + '\'' +
                        ",age = '" + age + '\'' +
                        ",password = '" + password + '\'' +
                        "}";
    }
}