package com.amirmohammed.fit.requests;

import android.net.Uri;

import com.google.gson.annotations.SerializedName;

import java.io.File;

import okhttp3.MultipartBody;
import retrofit2.http.Multipart;

public class RegisterRequest {

	@SerializedName("Goal_Type")
	private String goalType;

	@SerializedName("Email")
	private String email;

	@SerializedName("Hours")
	private double hours;

	@SerializedName("Effort")
	private String effort;

	@SerializedName("Gender")
	private String gender;

	@SerializedName("Image")
	private String imageUri;

	@SerializedName("Weight")
	private double weight;

	@SerializedName("Name")
	private String name;

	@SerializedName("Sport")
	private String sport;

	@SerializedName("Username")
	private String username;

	@SerializedName("Height")
	private double height;

	@SerializedName("Goal_Weight")
	private String goalWeight;

	@SerializedName("Train")
	private double train;

	@SerializedName("Age")
	private String age;

	@SerializedName("Password")
	private String password;

	public RegisterRequest(String name, String username, String age, String email,
						   int weight, int height, int hours, String password) {
		this.name = name;
		this.username = username;
		this.age = age;
		this.email = email;
		this.weight = weight;
		this.height = height;
		this.hours = hours;
		this.password = password;
	}

	public RegisterRequest(String goalType, String email, double hours, String effort,
						   String gender, File image, double weight, String name,
						   String sport, String username, double height, String goalWeight,
						   double train, String age, String password) {

		this.goalType = goalType;
		this.email = email;
		this.hours = hours;
		this.effort = effort;
		this.gender = gender;
		this.weight = weight;
		this.name = name;
		this.sport = sport;
		this.username = username;
		this.height = height;
		this.goalWeight = goalWeight;
		this.train = train;
		this.age = age;
		this.password = password;
	}

	public RegisterRequest() {
	}

	public void setGoalType(String goalType){
		this.goalType = goalType;
	}

	public Object getGoalType(){
		return goalType;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setHours(double hours){
		this.hours = hours;
	}

	public Object getHours(){
		return hours;
	}

	public void setEffort(String effort){
		this.effort = effort;
	}

	public Object getEffort(){
		return effort;
	}

	public void setGender(String gender){
		this.gender = gender;
	}

	public Object getGender(){
		return gender;
	}

	public String getImageUri() {
		return imageUri;
	}

	public void setImageUri(String imageUri) {
		this.imageUri = imageUri;
	}

	public void setWeight(double weight){
		this.weight = weight;
	}

	public Object getWeight(){
		return weight;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setSport(String  sport){
		this.sport = sport;
	}

	public Object getSport(){
		return sport;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}

	public void setHeight(double height){
		this.height = height;
	}

	public Object getHeight(){
		return height;
	}

	public void setGoalWeight(String goalWeight){
		this.goalWeight = goalWeight;
	}

	public Object getGoalWeight(){
		return goalWeight;
	}

	public void setTrain(double train){
		this.train = train;
	}

	public Object getTrain(){
		return train;
	}

	public void setAge(String age){
		this.age = age;
	}

	public String getAge(){
		return age;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	@Override
 	public String toString(){
		return 
			"RegisterRequest{" +
			"goal_Type = '" + goalType + '\'' + 
			",email = '" + email + '\'' + 
			",hours = '" + hours + '\'' + 
			",effort = '" + effort + '\'' + 
			",gender = '" + gender + '\'' + 
			",image = '" + imageUri + '\'' +
			",weight = '" + weight + '\'' + 
			",name = '" + name + '\'' + 
			",sport = '" + sport + '\'' + 
			",username = '" + username + '\'' + 
			",height = '" + height + '\'' + 
			",goal_Weight = '" + goalWeight + '\'' + 
			",train = '" + train + '\'' + 
			",age = '" + age + '\'' + 
			",password = '" + password + '\'' + 
			"}";
		}
}