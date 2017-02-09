package edu.dtcc.hpeffley.datetimepicker;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn_time,btn_date;
    EditText et_time,et_date;
    private int day,month,year,hour,minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_date = (Button) findViewById(R.id.btn_date);
        btn_time = (Button) findViewById(R.id.btn_time);
        et_date = (EditText) findViewById(R.id.et_date);
        et_time = (EditText) findViewById(R.id.et_time);
        btn_date.setOnClickListener(this);
        btn_time.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==btn_date){
            final Calendar c = Calendar.getInstance();
            day=c.get(Calendar.DAY_OF_MONTH);
            month=c.get(Calendar.MONTH);
            year=c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    et_date.setText(dayOfMonth+"/"+(month+1)+"/"+year);
                }
            }
                    ,day,month,year);
            datePickerDialog.show();

        }
        if(v==btn_time){

            final Calendar c = Calendar.getInstance();
            minute=c.get(Calendar.MINUTE);
            hour=c.get(Calendar.HOUR);
            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    String AM_PM ;
                    if(hourOfDay < 12) {
                        AM_PM = "AM";
                    } else {
                        hourOfDay = hourOfDay - 12;
                        AM_PM = "PM";
                    }
                    et_time.setText(hourOfDay+":"+minute+" "+ AM_PM);
                }
            },hour, minute, false);
            timePickerDialog.show();
        }

    }
}
