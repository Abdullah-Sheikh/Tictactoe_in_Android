package com.techsoldev.tictactoegame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;


public class SettingsActivity extends AppCompatActivity {

    Switch vibrationSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


         vibrationSwitch = (Switch)  findViewById(R.id.vibration_switch);

         if(MyServices.VIBRATION_CHECK)
         {
             vibrationSwitch.setChecked(true);
         }
         else if(!MyServices.VIBRATION_CHECK)
         {
             vibrationSwitch.setChecked(false);
         }


         vibrationSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               if(isChecked)
               {
                   MyServices.VIBRATION_CHECK =true;
               }
               else {
                   MyServices.VIBRATION_CHECK= false;
               }
            }

        });

    }
}