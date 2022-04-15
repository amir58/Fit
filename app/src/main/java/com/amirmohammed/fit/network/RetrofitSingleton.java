package com.amirmohammed.fit.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSingleton {

    public static Retrofit retrofit;


//    Retrofit retrofit2 = new Retrofit.Builder()
//            .baseUrl("https://backend.example.com")
//            .client(client)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build();
//    return retrofit.create(ApiClient .class);

    public static NetworkI getClient() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient mClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor).build();

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://drf-apitest.herokuapp.com/")
                    .client(mClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(NetworkI.class);
    }
}
