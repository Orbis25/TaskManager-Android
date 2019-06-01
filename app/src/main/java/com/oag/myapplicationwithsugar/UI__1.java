package com.oag.myapplicationwithsugar;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.oag.myapplicationwithsugar.Model.Task;
import com.oag.myapplicationwithsugar.PersonalizateViews.UI_1_Adapter_Recycler;
import com.oag.myapplicationwithsugar.Service.TaskService;
import com.oag.myapplicationwithsugar.ViewModel.UI_1_RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class UI__1 extends AppCompatActivity {

    private ArrayList<UI_1_RecyclerView> _listData;
    private RecyclerView _rcView;
    private TaskService _repository;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui__1);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext() , UI_2.class);
                startActivity(intent);
            }
        });

        _rcView = findViewById(R.id.reciclerId);
        _rcView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL , false));
        _listData = new ArrayList<>();

        _repository = new TaskService();

        List<Task> tasks = _repository.GetAll();
        for (Task item : tasks) {
            _listData.add(new UI_1_RecyclerView(item.getTitle(), item.getDescription() , R.mipmap.ic_image_icon , item.getId()));
        }

        final UI_1_Adapter_Recycler adapter_recycler  = new UI_1_Adapter_Recycler(_listData);
        adapter_recycler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),UI_2.class);
                intent.putExtra( "id" , _listData.get(_rcView.getChildAdapterPosition(v)).getId());
                startActivity(intent);


//                Toast.makeText(getApplicationContext(),
//                        "selection" + _listData.get(_rcView.getChildAdapterPosition(v)).getId()
//                        //accedemos a la lista le decimos que iten queremos y sacamos el valor
//                        ,Toast.LENGTH_SHORT).show();
            }
        });
        _rcView.setAdapter(adapter_recycler);
    }




}
