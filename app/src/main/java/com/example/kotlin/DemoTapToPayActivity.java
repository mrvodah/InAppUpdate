package com.example.kotlin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.kotlin.R;
import com.example.kotlin.utils.WalletUtils;

public class DemoTapToPayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_tap_to_pay);

        initView();
    }

    private void initView() {
        try {
            WalletUtils.getSeitcKit(this);
            Toast.makeText(this, "success!", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, "error!", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }

    }
}