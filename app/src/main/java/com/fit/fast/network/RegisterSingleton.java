package com.fit.fast.network;

import com.fit.fast.requests.RegisterRequestBody;

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
