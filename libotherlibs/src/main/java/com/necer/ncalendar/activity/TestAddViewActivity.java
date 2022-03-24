package com.necer.ncalendar.activity;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.haier.cellarette.baselibrary.R;
import com.necer.calendar.Miui10Calendar;
import com.necer.enumeration.CalendarState;

public class TestAddViewActivity extends AppCompatActivity {

    private Miui10Calendar miui10Calendar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_viewrili);

        miui10Calendar = findViewById(R.id.miui10Calendar);
        findViewById(R.id.iv_icon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (miui10Calendar.getCalendarState() == CalendarState.MONTH) {
                    miui10Calendar.toWeek();
                } else {
                    miui10Calendar.toMonth();
                }
            }
        });
    }
}
