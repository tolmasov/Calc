package com.example.grnef.calc;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.graphics.Color.*;

public class Pass extends AppCompatActivity {

    private EditText pass;
    private Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pass);
        addListennerOnButton();
    }

    public void addListennerOnButton () {
        pass = (EditText)findViewById(R.id.pass);
        btn = (Button)findViewById(R.id.btn1);
        btn.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick (View v){
                        btn.setText("Done");
                        btn.setBackgroundTintList(ColorStateList.valueOf(RED));
                        Toast.makeText(
                                Pass.this, pass.getText(),
                                Toast.LENGTH_SHORT
                        ).show();
                    }
                }
        );

    }
}
