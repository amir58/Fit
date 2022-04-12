package com.amirmohammed.fit.responses;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegisterResponse{

	@SerializedName("Name")
	@Expose
	private String name;
	@SerializedName("Username")
	@Expose
	private String username;
	@SerializedName("Age")
	@Expose
	private Integer age;
	@SerializedName("Sport")
	@Expose
	private String sport;
	@SerializedName("Email")
	@Expose
	private String email;
	@SerializedName("Gender")
	@Expose
	private String gender;
	@SerializedName("Train")
	@Expose
	private Double train;
	@SerializedName("Weight")
	@Expose
	private Double weight;
	@SerializedName("Height")
	@Expose
	private Double height;
	@SerializedName("Hours")
	@Expose
	private Double hours;
	@SerializedName("Effort")
	@Expose
	private String effort;
	@SerializedName("Goal_Type")
	@Expose
	private String goalType;
	@SerializedName("Goal_Weight")
	@Expose
	private String goalWeight;
	@SerializedName("Calculate_BMR")
	@Expose
	private Double calculateBMR;
	@SerializedName("Calculate_TDEE")
	@Expose
	private Double calculateTDEE;
	@SerializedName("Image")
	@Expose
	private Object image;

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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
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

	public Double getTrain() {
		return train;
	}

	public void setTrain(Double train) {
		this.train = train;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public Double getHours() {
		return hours;
	}

	public void setHours(Double hours) {
		this.hours = hours;
	}

	public String getEffort() {
		return effort;
	}

	public void setEffort(String effort) {
		this.effort = effort;
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

	public Double getCalculateBMR() {
		return calculateBMR;
	}

	public void setCalculateBMR(Double calculateBMR) {
		this.calculateBMR = calculateBMR;
	}

	public Double getCalculateTDEE() {
		return calculateTDEE;
	}

	public void setCalculateTDEE(Double calculateTDEE) {
		this.calculateTDEE = calculateTDEE;
	}

	public Object getImage() {
		return image;
	}

	public void setImage(Object image) {
		this.image = image;
	}

	@NonNull
	@Override
	public String toString() {
		return "RegisterResponse{" +
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
				", effort='" + effort + '\'' +
				", goalType='" + goalType + '\'' +
				", goalWeight='" + goalWeight + '\'' +
				", calculateBMR=" + calculateBMR +
				", calculateTDEE=" + calculateTDEE +
				", image=" + image +
				'}';
	}
}