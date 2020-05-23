package com.yokissa.tasktracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.yokissa.tasktracker.Adapter.TimelineAdapter;
import com.yokissa.tasktracker.Data.TimelineItem;
import com.yokissa.tasktracker.Resources.Tasks;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView timeline;
    private TimelineAdapter adapter;
    private List<TimelineItem> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        init();
        getListData();
        setupAdapter();
    }

    private void setupAdapter() {

        adapter = new TimelineAdapter(this, mData);
        timeline.setAdapter(adapter);
    }

    private void getListData() {

        mData = Tasks.getTimelineData();
    }

    private void init() {
        timeline = findViewById(R.id.timeline);
        timeline.setLayoutManager(new LinearLayoutManager(this));
    }
}
