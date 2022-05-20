package com.fit.fast.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.fit.fast.databinding.ActivityInbodyBinding;
import com.fit.fast.models.RealPathUtil;
import com.fit.fast.network.RegisterSingleton;
import com.fit.fast.network.RetrofitSingleton;
import com.fit.fast.responses.RegisterResponse;
import com.fit.fast.responses.RegisterResponseErrorBody;
import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;

import gun0912.tedimagepicker.builder.TedImagePicker;
import gun0912.tedimagepicker.builder.listener.OnSelectedListener;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InBodyActivity extends AppCompatActivity {

    ActivityInbodyBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding  = ActivityInbodyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);


    }

    public void back(View view) {
        startActivity(new Intent(this, PhotoOrInBodyActivity.class));
        finish();
    }

    public void finish(View view) {

        //pass it like this
        File file = new File(RegisterSingleton.registerRequestBody.getImage());

        RequestBody requestFile =
                RequestBody.create(MediaType.parse("multipart/form-data"), file);

        // MultipartBody.Part is used to send also the actual file name
        MultipartBody.Part body =
                MultipartBody.Part.createFormData("Image", file.getName(), requestFile);

        // add another part within the multipart request

        RetrofitSingleton.getClient().register(
                RegisterSingleton.registerRequestBody.getName(),
                RegisterSingleton.registerRequestBody.getUsername(),
                RegisterSingleton.registerRequestBody.getAge(),
                RegisterSingleton.registerRequestBody.getSport(),
                RegisterSingleton.registerRequestBody.getEmail(),
                RegisterSingleton.registerRequestBody.getGender(),
                RegisterSingleton.registerRequestBody.getTrain(),
                RegisterSingleton.registerRequestBody.getWeight(),
                RegisterSingleton.registerRequestBody.getHeight(),
                RegisterSingleton.registerRequestBody.getHours(),
                RegisterSingleton.registerRequestBody.getEffort(),
                RegisterSingleton.registerRequestBody.getGoalType(),
                RegisterSingleton.registerRequestBody.getGoalWeight(),
                RegisterSingleton.registerRequestBody.getPassword(),
                RegisterSingleton.registerRequestBody.getPassword2(),
                body)
                .enqueue(new Callback<RegisterResponse>() {
                    @Override
                    public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {

                        if (response.isSuccessful()) {
                            startActivity(new Intent(InBodyActivity.this, PhotoOrInBodyLoadingActivity.class));
                            finish();
                        } else {


//                            Gson gson = new Gson();
//                            RegisterResponseErrorBody requestErrorBody = new RegisterResponseErrorBody();
//                            try {
//                                requestErrorBody = gson.fromJson(response.errorBody().string(), RegisterResponseErrorBody.class);
//                            } catch (IOException e) {
//                                e.printStackTrace();
//                            }
//                            Toast.makeText(InBodyActivity.this, requestErrorBody.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<RegisterResponse> call, Throwable t) {
                        Toast.makeText(InBodyActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

    }

    public void getImageFromGallery(View view) {
        TedImagePicker.with(this)
                .start(new OnSelectedListener() {
                    @Override
                    public void onSelected(@NotNull Uri uri) {

                        Log.i("abdo", "onSelected: "+ uri);

                        String path = RealPathUtil.getRealPath(InBodyActivity.this, uri);

                        binding.activityInbodyResultSheetImage.setImageURI(uri);

                        RegisterSingleton.setData().setImage(path);
                    }
                });
    }
}