package com.techsoldev.tictactoegame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class OfflineGetPlayersNamesActivity extends AppCompatActivity implements View.OnTouchListener {


    private String playerOne, playerTwo;

    private EditText playerOneName, playerTwoName;
    private Button playerOneButton, playerTwoButton;
    private ImageView BackBtn;
    private LinearLayout playerOneLayout, playerTwoLayout;

    boolean islayout = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen

        setContentView(R.layout.activity_offline_get_players_names);


        BackBtn = (ImageView) findViewById(R.id.player_names_back_btn);
        playerOneName = (EditText) findViewById(R.id.player_one_name_edttxt);
        playerTwoName = (EditText) findViewById(R.id.player_two_name_edttxt);
        playerOneButton = (Button) findViewById(R.id.player_one_btn);
        playerTwoButton = (Button) findViewById(R.id.player_two_btn);
        playerOneLayout = (LinearLayout) findViewById(R.id.player_one_layout);
        playerTwoLayout = (LinearLayout) findViewById(R.id.player_two_layout);


        playerOneButton.setOnTouchListener(this);
        playerOneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(playerOneName.getText().toString())) {
                    Toast.makeText(getBaseContext(), "Enter Name", Toast.LENGTH_LONG).show();
                } else {
                    islayout = false;
                    playerOneLayout.setVisibility(View.GONE);
                    playerTwoLayout.setVisibility(View.VISIBLE);
                    slideUp(playerTwoLayout);
                    playerOne = playerOneName.getText().toString();
                }
            }
        });

       BackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onBackPressed();
            }
        });


        playerTwoButton.setOnTouchListener(this);
        playerTwoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(playerTwoName.getText().toString())) {
                    Toast.makeText(getBaseContext(), "Enter Name", Toast.LENGTH_LONG).show();
                } else {

                    playerTwo = playerTwoName.getText().toString();
                    Intent intent = new Intent(OfflineGetPlayersNamesActivity.this,ChooseSymbolActivity.class);
                    intent.putExtra("p1",playerOne);
                    intent.putExtra("p2",playerTwo);


                    startActivity(intent);
                }
            }
        });

    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {

        if(islayout)
        {
            if (v == playerOneButton) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    v.setAlpha(0.5f);
                }   else {
                    v.setAlpha(1f);
                }
            }
        }
        else if(!islayout)
        {
            if (v == playerTwoButton) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    v.setAlpha(0.5f);
                }   else {
                    v.setAlpha(1f);
                }
            }
        }

        return false;
    }


    // slide the view from below itself to the current position
    public void slideUp(View view) {
        view.setVisibility(View.VISIBLE);
        TranslateAnimation animate = new TranslateAnimation(
                0,                 // fromXDelta
                0,                 // toXDelta
                view.getHeight(),  // fromYDelta
                0);                // toYDelta
        animate.setDuration(500);
        animate.setFillAfter(true);
        view.startAnimation(animate);
    }

    // slide the view from its current position to below itself
    public void slideDown(View view) {
        TranslateAnimation animate = new TranslateAnimation(
                0,                 // fromXDelta
                0,                 // toXDelta
                0,                 // fromYDelta
                view.getHeight()); // toYDelta
        animate.setDuration(500);
        animate.setFillAfter(true);
        view.startAnimation(animate);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}

