package Fragment;


import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.chintu.Gops.R;
import com.google.zxing.WriterException;

import java.sql.BatchUpdateException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;
import hari.bounceview.BounceView;

/**
 * A simple {@link Fragment} subclass.
 */
public class QRpass extends android.app.Fragment {

    ImageView iv, iv1;
    TextView tv, tv1, s, d, gops, pass_da;
    LinearLayout layout1, layout2, layout3;
    Bitmap bitmap;
    QRGEncoder qrgEncoder;
    int duration;
    int i = 30;
    int i1 = 30;
    String formats1, fo1;


    Button btn1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_qrpass, container, false);
        btn1 = v.findViewById(R.id.back);
        iv = v.findViewById(R.id.qrpass);
        tv = v.findViewById(R.id.title8);
        tv1 = v.findViewById(R.id.note2);
        iv1 = v.findViewById(R.id.qr_code);
        s = v.findViewById(R.id.qs);
        d = v.findViewById(R.id.qd);
        layout1 = v.findViewById(R.id.qlay);
        layout2 = v.findViewById(R.id.qlay1);
        layout3 = v.findViewById(R.id.qlay2);
        gops = v.findViewById(R.id.gopsno);
        pass_da = v.findViewById(R.id.validfromdate);


        AnimationUtils animationUtils = new AnimationUtils();
        Animation animation = animationUtils.loadAnimation(getActivity(), R.anim.left);
        Animation animation1 = animationUtils.loadAnimation(getActivity(), R.anim.fade_in);
        Animation animation2 = animationUtils.loadAnimation(getActivity(), R.anim.left);
        Animation animation3 = animationUtils.loadAnimation(getActivity(), R.anim.slide_down);
        Animation animation4 = animationUtils.loadAnimation(getActivity(), R.anim.bounce);
        Animation animation5 = animationUtils.loadAnimation(getActivity(), R.anim.left);
        Animation animation6 = animationUtils.loadAnimation(getActivity(), R.anim.left);
        Animation animation7 = animationUtils.loadAnimation(getActivity(), R.anim.left);
        iv.startAnimation(animation);
        tv.startAnimation(animation1);
        tv1.startAnimation(animation2);
        layout1.startAnimation(animation5);
        layout2.startAnimation(animation6);
        layout3.startAnimation(animation7);
        iv1.startAnimation(animation3);
        btn1.startAnimation(animation4);

        BounceView.addAnimTo(btn1);
        i *= duration;
        i1 = duration + 1;
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, i);
        c.add(Calendar.DATE, i1);
        Date date = c.getTime();


        SimpleDateFormat formatter5 = new SimpleDateFormat("dd-MM-yyyy");
        formats1 = formatter5.format(date);


        SharedPreferences preferences = getActivity().getSharedPreferences("mypre", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = preferences.edit();
        ed.putString("endate", formats1);
        ed.putString("stime", fo1);

        ed.apply();
        String s0 = preferences.getString("skey", null);
        String d0 = preferences.getString("dkey", null);
        String n0 = preferences.getString("nkey", null);
        String i_n0 = preferences.getString("i_nkey", null);
        String b_type = preferences.getString("buskey", null);
        String p_type = preferences.getString("passkey", null);
        duration = preferences.getInt("d_key", 0);
        String a = preferences.getString("agekey", null);
        String b_Date = preferences.getString("bkey", null);
        String g_ender = preferences.getString("gender", null);
        SharedPreferences preferences11 = getActivity().getSharedPreferences("datadata", Context.MODE_PRIVATE);
        String id = preferences11.getString("otp", null);


        gops.setText(id);
        Log.e("GopesID", String.valueOf(id));


        s.setText(s0);
        d.setText(d0);




        pass_da.setText(formats1);
        SharedPreferences prf = getActivity().getSharedPreferences("result", Context.MODE_PRIVATE);
        String d1 = prf.getString("d1", null);
        String d2 = prf.getString("d2", null);
        String d3 = prf.getString("d3", null);

        String string = "Gops No: " + id + "     " + "Source: " + s0 + "                          " + "Destination: " + d0 + "                         " + "Name: " + n0 + "     " + "Id Number: " + i_n0 + "     " + "Bus type: " + b_type + "    " + "Pass type: " + p_type + "     " + "Duration: " + duration + "     " + "area: " + a + "      " + "Birth day: " + b_Date + "     " + "Gender: " + g_ender + "      " + "Fare: " + b_Date + "     " + d1 + d2 + d3;

        WindowManager manager = (WindowManager) getActivity().getSystemService(Context.WINDOW_SERVICE);
        Display display = manager.getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        int width = point.x;
        int height = point.y;
        int smallerDimension = width < height ? width : height;
        smallerDimension = smallerDimension * 3 / 4;
        qrgEncoder = new QRGEncoder(string, null,
                QRGContents.Type.TEXT, smallerDimension);


        try {
            bitmap = qrgEncoder.encodeAsBitmap();
            iv1.setImageBitmap(bitmap);

        } catch (WriterException e) {

        }

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                h_o_m_e h_o_m_e = new h_o_m_e();
                android.app.FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.addToBackStack("hello");
                ft.replace(R.id.h_m, h_o_m_e);
                ft.commit();

            }
        });
        return v;
    }

}
