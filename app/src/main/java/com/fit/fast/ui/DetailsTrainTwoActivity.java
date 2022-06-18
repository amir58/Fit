package com.fit.fast.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.fit.fast.R;
import com.fit.fast.databinding.ActivityDetailsTrainTwoBinding;
import com.fit.fast.models.Workout;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class DetailsTrainTwoActivity extends AppCompatActivity {

    private ActivityDetailsTrainTwoBinding binding;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsTrainTwoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);


        Workout sport = (Workout) getIntent().getSerializableExtra("sport");

        String photo = sport.getPhoto().isEmpty() ?
                "\thttps://cdn.shopify.com/s/files/1/0044/7266/8275/articles/Squat_f6a8765f-d8b5-" +
                        "46e3-8aff-c327ec994283_1000x.jpg?v=1647352001\n" :
                sport.getPhoto();

        Picasso
                .get()
                .load(photo)
                .placeholder(R.drawable.six_packs_image)
                .into(binding.backgroundImage);
        binding.movesNumberTv.setText(sport.getReps());
        binding.setsNumberTv.setText(sport.getSets());

        binding.btnPlayVideo.setOnClickListener(view -> youtube(sport.getLink()));

        binding.btnCountOne.setOnClickListener(view -> {
            counter++;
            binding.tvCounter.setText(String.valueOf(counter));
        });
    }

    private void youtube(String link) {
        if (link == null || link.isEmpty()) {
            return;
        }

        Intent intentBrowser = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
        startActivity(intentBrowser);
    }

    public void navigateToDetailsOneActivity(View view) {
        startActivity(new Intent(this, DetailsTrainOneActivity.class));
    }

    public void oneTimeClick(View view) {
        binding.oneClickBtn.setVisibility(View.VISIBLE);
    }

    public void cancel(View view) {
        startActivity(new Intent(this, HomeTrainBottomNavigationActivity.class));
        finish();
    }

}