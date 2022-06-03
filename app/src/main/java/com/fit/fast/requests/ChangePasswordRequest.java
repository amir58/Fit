package com.fit.fast.requests;

import com.google.gson.annotations.SerializedName;

public class ChangePasswordRequest{

	@SerializedName("old")
	private String oldPassword;

	@SerializedName("new")
	private String newPassword;

	@SerializedName("id")
	private String id;

	public ChangePasswordRequest(String oldPassword, String newPassword, String id) {
		this.oldPassword = oldPassword;
		this.newPassword = newPassword;
		this.id = id;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ChangePasswordRequest{" +
				"oldPassword='" + oldPassword + '\'' +
				", newPassword='" + newPassword + '\'' +
				", id='" + id + '\'' +
				'}';
	}
}