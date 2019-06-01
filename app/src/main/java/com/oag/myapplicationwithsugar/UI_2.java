package com.oag.myapplicationwithsugar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.oag.myapplicationwithsugar.Model.Task;
import com.oag.myapplicationwithsugar.Service.TaskService;

public class UI_2 extends AppCompatActivity {

    private EditText _dtTitle;
    private EditText _edtDescription;
    private TaskService _service;
    private Button _btnAdd;
    private Button _btnUpdate;
    private Button _btnDelete;
    private long _id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui_2);
        _dtTitle = findViewById(R.id.edtTitle_UI_2);
        _edtDescription = findViewById(R.id.edtDescription_UI_2);
        _service = new TaskService();
        _btnAdd = findViewById(R.id.UI_2_Btn);
        _btnUpdate = findViewById(R.id.UI_2_btnUpdate);
        _btnDelete = findViewById(R.id.UI_2_btnDelete);

        try {
            _id =  getIntent().getExtras().getLong("id");
        }catch (Exception e){
        }
        if(_id != 0){
            _btnAdd.setVisibility(View.INVISIBLE);
            _btnUpdate.setVisibility(View.VISIBLE);
            _btnDelete.setVisibility(View.VISIBLE);
            GetTask();
        }else{
            _btnUpdate.setVisibility(View.INVISIBLE);
            _btnDelete.setVisibility(View.INVISIBLE);
        }
    }

    public void SaveTask(View view) {
        if(_service.saveTask(_dtTitle.getText().toString(), _edtDescription.getText().toString())){
            Toast.makeText(this,"Task Saved" , Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,UI__1.class);
            startActivity(intent);
        }else{
            Toast.makeText(this,"Error to save Task" , Toast.LENGTH_SHORT).show();
        }
    }


    public void UpdateTask(View view) {
        if(_service.Update(new Task(_dtTitle.getText().toString(), _edtDescription.getText().toString()),_id)){
            Toast.makeText(this,"Task Update" , Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,UI__1.class);
            startActivity(intent);
        }else{
            Toast.makeText(this,"Error to update Task" , Toast.LENGTH_SHORT).show();
        }
    }

    private void GetTask(){
        Task task = _service.GetById(_id);
        _dtTitle.setText(task.getTitle());
        _edtDescription.setText(task.getDescription());
    }

    public void Remove(View view) {
        if(_service.Delete(_id)){
            Toast.makeText(this,"Task Deleted" , Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,UI__1.class);
            startActivity(intent);
        }else{
            Toast.makeText(this,"Error to Delete Task" , Toast.LENGTH_SHORT).show();
        }
    }
}
