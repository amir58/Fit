package com.fit.fast.responses;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ChangePasswordResponse{

	@SerializedName("code")
	private int code;

	@SerializedName("data")
	private List<Object> data;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private String status;

	@SerializedName("detail")
	private String details;

	public void setCode(int code){
		this.code = code;
	}

	public int getCode(){
		return code;
	}

	public void setData(List<Object> data){
		this.data = data;
	}

	public List<Object> getData(){
		return data;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "ChangePasswordResponse{" +
				"code=" + code +
				", data=" + data +
				", message='" + message + '\'' +
				", status='" + status + '\'' +
				", details='" + details + '\'' +
				'}';
	}
}