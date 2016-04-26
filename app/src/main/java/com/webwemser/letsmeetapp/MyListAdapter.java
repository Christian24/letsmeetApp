package com.webwemser.letsmeetapp;

/**
 * Created by User on 26.04.2016.
 */
import java.util.ArrayList;
import java.util.HashMap;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyListAdapter extends BaseAdapter {

    private Activity activity;
    private ArrayList<HashMap<String, String>> data;
    private static LayoutInflater inflater=null;


    public MyListAdapter(Activity a, ArrayList<HashMap<String, String>> d) {
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
        View vi=convertView;
        if(convertView==null)
            vi = inflater.inflate(R.layout.list_row, null);

        TextView title = (TextView)vi.findViewById(R.id.title);
        TextView description = (TextView)vi.findViewById(R.id.description);
        TextView date = (TextView)vi.findViewById(R.id.date);

        HashMap<String, String> meet;
        meet = data.get(position);

        // Setting all values in listview
        title.setText(meet.get(MainActivity.KEY_TITLE));
        description.setText(meet.get(MainActivity.KEY_DESCRIPTION));
        date.setText(meet.get(MainActivity.KEY_DATE));
        return vi;
    }
}
