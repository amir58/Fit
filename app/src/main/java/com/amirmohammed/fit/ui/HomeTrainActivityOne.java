package com.amirmohammed.fit.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

import com.amirmohammed.fit.R;

public class HomeTrainActivityOne extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_train_one);

//        String text2 = text + CepVizyon.getPhoneCode() + "\n\n"
//                + getText(R.string.currentversion) + CepVizyon.getLicenseText();
//
//        Spannable spannable = new SpannableString(text2);
//
//        spannable.setSpan(new ForegroundColorSpan(Color.WHITE), text.length(), (text + CepVizyon.getPhoneCode()).length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//
//        myTextView.setText(spannable, TextView.BufferType.SPANNABLE);
    }
}