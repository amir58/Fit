package com.fit.fast.requests;

import com.google.gson.annotations.SerializedName;

public class ChangePasswordRequest{

	@SerializedName("old_password")
	private String oldPassword;

	@SerializedName("new_password")
	private String newPassword;

	public ChangePasswordRequest(String oldPassword, String newPassword) {
		this.oldPassword = oldPassword;
		this.newPassword = newPassword;
	}

	public void setOldPassword(String oldPassword){
		this.oldPassword = oldPassword;
	}

	public String getOldPassword(){
		return oldPassword;
	}

	public void setNewPassword(String newPassword){
		this.newPassword = newPassword;
	}

	public String getNewPassword(){
		return newPassword;
	}

	@Override
 	public String toString(){
		return 
			"ChangePasswordRequest{" + 
			"old_password = '" + oldPassword + '\'' + 
			",new_password = '" + newPassword + '\'' + 
			"}";
		}
}