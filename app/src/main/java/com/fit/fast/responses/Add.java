package com.fit.fast.responses;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Add{

	@SerializedName("add")
	private List<String> add;

	@SerializedName("duration")
	private List<String> duration;

	@SerializedName("user_id")
	private List<String> userId;

	@SerializedName("target")
	private List<String> target;

	public void setAdd(List<String> add){
		this.add = add;
	}

	public List<String> getAdd(){
		return add;
	}

	public void setDuration(List<String> duration){
		this.duration = duration;
	}

	public List<String> getDuration(){
		return duration;
	}

	public void setUserId(List<String> userId){
		this.userId = userId;
	}

	public List<String> getUserId(){
		return userId;
	}

	public void setTarget(List<String> target){
		this.target = target;
	}

	public List<String> getTarget(){
		return target;
	}

	@Override
 	public String toString(){
		return 
			"Add{" + 
			"add = '" + add + '\'' + 
			",duration = '" + duration + '\'' + 
			",user_id = '" + userId + '\'' + 
			",target = '" + target + '\'' + 
			"}";
		}
}