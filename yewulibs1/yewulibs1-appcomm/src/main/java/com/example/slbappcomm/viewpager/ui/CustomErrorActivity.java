package com.example.slbappcomm.viewpager.ui;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.slbappcomm.R;


public class CustomErrorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_custom_errorcoolvg);
//        getSupportActionBar().hide();

        //**IMPORTANT**
        //The custom error activity in this sample is uglier than the default one and just
        //for demonstration purposes, please don't copy it to your project!
        //We recommend taking the original library's DefaultErrorActivity as a basis.
        //Of course, you are free to implement it as you wish in your application.

        //These four methods are available for you to use:
        //CustomActivityOnCrash.getStackTraceFromIntent(getIntent()): gets the stack trace as a string
        //CustomActivityOnCrash.getActivityLogFromIntent(getIntent()): gets the activity log as a string
        //CustomActivityOnCrash.getAllErrorDetailsFromIntent(context, getIntent()): returns all error details including stacktrace as a string
        //CustomActivityOnCrash.getConfigFromIntent(getIntent()): returns the config of the library when the error happened

        //Now, treat here the error as you wish. If you allow the user to restart or close the app,
        //don't forget to call the appropriate methods.
        //Otherwise, if you don't finish the activity, you will get the CustomErrorActivity on the activity stack and it will be visible again under some circumstances.
        //Also, you will get multiprocess problems in API<17.

        TextView errorDetailsText = findViewById(R.id.error_details);
//        errorDetailsText.setText(CustomActivityOnCrash.getStackTraceFromIntent(getIntent()));

        Button restartButton = findViewById(R.id.restart_button);

//        final CaocConfig config = CustomActivityOnCrash.getConfigFromIntent(getIntent());
//
//        if (config == null) {
//            //This should never happen - Just finish the activity to avoid a recursive crash.
//            finish();
//            return;
//        }
//
//        if (config.isShowRestartButton() && config.getRestartActivityClass() != null) {
//            restartButton.setText(R.string.restart_app);
//            restartButton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    CustomActivityOnCrash.restartApplication(CustomErrorActivity.this, config);
//                }
//            });
//        } else {
//            restartButton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    CustomActivityOnCrash.closeApplication(CustomErrorActivity.this, config);
//                }
//            });
//        }
    }
}

