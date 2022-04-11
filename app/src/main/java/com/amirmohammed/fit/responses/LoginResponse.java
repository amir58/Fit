package com.amirmohammed.fit.responses;

import com.google.gson.annotations.SerializedName;

public class LoginResponse{

	@SerializedName("access")
	private String access;

	@SerializedName("refresh")
	private String refresh;

	@SerializedName("detail")
	private String errorMessage;

	public void setAccess(String access){
		this.access = access;
	}

	public String getAccess(){
		return access;
	}

	public void setRefresh(String refresh){
		this.refresh = refresh;
	}

	public String getRefresh(){
		return refresh;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "LoginResponse{" +
				"access='" + access + '\'' +
				", refresh='" + refresh + '\'' +
				", errorMessage='" + errorMessage + '\'' +
				'}';
	}
}