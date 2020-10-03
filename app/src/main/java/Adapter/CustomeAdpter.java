package Adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.chintu.Gops.R;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

import static android.content.Context.MODE_PRIVATE;

public class CustomeAdpter extends BaseAdapter {
    Context context;


    public CustomeAdpter(Context context) {
        this.context = context;

    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = layoutInflater.inflate(R.layout.custom, null);
        TextView tv1 = v.findViewById(R.id.Source1);
        TextView tv2 = v.findViewById(R.id.Date);
        TextView tv4 = v.findViewById(R.id.Destination1);
        TextView tv5 = v.findViewById(R.id.time);
        TextView tv7 = v.findViewById(R.id.fees1);
        SharedPreferences preferences = context.getSharedPreferences("mypre",Context.MODE_PRIVATE);
        String time=preferences.getString("stime",null);
        tv5.setText(time);
        tv7.setText("100/-");
        return v;
    }
}

