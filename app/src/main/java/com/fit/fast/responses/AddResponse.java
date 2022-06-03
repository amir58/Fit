package com.fit.fast.responses;

import com.google.gson.annotations.SerializedName;

public class AddResponse{

	@SerializedName("add")
	private String add;

	@SerializedName("duration")
	private String duration;

	@SerializedName("user_id")
	private String userId;

	@SerializedName("id")
	private int id;

	@SerializedName("target")
	private String target;

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

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
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
			"AddResponse{" + 
			"add = '" + add + '\'' +
			",duration = '" + duration + '\'' + 
			",user_id = '" + userId + '\'' + 
			",id = '" + id + '\'' + 
			",target = '" + target + '\'' +
			"}";
		}
}