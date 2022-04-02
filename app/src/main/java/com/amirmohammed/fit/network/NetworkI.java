package com.amirmohammed.fit.network;

import com.amirmohammed.fit.requests.RegisterRequest;
import com.amirmohammed.fit.responses.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface NetworkI {

    @POST("people/")
    Call<RegisterResponse> register(@Body RegisterRequest registerRequest,
                                    @Query("?format=") String format);
}
