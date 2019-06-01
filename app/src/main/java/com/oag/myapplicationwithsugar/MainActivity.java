package com.oag.myapplicationwithsugar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText _edt_UI;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _edt_UI = findViewById(R.id.edt_UI_1);
    }

    public void NexPage(View view) {
        if(!_edt_UI.getText().toString().isEmpty()){
            Intent intent = new Intent(this,UI__1.class);
            startActivity(intent);
        }else{
            Toast.makeText(this,"Enter a name please" , Toast.LENGTH_SHORT).show();
        }
    }
}
