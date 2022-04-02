package com.amirmohammed.fit.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegisterResponse{

	@SerializedName("Goal_Type")
	@Expose
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
	private Object image;

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

	public void setGoalType(String goalType){
		this.goalType = goalType;
	}

	public String getGoalType(){
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

	public double getHours(){
		return hours;
	}

	public void setEffort(String effort){
		this.effort = effort;
	}

	public String getEffort(){
		return effort;
	}

	public void setGender(String gender){
		this.gender = gender;
	}

	public String getGender(){
		return gender;
	}

	public void setImage(Object image){
		this.image = image;
	}

	public Object getImage(){
		return image;
	}

	public void setWeight(double weight){
		this.weight = weight;
	}

	public double getWeight(){
		return weight;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setSport(String sport){
		this.sport = sport;
	}

	public String getSport(){
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

	public double getHeight(){
		return height;
	}

	public void setGoalWeight(String goalWeight){
		this.goalWeight = goalWeight;
	}

	public String getGoalWeight(){
		return goalWeight;
	}

	public void setTrain(double train){
		this.train = train;
	}

	public double getTrain(){
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
			"RegisterResponse{" + 
			"goal_Type = '" + goalType + '\'' + 
			",email = '" + email + '\'' + 
			",hours = '" + hours + '\'' + 
			",effort = '" + effort + '\'' + 
			",gender = '" + gender + '\'' + 
			",image = '" + image + '\'' + 
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