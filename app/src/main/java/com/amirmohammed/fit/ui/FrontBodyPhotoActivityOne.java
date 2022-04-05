package com.amirmohammed.fit.ui;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.FileUtils;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import com.amirmohammed.fit.R;
import com.amirmohammed.fit.databinding.ActivityFrontBodyPhotoOneBinding;
import com.amirmohammed.fit.models.RealPathUtil;
import com.amirmohammed.fit.network.RegisterSingleton;

import org.jetbrains.annotations.NotNull;

import java.io.File;

import gun0912.tedimagepicker.builder.TedImagePicker;
import gun0912.tedimagepicker.builder.listener.OnSelectedListener;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;


public class FrontBodyPhotoActivityOne extends AppCompatActivity {

    ActivityFrontBodyPhotoOneBinding binding;
    String path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFrontBodyPhotoOneBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }

    public void back(View view) {

        startActivity(new Intent(this, BodyPhotoActivityOne.class));
        finish();
    }

    public void next(View view) {
        startActivity(new Intent(this, BackBodyPhotoActivityOne.class));
    }

    public void getImageFromGallery(View view) {

//        ActivityResultLauncher<Intent> launcher =
//                registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), (ActivityResult result) -> {
//                    if (result.getResultCode() == RESULT_OK) {
//                        Uri uri = result.getData().getData();
//                        // Use the uri to load the image
//                    } else if (result.getResultCode() == ImagePicker.RESULT_ERROR) {
//                        // Use ImagePicker.Companion.getError(result.getData()) to show an error
//                    }
//                });
//
//        ImagePicker.Companion.with(this)
//                .crop()	    			//Crop image(Optional), Check Customization for more option
//                .cropOval()	    		//Allow dimmed layer to have a circle inside
//                .cropFreeStyle()	    //Let the user to resize crop bounds
//                .galleryOnly()          //We have to define what image provider we want to use
//                .maxResultSize(1080, 1080, true)	//Final image resolution will be less than 1080 x 1080(Optional)
//                .createIntent();

        TedImagePicker.with(this)
                .start(new OnSelectedListener() {
                    @Override
                    public void onSelected(@NotNull Uri uri) {

                        Log.i("abdo", "onSelected: "+ uri);

                        path = RealPathUtil.getRealPath(FrontBodyPhotoActivityOne.this, uri);

                        RegisterSingleton.setData().setImageUri(path);
                    }
                });
        TedImagePicker.with(this)
                .start(uri -> {
                    Log.i("abdo", "onSelected: "+ uri);
                });
    }
}