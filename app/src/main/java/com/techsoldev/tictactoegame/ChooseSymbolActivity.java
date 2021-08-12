package com.techsoldev.tictactoegame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;

public class ChooseSymbolActivity extends AppCompatActivity {


    private ImageView BackBtn , CrossImg , CrossRadioImg , CircleImg , CircleRadioImg;
    private Button ContinueBtn;


     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_choose_symbol);

        BackBtn= (ImageView) findViewById(R.id.pick_side_back_btn);
        CrossImg= (ImageView) findViewById(R.id.pick_side_cross_img);
        CircleImg= (ImageView) findViewById(R.id.pick_side_circle_img);
        CrossRadioImg= (ImageView) findViewById(R.id.pick_side_cross_radio);
        CircleRadioImg= (ImageView) findViewById(R.id.pick_side_circle_radio);

        ContinueBtn = (Button) findViewById(R.id.pick_side_continue_btn);
    }



}