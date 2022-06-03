package com.fit.fast.requests;

import com.google.gson.annotations.SerializedName;

public class AddRequest{

	@SerializedName("add")
	private String add;

	@SerializedName("duration")
	private String duration;

	@SerializedName("user_id")
	private String userId;

	@SerializedName("target")
	private String target;

	public AddRequest(String add, String duration, String userId, String target) {
		this.add = add;
		this.duration = duration;
		this.userId = userId;
		this.target = target;
	}

	public void setAdd(String add){
		this.add = add;
	}

	public String getAdd(){
		return add;
	}

	public void setDuration(String duration){
		this.duration = duration;
	}

	public String getDuration(){
		return duration;
	}

	public void setUserId(String userId){
		this.userId = userId;
	}

	public String getUserId(){
		return userId;
	}

	public void setTarget(String target){
		this.target = target;
	}

	public String getTarget(){
		return target;
	}

	@Override
 	public String toString(){
		return 
			"AddRequest{" + 
			"add = '" + add + '\'' + 
			",duration = '" + duration + '\'' + 
			",user_id = '" + userId + '\'' + 
			",target = '" + target + '\'' + 
			"}";
		}
}