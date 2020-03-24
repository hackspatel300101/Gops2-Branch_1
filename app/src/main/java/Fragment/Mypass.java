package Fragment;


import android.app.FragmentTransaction;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
import android.widget.TextView;

import com.example.chintu.Gops.R;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.encoder.ByteMatrix;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;
import hari.bounceview.BounceView;

/**
 * A simple {@link Fragment} subclass.
 */
public class Mypass extends android.app.Fragment {

    TextView tv, tv1, tv2, tv3, tv4;
    ImageView iv, iv1;
    LinearLayout layout1, layout2, layout3;
    Bitmap bitmap;
    QRGEncoder qrgEncoder;
    String string1;
    int duration;
    Button btn;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_mypass, container, false);
        btn = v.findViewById(R.id.back1);
        tv = v.findViewById(R.id.title10);
        iv = v.findViewById(R.id.my_pass);
        layout1 = v.findViewById(R.id.l1);
        layout2 = v.findViewById(R.id.l2);
        layout3 = v.findViewById(R.id.l3);
        tv1 = v.findViewById(R.id.qr);
        iv1 = v.findViewById(R.id.qr_pass);
        tv2 = v.findViewById(R.id.ms);
        tv3 = v.findViewById(R.id.md);
        tv4 = v.findViewById(R.id.date_mypass);


        AnimationUtils animationUtils = new AnimationUtils();
        Animation animation = animationUtils.loadAnimation(getActivity(), R.anim.left);
        Animation animation1 = animationUtils.loadAnimation(getActivity(), R.anim.fade_in);
        Animation animation2 = animationUtils.loadAnimation(getActivity(), R.anim.left);
        Animation animation3 = animationUtils.loadAnimation(getActivity(), R.anim.left);
        Animation animation4 = animationUtils.loadAnimation(getActivity(), R.anim.fade_in);
        Animation animation5 = animationUtils.loadAnimation(getActivity(), R.anim.slide_down);
        Animation animation6 = animationUtils.loadAnimation(getActivity(), R.anim.bounce);
        Animation animation7 = animationUtils.loadAnimation(getActivity(), R.anim.left);

        iv.startAnimation(animation);
        tv.startAnimation(animation1);
        layout1.startAnimation(animation2);
        layout2.startAnimation(animation3);
        layout3.startAnimation(animation7);
        tv1.startAnimation(animation4);
        iv1.startAnimation(animation5);
        btn.startAnimation(animation6);
        SharedPreferences preferences = getActivity().getSharedPreferences("mypre", Context.MODE_PRIVATE);
        String s0 = preferences.getString("skey", null);
        String d0 = preferences.getString("dkey", null);
        String enddate = preferences.getString("endate", null);
        String n0 = preferences.getString("nkey", null);
        String i_n0 = preferences.getString("i_nkey", null);
        String b_type = preferences.getString("buskey", null);
        String p_type = preferences.getString("passkey", null);
        duration = preferences.getInt("d_key", 0);
        String a = preferences.getString("agekey", null);
        String b_Date = preferences.getString("bkey", null);
        String g_ender = preferences.getString("gender", null);
        tv2.setText(s0);
        tv3.setText(d0);
        tv4.setText(enddate);
        BounceView.addAnimTo(btn);
        String string1 = "Source: " + s0 + "      " + "Destination: " + d0 + "    " + "Name: " + n0 + "     " + "Id Number: " + i_n0 + "        " + "Bus type: " + b_type + "        " + "Pass type: " + p_type + "        " + "Duration: " + duration + "        " + "area: " + a + "         " + "Birth day: " + b_Date + "        " + "Gender: " + g_ender;


        WindowManager manager = (WindowManager) getActivity().getSystemService(Context.WINDOW_SERVICE);
        Display display = manager.getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        int width = point.x;
        int height = point.y;
        int smallerDimension = width < height ? width : height;
        smallerDimension = smallerDimension * 3 / 4;
        qrgEncoder = new QRGEncoder(string1, null,
                QRGContents.Type.TEXT, smallerDimension);


        try {
            bitmap = qrgEncoder.encodeAsBitmap();
            iv1.setImageBitmap(bitmap);

        } catch (WriterException e) {

        }


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                h_o_m_e hOME = new h_o_m_e();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.addToBackStack("hello");
                ft.replace(R.id.h_m, hOME);
                ft.commit();
            }
        });


        return v;
    }

}
