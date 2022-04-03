package com.amirmohammed.fit.requests;

import com.google.gson.annotations.SerializedName;

public class RegisterRequest {

	@SerializedName("Goal_Type")
	private Object goalType;

	@SerializedName("Email")
	private String email;

	@SerializedName("Hours")
	private Object hours;

	@SerializedName("Effort")
	private Object effort;

	@SerializedName("Gender")
	private Object gender;

	@SerializedName("Image")
	private Object image;

	@SerializedName("Weight")
	private Object weight;

	@SerializedName("Name")
	private String name;

	@SerializedName("Sport")
	private Object sport;

	@SerializedName("Username")
	private String username;

	@SerializedName("Height")
	private Object height;

	@SerializedName("Goal_Weight")
	private Object goalWeight;

	@SerializedName("Train")
	private Object train;

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

	public RegisterRequest(Object goalType, String email, Object hours, Object effort,
						   Object gender, Object image, Object weight, String name,
						   Object sport, String username, Object height, Object goalWeight,
						   Object train, String age, String password) {

		this.goalType = goalType;
		this.email = email;
		this.hours = hours;
		this.effort = effort;
		this.gender = gender;
		this.image = image;
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

	public void setGoalType(Object goalType){
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

	public void setHours(Object hours){
		this.hours = hours;
	}

	public Object getHours(){
		return hours;
	}

	public void setEffort(Object effort){
		this.effort = effort;
	}

	public Object getEffort(){
		return effort;
	}

	public void setGender(Object gender){
		this.gender = gender;
	}

	public Object getGender(){
		return gender;
	}

	public void setImage(Object image){
		this.image = image;
	}

	public Object getImage(){
		return image;
	}

	public void setWeight(Object weight){
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

	public void setSport(Object sport){
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

	public void setHeight(Object height){
		this.height = height;
	}

	public Object getHeight(){
		return height;
	}

	public void setGoalWeight(Object goalWeight){
		this.goalWeight = goalWeight;
	}

	public Object getGoalWeight(){
		return goalWeight;
	}

	public void setTrain(Object train){
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