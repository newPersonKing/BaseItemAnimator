package com.example.recyclerviewanimators;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private boolean enabledGrid = false;

    @BindView(R.id.grid)
    SwitchCompat grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({
            R.id.btn_animator_sample,
            R.id.btn_adapter_sample
    })
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_animator_sample:
                Intent intent = new Intent(MainActivity.this, AnimatorSampleActivity.class);
                intent.putExtra("GRID", enabledGrid);
                startActivity(intent);
                break;
            case R.id.btn_adapter_sample:
                Intent i = new Intent(MainActivity.this, AdapterSampleActivity.class);
                i.putExtra("GRID", enabledGrid);
                startActivity(i);
                break;
        }
    }
}
