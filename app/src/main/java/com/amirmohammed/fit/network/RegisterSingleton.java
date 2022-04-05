package com.amirmohammed.fit.network;

import com.amirmohammed.fit.requests.RegisterRequestBody;

public class RegisterSingleton {

//    public static RegisterRequest registerRequest;

    public static RegisterRequestBody registerRequestBody;

    public static RegisterRequestBody setData(){
        if (registerRequestBody == null){
            registerRequestBody = new RegisterRequestBody();
        }
        return registerRequestBody;
    }
}
