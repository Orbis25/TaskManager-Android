package com.oag.myapplicationwithsugar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.oag.myapplicationwithsugar.Model.Task;
import com.oag.myapplicationwithsugar.Service.TaskService;

public class UI_3 extends AppCompatActivity {

    private long _id;
    private TaskService _service;
    private Task task;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui_3);
//        _id = getIntent().getExtras().getLong("id");
//       task = _service.GetById(_id);
    }





}
