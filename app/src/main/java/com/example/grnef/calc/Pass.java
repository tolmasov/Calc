package com.example.grnef.calc;

import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import static android.graphics.Color.*;

public class Pass extends AppCompatActivity {

    private EditText pass;
    private Button btn;
    private Button btn2;
    private RatingBar rating;
    private TextView text_show;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pass);
        addListennerOnButton();
    }

    public void addListennerOnButton () {
        pass = (EditText)findViewById(R.id.pass);
        btn = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.alert);

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


        rating = (RatingBar)findViewById(R.id.ratingBar);
        text_show = (TextView)findViewById(R.id.textView);

        rating.setOnRatingBarChangeListener(
                new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float v, boolean fronUser) {
                        text_show.setText("Значение" + String.valueOf(v));
                    }
                }
        );



        btn2.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick (View v){
                        AlertDialog.Builder a_builder = new AlertDialog.Builder(Pass.this);
                        a_builder.setMessage("Do you want to close app?")
                                .setCancelable(false)
                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int which) {
                                        finish();}
                                })
                                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int which) {
                                        dialogInterface.cancel();
                                    }
                                });
                        AlertDialog alert = a_builder.create();
                        alert.setTitle("Closing");
                        alert.show();

                    }
                }
        );
    }
}
