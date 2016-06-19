package com.webwemser.letsmeetapp;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import com.webwemser.web.MeetData;
import com.webwemser.web.MeetResponse;
import com.webwemser.web.OnlineIntegrationServiceSoapBinding;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class EditActivity extends AppCompatActivity {

    private static TextView date, guests;
    private static EditText title, location, description;
    private static int year, month, day, hour, min, maxGuests;
    private static String titleString, locationString, descriptionString, categoryString;
    private OnlineIntegrationServiceSoapBinding webservice;
    private Spinner categorySpinner;
    private static Date selectedDate;
    private ConnectionHelper connection;
    private int meetPosition = 0;
    private MeetData meet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        //Get meet position
        meetPosition = getIntent().getIntExtra(MeetActivity.POSITION, meetPosition);

        //Initialize Webservice components
        webservice = new OnlineIntegrationServiceSoapBinding();
        connection = new ConnectionHelper();

        //To preset current date & time
        date = (TextView)findViewById(R.id.datepicker);

        //Initialize Views
        guests = (TextView)findViewById(R.id.max_guests);
        title = (EditText)findViewById(R.id.meet_title);
        description = (EditText)findViewById(R.id.meet_description);
        location = (EditText)findViewById(R.id.meet_location);
        categorySpinner = (Spinner) findViewById(R.id.category_spinner);

        //Prepares search spinner
        new CategoryAsync().execute();
        new GetMeetAsync().execute();
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

    public void editMeet(View v){
        if(connection.isOnline(this)){
            if(title.getText().toString().length()>=3 && title.getText().toString().length()<=30){
                if(location.getText().toString().length()>=3 && location.getText().toString().length()<=45){
                    if(description.getText().toString().length()>=3 && description.getText().toString().length()<=128){
                        Log.i("LOG", selectedDate.toString());
                        if(selectedDate.compareTo(new Date()) == 1){
                            titleString = title.getText().toString();
                            descriptionString = description.getText().toString();
                            locationString = location.getText().toString();
                            maxGuests = Integer.parseInt(guests.getText().toString());
                            categoryString = categorySpinner.getSelectedItem().toString();
                            new EditMeetAsync().execute();
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
            EditActivity.year = year;
            EditActivity.month = month;
            EditActivity.day = day;
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

    //Starts Datepicker
    public void showDatePickerDialog(View v) {
        Date value = new Date();
        final Calendar cal = Calendar.getInstance();
        cal.setTime(value);
        new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override public void onDateSet(DatePicker view, int y, int m, int d) {
                        cal.set(Calendar.YEAR, y);
                        cal.set(Calendar.MONTH, m);
                        cal.set(Calendar.DAY_OF_MONTH, d);
                        // now show the time picker
                        new TimePickerDialog(EditActivity.this,
                                new TimePickerDialog.OnTimeSetListener() {
                                    @Override public void onTimeSet(TimePicker view, int h, int min) {
                                        cal.set(Calendar.HOUR_OF_DAY, h);
                                        cal.set(Calendar.MINUTE, min);
                                        date.setText(new SimpleDateFormat("dd.MM.yyyy / HH:mm").format(cal.getTime()));
                                        selectedDate = cal.getTime();
                                    }
                                }, cal.get(Calendar.HOUR_OF_DAY),
                                cal.get(Calendar.MINUTE), true).show();
                    }
                }, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)).show();
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
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(EditActivity.this, android.R.layout.simple_spinner_item, response);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            categorySpinner.setAdapter(dataAdapter);
        }
    }

    class GetMeetAsync extends AsyncTask<String, Integer, MeetResponse>{
        @Override
        protected MeetResponse doInBackground(String ... strings){
            try {
                return webservice.getMeet(LoginActivity.session.getSessionData().getSessionID(), meetPosition);
            }
            catch (Exception e){
                return new MeetResponse();
            }
        }
        @Override
        protected void onPostExecute(MeetResponse response) {
            if(response.getReturnCode()==200){
                title.setText(response.getMeet().getTitle());
                description.setText(response.getMeet().getDescription());
                location.setText(response.getMeet().getLocation());
                guests.setText(response.getMeet().getMaxGuests()+"");
                date.setText(new SimpleDateFormat("dd.MM.yyyy / HH:mm").format(response.getMeet().dateTime));
                selectedDate = response.getMeet().dateTime;
                meet = response.getMeet();
            }
            else {
                Toast.makeText(EditActivity.this, getString(R.string.error), Toast.LENGTH_SHORT).show();
            }
        }
    }

    class EditMeetAsync extends AsyncTask<String, Integer, MeetResponse>{
        @Override
        protected MeetResponse doInBackground(String ... strings){
            try {
                return webservice.updateMeet(LoginActivity.session.getSessionData().getSessionID(), meet.id, categoryString, descriptionString, titleString, locationString, selectedDate, maxGuests);
            }
            catch (Exception e){
                return new MeetResponse();
            }
        }
        @Override
        protected void onPostExecute(MeetResponse response) {
            if(response!=null){
                Log.i("Return code: ", response.getReturnCode()+"");
                if(response.getReturnCode()==200){
                    Intent intent = new Intent(EditActivity.this, MeetActivity.class);
                    intent.putExtra(MainActivity.KEY_POSITION,meet.getId());
                    startActivity(intent);
                }
                else {
                    Toast.makeText(EditActivity.this, getString(R.string.min_number), Toast.LENGTH_SHORT).show();
                }
            }
            else {
                Toast.makeText(EditActivity.this, getString(R.string.error), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
