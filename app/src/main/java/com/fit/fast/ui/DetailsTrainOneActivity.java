package com.fit.fast.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.fit.fast.R;
import com.fit.fast.databinding.ActivityDetailsTrainOneBinding;
import com.fit.fast.models.Workout;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class DetailsTrainOneActivity extends AppCompatActivity {

    private ActivityDetailsTrainOneBinding binding;
    private Workout sport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsTrainOneBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        sport = (Workout) getIntent().getSerializableExtra("sport");

        String photo = sport.getPhoto().isEmpty() ?
                "https://cdn.shopify.com/s/files/1/0044/7266/8275/articles/Squat_f6a8765f-d8b5-" +
                        "46e3-8aff-c327ec994283_1000x.jpg?v=1647352001" :
                sport.getPhoto();

        Picasso
                .get()
                .load(sport.getPhoto())
                .placeholder(R.drawable.six_packs_image)
                .into(binding.backgroundImage);
        binding.movesNumberTv.setText(sport.getReps());
        binding.setsNumberTv.setText(sport.getSets());
    }

    public void next(View view) {
        Intent intent = new Intent(this, DetailsTrainTwoActivity.class);
        intent.putExtra("sport2", sport);
        startActivity(intent);
    }

    public void oneTimeClick(View view) {
        binding.oneClickImage.setVisibility(View.INVISIBLE);
        binding.oneClickBtn.setVisibility(View.VISIBLE);
    }
}