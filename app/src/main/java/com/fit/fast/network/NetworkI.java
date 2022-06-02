package com.fit.fast.network;

import com.fit.fast.requests.LoginRequest;
import com.fit.fast.responses.LoginResponse;
import com.fit.fast.responses.RegisterResponse;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface NetworkI {

    @Multipart
    @POST("register/")
    Call<RegisterResponse> register(@Part("Name") RequestBody name,
                                    @Part("Username") RequestBody username,
                                    @Part("Age") RequestBody age,
                                    @Part("Sport") RequestBody sport,
                                    @Part("Email") RequestBody email,
                                    @Part("Gender") RequestBody gender,
                                    @Part("Train") RequestBody train,
                                    @Part("Weight") RequestBody weight,
                                    @Part("Height") RequestBody height,
                                    @Part("Hours") RequestBody hours,
                                    @Part("Effort") RequestBody effort,
                                    @Part("Goal_Type") RequestBody goalType,
                                    @Part("Goal_Weight") RequestBody goalWeight,
                                    @Part("Password") RequestBody password,
                                    @Part("password2") RequestBody confirmPassword,
                                    @Part MultipartBody.Part body);


    @POST("login/")
    Call<LoginResponse> login(@Body LoginRequest loginRequest);
}
