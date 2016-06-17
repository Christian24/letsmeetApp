package com.webwemser.letsmeetapp;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import com.webwemser.web.OnlineIntegrationServiceSoapBinding;
import com.webwemser.web.MeetResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CreateActivity extends AppCompatActivity {

    private static TextView date, time, guests;
    private static EditText title, location, description;
    private static int year, month, day, hour, min, maxGuests;
    private static String titleString, locationString, descriptionString, categoryString;
    private OnlineIntegrationServiceSoapBinding webservice;
    private Spinner categorySpinner;
    private static Date selectedDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        //Initialize Webservice components
        webservice = new OnlineIntegrationServiceSoapBinding();

        //To preset current date & time
        date = (TextView)findViewById(R.id.datepicker);
        time = (TextView)findViewById(R.id.timepicker);
        date.setText(new SimpleDateFormat("dd.MM.yyyy").format(new Date()));
        time.setText(new SimpleDateFormat("HH:mm").format(new Date()));

        //Initialize Views
        guests = (TextView)findViewById(R.id.max_guests);
        title = (EditText)findViewById(R.id.meet_title);
        description = (EditText)findViewById(R.id.meet_description);
        location = (EditText)findViewById(R.id.meet_location);
        categorySpinner = (Spinner) findViewById(R.id.category_spinner);

        //Prepares search spinner
        new CategoryAsync().execute();
    }

    //Publishes Meet...
    public void publishMeet(View v) {
        if(title.getText().toString().length()>=3 && title.getText().toString().length()<=30){
            if(location.getText().toString().length()>=3 && location.getText().toString().length()<=45){
                if(description.getText().toString().length()>=3 && description.getText().toString().length()<=128){
                    Calendar c = Calendar.getInstance();
                    c.set(Calendar.YEAR, year);
                    c.set(Calendar.MONTH, month);
                    c.set(Calendar.DAY_OF_MONTH, day);
                    c.set(Calendar.HOUR, hour);
                    c.set(Calendar.MINUTE, min);
                    selectedDate = c.getTime();
                    if(selectedDate.compareTo(new Date()) == 1){

                        titleString = title.getText().toString();
                        descriptionString = description.getText().toString();
                        locationString = location.getText().toString();
                        maxGuests = Integer.parseInt(guests.getText().toString());
                        categoryString = categorySpinner.getSelectedItem().toString();
                        new CreateMeetAsync().execute();
                        this.finish();
                    }
                    else {
                        Toast.makeText(getApplicationContext(), getString(R.string.future_meet), Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(), getString(R.string.enter_description), Toast.LENGTH_SHORT).show();
                }
            }
            else{
                Toast.makeText(getApplicationContext(), getString(R.string.enter_location), Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(getApplicationContext(), getString(R.string.enter_title), Toast.LENGTH_SHORT).show();
        }

    }

    public void changeMaxGuests(View v){
        int num = Integer.parseInt(guests.getText().toString());
        int item = v.getId();
        if(num>2){
            if(item == R.id.reduceGuests) num = num - 1;
        }
        else {
            Toast.makeText(getApplicationContext(), getString(R.string.min_guests), Toast.LENGTH_SHORT).show();
        }
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
            int day = c.get(Calendar.DAY_OF_MONTH)+1;
            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            CreateActivity.year = year;
            CreateActivity.month = month;
            CreateActivity.day = day;
            month = month + 1;
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
            time.setText(hour+":"+minute);
            // Create a new instance of TimePickerDialog and return it
            return new TimePickerDialog(getActivity(), this, hour, minute,
                    DateFormat.is24HourFormat(getActivity()));
        }

        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            CreateActivity.hour = hourOfDay;
            CreateActivity.min = minute;
            String hour = "0";
            String min = "0";
            if (hourOfDay<10)hour = hour + hourOfDay;
            else hour = hourOfDay+"";
            if (minute<10)min = min + minute;
            else min = minute+"";
            time.setText(hour+":"+min);
        }
    }

    class CreateMeetAsync extends AsyncTask<String, Integer, MeetResponse> {

        @Override
        protected MeetResponse doInBackground(String ... strings) {
            try {
                return webservice.createMeet(LoginActivity.session.getSessionData().getSessionID(), categoryString, descriptionString, titleString, locationString,selectedDate, maxGuests);
            }
            catch (Exception e){
                return new MeetResponse();
            }
        }

        protected void onPostExecute(MeetResponse response) {
            if(response!=null){
                Toast.makeText(getApplicationContext(), "OK", Toast.LENGTH_SHORT).show();
                Log.i("LOG: ", LoginActivity.session.getSessionData().getSessionID()+ " " + categoryString+ " " + descriptionString+ " " + titleString+ " " + locationString+ " " + selectedDate+ " " + maxGuests);
            }
            else {
                Toast.makeText(getApplicationContext(), "ERROR", Toast.LENGTH_SHORT).show();
            }
        }
    }

    //Fetch Categories
    class CategoryAsync extends AsyncTask<String, Integer, ArrayList<String>> {

        @Override
        protected ArrayList<String> doInBackground(String ... strings) {
            try {
                return webservice.getCategories(LoginActivity.session.getSessionData().getSessionID()).getCategories();
            }
            catch (Exception e){
                return new ArrayList<>();
            }
        }

        protected void onPostExecute(ArrayList<String> response) {
            if(response.size()==0){
                response.add(getString(R.string.load_categories));
            }
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(CreateActivity.this, android.R.layout.simple_spinner_item, response);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            categorySpinner.setAdapter(dataAdapter);
        }
    }
}
