package com.amirmohammed.fit.network;

import com.amirmohammed.fit.requests.RegisterRequest;

public class RegisterSingleton {

    public static RegisterRequest registerRequest;

    public static RegisterRequest setData(){
        if (registerRequest == null){
            registerRequest = new RegisterRequest();
        }
        return registerRequest;
    }
}
