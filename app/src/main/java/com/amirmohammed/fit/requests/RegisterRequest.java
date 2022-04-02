package com.amirmohammed.fit.requests;

import com.google.gson.annotations.SerializedName;

public class RegisterRequest {

    @SerializedName("Name")
    private String name;

    @SerializedName("Username")
    private String username;

    @SerializedName("Age")
    private int age;

    @SerializedName("Sport")
    private String sport;

    @SerializedName("Email")
    private String email;

    @SerializedName("Gender")
    private String gender;

    @SerializedName("Train")
    private int train;

    @SerializedName("Weight")
    private int weight;

    @SerializedName("Height")
    private int height;

    @SerializedName("Hours")
    private int hours;

    @SerializedName("Effort")
    private String efforts;

    @SerializedName("Goal_Type")
    private String goalType;

    @SerializedName("Goal_Weight")
    private String goalWeight;

    @SerializedName("Password")
    private String password;

    @SerializedName("Image")
    private String image;

    public RegisterRequest(String name, String username, int age, String sport, String email,
                           String gender, int train, int weight, int height, int hours,
                           String efforts, String goalType, String goalWeight, String password, String image) {
        this.name = name;
        this.username = username;
        this.age = age;
        this.sport = sport;
        this.email = email;
        this.gender = gender;
        this.train = train;
        this.weight = weight;
        this.height = height;
        this.hours = hours;
        this.efforts = efforts;
        this.goalType = goalType;
        this.goalWeight = goalWeight;
        this.password = password;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getTrain() {
        return train;
    }

    public void setTrain(int train) {
        this.train = train;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public String getEfforts() {
        return efforts;
    }

    public void setEfforts(String efforts) {
        this.efforts = efforts;
    }

    public String getGoalType() {
        return goalType;
    }

    public void setGoalType(String goalType) {
        this.goalType = goalType;
    }

    public String getGoalWeight() {
        return goalWeight;
    }

    public void setGoalWeight(String goalWeight) {
        this.goalWeight = goalWeight;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "RegisterRequest{" +
                "name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", age=" + age +
                ", sport='" + sport + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", train=" + train +
                ", weight=" + weight +
                ", height=" + height +
                ", hours=" + hours +
                ", efforts='" + efforts + '\'' +
                ", goalType='" + goalType + '\'' +
                ", goalWeight='" + goalWeight + '\'' +
                ", password='" + password + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
