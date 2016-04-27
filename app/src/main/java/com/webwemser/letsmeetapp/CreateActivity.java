package com.webwemser.letsmeetapp;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CreateActivity extends AppCompatActivity {

    private static TextView date, time, guests;
    private static EditText title, location, description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        //To preset current date & time
        date = (TextView)findViewById(R.id.datepicker);
        time = (TextView)findViewById(R.id.timepicker);
        SimpleDateFormat curDate = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat curTime = new SimpleDateFormat("HH:mm");
        date.setText(curDate.format(new Date()));
        time.setText(curTime.format(new Date()));

        //Initialize Textfields and Edittexts
        guests = (TextView)findViewById(R.id.max_guests);
        title = (EditText)findViewById(R.id.meet_title);
        description = (EditText)findViewById(R.id.meet_description);
        location = (EditText)findViewById(R.id.meet_location);
    }

    //Publishes Meet...
    public void publishMeet(View v) {
        Meet meet = new Meet();
        meet.setAuthor("Just Created");
        meet.setDatetime(date.getText().toString() + " - " +time.getText().toString());
        meet.setTitle(title.getText().toString());
        meet.setDescription(description.getText().toString());
        meet.setLocation(location.getText().toString());
        meet.setMaxGuests(Integer.parseInt(guests.getText().toString()));
        MainActivity.addMeetfromCreate(meet);
        this.finish();
    }

    public void changeMaxGuests(View v){
        int num = Integer.parseInt(guests.getText().toString());
        int item = v.getId();
        if(item == R.id.reduceGuests) num = num - 1;
        if(item == R.id.addGuests) num = num + 1;
        guests.setText(num+"");
    }

    //Starts Datepicker
    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getFragmentManager(), "datePicker");
    }

    //Starts Timepicker
    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getFragmentManager(), "timePicker");
    }

    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            String m = "0";
            String d = "0";
            if (month<10)m = m + month;
            else m = month+"";
            if (day<10)d = d + day;
            else d = day+"";
            date.setText(d+"."+m+"."+year);
        }
    }

    public static class TimePickerFragment extends DialogFragment
            implements TimePickerDialog.OnTimeSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current time as the default values for the picker
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            // Create a new instance of TimePickerDialog and return it
            return new TimePickerDialog(getActivity(), this, hour, minute,
                    DateFormat.is24HourFormat(getActivity()));
        }

        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            String hour = "0";
            String min = "0";
            if (hourOfDay<10)hour = hour + hourOfDay;
            else hour = hourOfDay+"";
            if (minute<10)min = min + minute;
            else min = minute+"";
            time.setText(hour+":"+min);
        }
    }
}
