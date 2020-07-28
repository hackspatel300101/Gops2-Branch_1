package Fragment;


import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.chintu.Gops.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import hari.bounceview.BounceView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Summary extends android.app.Fragment {
    private static final String TAG = "Payment Error";
    ImageView iv;
    Button btn, btn2;
    TextView nm1, source, destination, i_n1, bus, pass, d_1, a1, b1, tv, gender;
    LinearLayout ly1, ly2, ly3, ly4, ly5, ly6, ly7, ly8;
    int fare = 100;

    String s0;
    String d0;
    String n0;
    String i_n0;
    String b_type;
    String p_type;
    String duration;
    String a;
    String b_Date;
    String g_ender;
    String idproof;
    String address;
    String city;
    String pincode;
    String area;
    String mobile;
    ArrayList<String> imageList = new ArrayList<>();
    String date = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
    SharedPreferences preferences;
    String otp;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_summary, container, false);
        //final View checkBoxView = View.inflate(getActivity(), R.layout.layout, null);
        final Dialog dialog1 = new Dialog(getActivity());
        btn = v.findViewById(R.id.payment);
        source = v.findViewById(R.id.s_ource);
        destination = v.findViewById(R.id.d_estination);
        nm1 = v.findViewById(R.id.name1);
        i_n1 = v.findViewById(R.id.id_number);
        bus = v.findViewById(R.id.b_type);
        pass = v.findViewById(R.id.pa_type);
        d_1 = v.findViewById(R.id.d);
        a1 = v.findViewById(R.id.a_ge);
        b1 = v.findViewById(R.id.birthday);
        ly1 = v.findViewById(R.id.l_y1);
        ly2 = v.findViewById(R.id.l_y2);
        ly3 = v.findViewById(R.id.l_y3);
        ly4 = v.findViewById(R.id.l_y4);
        ly5 = v.findViewById(R.id.l_y5);
        ly6 = v.findViewById(R.id.l_y6);
        ly7 = v.findViewById(R.id.l_y7);
        ly8 = v.findViewById(R.id.l_y8);
        iv = v.findViewById(R.id.sumry);
        tv = v.findViewById(R.id.title7);
        btn = v.findViewById(R.id.payment);
        gender = v.findViewById(R.id.gender);
        btn2 = v.findViewById(R.id.edit_pass);

        preferences = getActivity().getSharedPreferences("login", Context.MODE_PRIVATE);
        otp = preferences.getString("otp", null);
        SharedPreferences preferences111 = getActivity().getSharedPreferences("data", Context.MODE_PRIVATE);
        mobile = preferences111.getString("mobile", null);

        AnimationUtils animationUtils = new AnimationUtils();
        Animation animation = animationUtils.loadAnimation(getActivity(), R.anim.left);
        Animation animation1 = animationUtils.loadAnimation(getActivity(), R.anim.fade_in);
        Animation animation2 = animationUtils.loadAnimation(getActivity(), R.anim.left);
        Animation animation3 = animationUtils.loadAnimation(getActivity(), R.anim.left);
        Animation animation4 = animationUtils.loadAnimation(getActivity(), R.anim.left);
        Animation animation5 = animationUtils.loadAnimation(getActivity(), R.anim.left);
        Animation animation6 = animationUtils.loadAnimation(getActivity(), R.anim.left);
        Animation animation7 = animationUtils.loadAnimation(getActivity(), R.anim.left);
        Animation animation8 = animationUtils.loadAnimation(getActivity(), R.anim.left);
        Animation animation9 = animationUtils.loadAnimation(getActivity(), R.anim.left);
        Animation animation10 = animationUtils.loadAnimation(getActivity(), R.anim.bounce);
        Animation animation11 = animationUtils.loadAnimation(getActivity(), R.anim.bounce);


        iv.startAnimation(animation);
        tv.startAnimation(animation1);
        ly1.startAnimation(animation2);
        ly2.startAnimation(animation3);
        ly3.startAnimation(animation4);
        ly4.startAnimation(animation5);
        ly5.startAnimation(animation6);
        ly6.startAnimation(animation7);
        ly7.startAnimation(animation8);
        ly8.startAnimation(animation9);
        btn.startAnimation(animation10);
        btn2.startAnimation(animation11);


        SharedPreferences preferences = getActivity().getSharedPreferences("mypre", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = preferences.edit();
        ed.putString("date", date);
        s0 = preferences.getString("skey", null);
        d0 = preferences.getString("dkey", null);
        n0 = preferences.getString("nkey", null);
        i_n0 = preferences.getString("i_nkey", null);
        b_type = preferences.getString("buskey", null);
        p_type = preferences.getString("passkey", null);
        duration = String.valueOf(preferences.getInt("d_key", 0));
        a = preferences.getString("agekey", null);
        b_Date = preferences.getString("bkey", null);
        g_ender = preferences.getString("gender", null);
        idproof = preferences.getString("idproof", null);
        address = preferences.getString("address", null);
        city = preferences.getString("city", null);
        pincode = preferences.getString("pincode", null);
        area = preferences.getString("area", null);
        fare = preferences.getInt("fkey", 0);
        Log.e("Fare", String.valueOf(fare));


        source.setText(s0);
        destination.setText(d0);
        nm1.setText(n0);
        i_n1.setText(i_n0);
        bus.setText(b_type);
        pass.setText(p_type);
        d_1.setText(duration);
        a1.setText(a);
        b1.setText(b_Date);
        gender.setText(g_ender);
        //   fare_1.setText(fare);
        BounceView.addAnimTo(btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                SharedPreferences preferences = getActivity().getSharedPreferences("result", Context.MODE_PRIVATE);
                String d1 = preferences.getString("d1", null);
                String d2 = preferences.getString("d2", null);
                String d3 = preferences.getString("d3", null);
                imageList.add(d1);
                imageList.add(d2);
                imageList.add(d3);
                if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.READ_SMS, Manifest.permission.RECEIVE_SMS}, 101);
                }




            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getFragmentManager().popBackStack();
            }
        });

        return v;
    }







}
