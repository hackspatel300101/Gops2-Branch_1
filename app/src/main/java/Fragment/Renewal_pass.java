package Fragment;


import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chintu.Gops.R;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import hari.bounceview.BounceView;
import instamojo.library.InstamojoPay;
import instamojo.library.InstapayListener;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class Renewal_pass extends android.app.Fragment {

    Button btn;
    TextView tv, rid_number, rname, rage, rsource, rdestination, rbustye, rpasstype, rlastdate, rgops;
    ImageView iv;
    LinearLayout ly1, ly2, ly3, ly4, ly5, ly6, ly7, ly8, ly9, ly10, ly11;
    String mobile;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_renewal_pass, container, false);
        final Dialog dialog1 = new Dialog(getActivity());
        SharedPreferences preferences1 = getActivity().getSharedPreferences("data", Context.MODE_PRIVATE);
        mobile = preferences1.getString("mobile", null);
        btn = v.findViewById(R.id.Renewal_payment);
        iv = v.findViewById(R.id.renewpass);
        tv = v.findViewById(R.id.title9);
        ly1 = v.findViewById(R.id.ly1);
        ly2 = v.findViewById(R.id.ly2);
        ly3 = v.findViewById(R.id.ly3);
        ly4 = v.findViewById(R.id.ly4);
        ly5 = v.findViewById(R.id.ly5);
        ly6 = v.findViewById(R.id.ly6);
        ly7 = v.findViewById(R.id.ly7);
        ly8 = v.findViewById(R.id.ly8);
        ly9 = v.findViewById(R.id.ly9);
        ly10 = v.findViewById(R.id.ly10);
        ly11 = v.findViewById(R.id.ly11);
        rid_number = v.findViewById(R.id.Rid_number);
        rname = v.findViewById(R.id.Rname);
        rage = v.findViewById(R.id.Rage);
        rsource = v.findViewById(R.id.Rs);
        rdestination = v.findViewById(R.id.Rd);
        rbustye = v.findViewById(R.id.Rbustype);
        rpasstype = v.findViewById(R.id.Rpasstype);
        rlastdate = v.findViewById(R.id.rlastdate);
        rgops = v.findViewById(R.id.gopsno1);


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
        Animation animation10 = animationUtils.loadAnimation(getActivity(), R.anim.left);
        Animation animation11 = animationUtils.loadAnimation(getActivity(), R.anim.left);
        Animation animation12 = animationUtils.loadAnimation(getActivity(), R.anim.left);
        Animation animation13 = animationUtils.loadAnimation(getActivity(), R.anim.bounce);

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
        ly9.startAnimation(animation10);
        ly10.startAnimation(animation11);
        ly11.startAnimation(animation12);
        btn.startAnimation(animation13);

        SharedPreferences preferences = getActivity().getSharedPreferences("mypre", Context.MODE_PRIVATE);
        String n0 = preferences.getString("nkey", null);
        final String s0 = preferences.getString("skey", null);
        final String d0 = preferences.getString("dkey", null);
        final String destination = preferences.getString("destination", null);
        String b_type = preferences.getString("buskey", null);
        String p_type = preferences.getString("passkey", null);
        String i_num = preferences.getString("i_nkey", null);
        String a = preferences.getString("agekey", null);
        String enddate = preferences.getString("endate", null);
        String lastdate = preferences.getString("rdate", null);
        SharedPreferences preferences11 = getActivity().getSharedPreferences("datadata", Context.MODE_PRIVATE);
        String id = preferences11.getString("otp", null);
        boolean b = preferences.getBoolean("check", false);
        if (b) {
            rid_number.setText(i_num);
            rname.setText(n0);
            rsource.setText(s0);
            rdestination.setText(d0);
            rage.setText(a);
            rpasstype.setText(p_type);
            rbustye.setText(b_type);
            rlastdate.setText(enddate);
            rgops.setText(id);

        } else {
            rid_number.setText("");
            rname.setText("");
            rsource.setText("");
            rdestination.setText("");
            rage.setText("");
            rpasstype.setText("");
            rbustye.setText("");
            rlastdate.setText("");
            rgops.setText("");
        }


        BounceView.addAnimTo(btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int fare = 100;



            }
        });
        return v;

    }



}
