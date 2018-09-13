package com.example.raju.mytimepickedemo;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView view_text, result_view;
    private Button show_button, select_button;

    private TimePickerDialog timePickerDialog;
    private DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view_text=findViewById(R.id.text_view_id);
        show_button=findViewById(R.id.show_button_id);
        result_view=findViewById(R.id.result_view_id);
        select_button=findViewById(R.id.selectDate_button_id);

        show_button.setOnClickListener(this);
        select_button.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.show_button_id) {

            TimePicker timePicker= new TimePicker(this);
            int currentHour= timePicker.getCurrentHour();
            int currentMinute = timePicker.getCurrentMinute();

            timePickerDialog = new TimePickerDialog(MainActivity.this,

                    new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                            view_text.setText(hourOfDay+":"+minute);

                        }
                    }, currentHour, currentMinute,true);

            timePickerDialog.show();


        }

        if(v.getId()==R.id.selectDate_button_id)
        {
            DatePicker datePicker= new DatePicker(this);
            int currentDay = datePicker.getDayOfMonth();
            int currentMonth = datePicker.getMonth();
            int currentYear = datePicker.getYear();

            datePickerDialog = new DatePickerDialog(MainActivity.this,

                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                            result_view.setText(dayOfMonth+"/"+(month+1)+"/"+year);
                        }
                    }, currentYear, currentMonth, currentDay);

            datePickerDialog.show();
        }


    }
}
