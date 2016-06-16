package com.webwemser.letsmeetapp;

/**
 * Created by Jannik W. on 26.04.2016.
 */
import java.util.ArrayList;
import java.util.HashMap;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyParticipantsAdapter extends BaseAdapter {

    private Activity activity;
    private ArrayList<HashMap<String, String>> data;
    private static LayoutInflater inflater=null;


    public MyParticipantsAdapter(Activity a, ArrayList<HashMap<String, String>> d) {
        activity = a;
        data=d;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public int getCount() {
        return data.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        if(convertView==null)
            vi = inflater.inflate(R.layout.participant, null);

        TextView user = (TextView)vi.findViewById(R.id.username_participant);
        TextView description = (TextView)vi.findViewById(R.id.description_participant);
        HashMap<String, String> meet;
        meet = data.get(position);

        // Setting all values in listview
        user.setText(meet.get(ParticipantActivity.USERNAME));
        description.setText(meet.get(ParticipantActivity.DESCRIPTION));
        return vi;
    }
}
