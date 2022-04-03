package com.amirmohammed.fit.requests;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class RegisterRequestErrorBody{

	@SerializedName("Email")
	private List<String> email;

	@SerializedName("Username")
	private List<String> username;

	@SerializedName("Hours")
	private List<String> hours;

	@SerializedName("Height")
	private List<String> height;

	@SerializedName("Age")
	private List<String> age;

	@SerializedName("Weight")
	private List<String> weight;

	@SerializedName("Name")
	private List<String> name;

	@SerializedName("Password")
	private List<String> password;

	public void setEmail(List<String> email){
		this.email = email;
	}

	public List<String> getEmail(){
		return email;
	}

	public void setUsername(List<String> username){
		this.username = username;
	}

	public List<String> getUsername(){
		return username;
	}

	public void setHours(List<String> hours){
		this.hours = hours;
	}

	public List<String> getHours(){
		return hours;
	}

	public void setHeight(List<String> height){
		this.height = height;
	}

	public List<String> getHeight(){
		return height;
	}

	public void setAge(List<String> age){
		this.age = age;
	}

	public List<String> getAge(){
		return age;
	}

	public void setWeight(List<String> weight){
		this.weight = weight;
	}

	public List<String> getWeight(){
		return weight;
	}

	public void setName(List<String> name){
		this.name = name;
	}

	public List<String> getName(){
		return name;
	}

	public void setPassword(List<String> password){
		this.password = password;
	}

	public List<String> getPassword(){
		return password;
	}

	@Override
 	public String toString(){
		return 
			"RegisterRequestErrorBody{" + 
			"email = '" + email + '\'' + 
			",username = '" + username + '\'' + 
			",hours = '" + hours + '\'' + 
			",height = '" + height + '\'' + 
			",age = '" + age + '\'' + 
			",weight = '" + weight + '\'' + 
			",name = '" + name + '\'' + 
			",password = '" + password + '\'' + 
			"}";
		}
}