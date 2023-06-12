package com.example.stormvpgit.Starter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.stormvpgit.MainShop.MainShopActivity;
import com.example.stormvpgit.R;

public class StarterActivity extends AppCompatActivity implements StarterContract.View {
    private View btnStart;
    private StarterContract.Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.starter_page);
        btnStart=findViewById(R.id.btnStart);
        presenter=new StarterPresenter();
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onStartClicked();
            }
        });

        presenter.onAttach(this);
    }

    @Override
    public void onStarted() {
        Intent intent=new Intent(this, MainShopActivity.class);
        startActivity(intent);
    }
}