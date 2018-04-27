package com.example.recyclerviewanimators;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.gy.library.BaseItemAnimator;
import com.gy.library.animation.FadeInAnimator;
import com.gy.library.animation.FadeInDownAnimator;
import com.gy.library.animation.FadeInLeftAnimator;
import com.gy.library.animation.FadeInRightAnimator;
import com.gy.library.animation.FadeInUpAnimator;
import com.gy.library.animation.FlipInBottomXAnimator;
import com.gy.library.animation.FlipInLeftYAnimator;
import com.gy.library.animation.FlipInRightYAnimator;
import com.gy.library.animation.FlipInTopXAnimator;
import com.gy.library.animation.LandingAnimator;
import com.gy.library.animation.OvershootInLeftAnimator;
import com.gy.library.animation.OvershootInRightAnimator;
import com.gy.library.animation.ScaleInAnimator;
import com.gy.library.animation.ScaleInBottomAnimator;
import com.gy.library.animation.ScaleInLeftAnimator;
import com.gy.library.animation.ScaleInRightAnimator;
import com.gy.library.animation.ScaleInTopAnimator;
import com.gy.library.animation.SlideInDownAnimator;
import com.gy.library.animation.SlideInLeftAnimator;
import com.gy.library.animation.SlideInRightAnimator;
import com.gy.library.animation.SlideInUpAnimator;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AnimatorSampleActivity extends AppCompatActivity {

    enum Type{

        FadeIn(new FadeInAnimator()),
        FadeInDown(new FadeInDownAnimator()),
        FadeInUp(new FadeInUpAnimator()),
        FadeInLeft(new FadeInLeftAnimator()),
        FadeInRight(new FadeInRightAnimator()),
        Landing(new LandingAnimator()),
        ScaleIn(new ScaleInAnimator()),
        ScaleInTop(new ScaleInTopAnimator()),
        ScaleInBottom(new ScaleInBottomAnimator()),
        ScaleInLeft(new ScaleInLeftAnimator()),
        ScaleInRight(new ScaleInRightAnimator()),
        FlipInTopX(new FlipInTopXAnimator()),
        FlipInBottomX(new FlipInBottomXAnimator()),
        FlipInLeftY(new FlipInLeftYAnimator()),
        FlipInRightY(new FlipInRightYAnimator()),
        SlideInLeft(new SlideInLeftAnimator()),
        SlideInRight(new SlideInRightAnimator()),
        SlideInDown(new SlideInDownAnimator()),
        SlideInUp(new SlideInUpAnimator()),
        OvershootInRight(new OvershootInRightAnimator(1.0f)),
        OvershootInLeft(new OvershootInLeftAnimator(1.0f));

        private BaseItemAnimator baseItemAnimator;

        Type(BaseItemAnimator baseItemAnimator){
            this.baseItemAnimator=baseItemAnimator;
        }

        public BaseItemAnimator getAnimator() {
            return baseItemAnimator;
        }
    }

    private static String[] data = new String[] {
            "Apple", "Ball", "Camera", "Day", "Egg", "Foo", "Google", "Hello", "Iron", "Japan", "Coke",
            "Dog", "Cat", "Yahoo", "Sony", "Canon", "Fujitsu", "USA", "Nexus", "LINE", "Haskell", "C++",
            "Java", "Go", "Swift", "Objective-c", "Ruby", "PHP", "Bash", "ksh", "C", "Groovy", "Kotlin"
    };

    @BindView(R.id.tool_bar)
    Toolbar toolbar;
    @BindView(R.id.list)
    RecyclerView recyclerView;
    @BindView(R.id.spinner)
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator_sample);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        if (getIntent().getBooleanExtra("GRID", true)) {
            recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        } else {
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }

        recyclerView.setItemAnimator(new ScaleInAnimator());

        final MainAdapter adapter = new MainAdapter(this, new ArrayList<>(Arrays.asList(data)));
        recyclerView.setAdapter(adapter);

        ArrayAdapter<String> spinnerAdapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        for (Type type : Type.values()) {
            spinnerAdapter.add(type.name());
        }

        spinner.setAdapter(spinnerAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                recyclerView.setItemAnimator(Type.values()[position].getAnimator());
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.getItemAnimator().setAddDuration(500);
                recyclerView.getItemAnimator().setRemoveDuration(500);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                adapter.add("newly added item", 1);
            }
        });

        findViewById(R.id.del).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                adapter.remove(1);
            }
        });

    }
}
