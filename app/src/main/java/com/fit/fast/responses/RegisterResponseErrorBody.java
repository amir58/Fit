package com.fit.fast.responses;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class RegisterResponseErrorBody {

	@SerializedName("detail")
	private String detail;

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@SerializedName("Goal_Type")
	private List<String> goalType;

	@SerializedName("Sport")
	private List<String> sport;

	@SerializedName("Email")
	private List<String> email;

	@SerializedName("Username")
	private List<String> username;

	@SerializedName("Effort")
	private List<String> effort;

	@SerializedName("password2")
	private List<String> password2;

	@SerializedName("Gender")
	private List<String> gender;

	@SerializedName("Goal_Weight")
	private List<String> goalWeight;

	@SerializedName("Name")
	private List<String> name;

	@SerializedName("Password")
	private List<String> password;

	public void setGoalType(List<String> goalType){
		this.goalType = goalType;
	}

	public List<String> getGoalType(){
		return goalType;
	}

	public void setSport(List<String> sport){
		this.sport = sport;
	}

	public List<String> getSport(){
		return sport;
	}

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

	public void setEffort(List<String> effort){
		this.effort = effort;
	}

	public List<String> getEffort(){
		return effort;
	}

	public void setPassword2(List<String> password2){
		this.password2 = password2;
	}

	public List<String> getPassword2(){
		return password2;
	}

	public void setGender(List<String> gender){
		this.gender = gender;
	}

	public List<String> getGender(){
		return gender;
	}

	public void setGoalWeight(List<String> goalWeight){
		this.goalWeight = goalWeight;
	}

	public List<String> getGoalWeight(){
		return goalWeight;
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
				"RegisterResponseErrorBody{" +
						"goal_Type = '" + goalType + '\'' +
						",sport = '" + sport + '\'' +
						",email = '" + email + '\'' +
						",username = '" + username + '\'' +
						",effort = '" + effort + '\'' +
						",password2 = '" + password2 + '\'' +
						",gender = '" + gender + '\'' +
						",goal_Weight = '" + goalWeight + '\'' +
						",name = '" + name + '\'' +
						",password = '" + password + '\'' +
						"}";
	}
}