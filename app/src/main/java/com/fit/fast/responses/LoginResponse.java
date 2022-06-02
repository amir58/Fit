package com.fit.fast.responses;

import com.google.gson.annotations.SerializedName;

public class LoginResponse{

	@SerializedName("id")
	private int id;

	@SerializedName("Error")
	private String error;

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "LoginResponse{" +
				"id=" + id +
				", error=" + error +
				'}';
	}
}