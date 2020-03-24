package Fragment;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chintu.Gops.R;

import java.util.Arrays;

import javax.xml.transform.Source;

import hari.bounceview.BounceView;


/**
 * A simple {@link Fragment} subclass.
 */
public class New_pass extends android.app.Fragment {

    AutoCompleteTextView source;
    AutoCompleteTextView destination;
    Button btn;
    TextView tv, tv1, tv2;
    ImageView iv;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_new_pass, container, false);
        iv = v.findViewById(R.id.newpass);
        source = v.findViewById(R.id.Source);
        destination = v.findViewById(R.id.Destination);
        btn = v.findViewById(R.id.btn1);
        tv = v.findViewById(R.id.title4);
        tv1 = v.findViewById(R.id.fs);
        tv2 = v.findViewById(R.id.td);
        AnimationUtils animationUtils = new AnimationUtils();
        Animation animation = animationUtils.loadAnimation(getActivity(), R.anim.left);
        Animation animation1 = animationUtils.loadAnimation(getActivity(), R.anim.fade_in);
        Animation animation2 = animationUtils.loadAnimation(getActivity(), R.anim.fade_in);
        Animation animation3 = animationUtils.loadAnimation(getActivity(), R.anim.bounce);
        Animation animation4 = animationUtils.loadAnimation(getActivity(), R.anim.fade_in);
        Animation animation5 = animationUtils.loadAnimation(getActivity(), R.anim.bounce);
        Animation animation6 = animationUtils.loadAnimation(getActivity(), R.anim.bounce);
        iv.startAnimation(animation);
        tv.startAnimation(animation1);
        tv1.startAnimation(animation2);
        source.startAnimation(animation3);
        tv2.startAnimation(animation4);
        destination.startAnimation(animation5);
        btn.startAnimation(animation6);

        final String arr[] = getResources().getStringArray(R.array.SD);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.select_dialog_item, arr);
        source.setAdapter(adapter);
        destination.setAdapter(adapter);
        BounceView.addAnimTo(btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String s1 = source.getText().toString();
                final String d1 = destination.getText().toString();

                if (!s1.equals("")) {
                    btn.setEnabled(!s1.equals(""));

                    if (!d1.equals("")) {
                        if (Arrays.asList(arr).contains(s1) && Arrays.asList(arr).contains(d1)) {
                            btn.setEnabled(!d1.equals(""));
                            SharedPreferences preferences = getActivity().getSharedPreferences("mypre", Context.MODE_PRIVATE);
                            SharedPreferences.Editor ed = preferences.edit();
                            ed.putString("skey", s1);
                            ed.putString("dkey", d1);
                            ed.apply();
                            new_pass1 new_pass1 = new new_pass1();
                            android.app.FragmentTransaction ft = getFragmentManager().beginTransaction();
                            ft.replace(R.id.h_m, new_pass1);
                            ft.addToBackStack("hello");
                            ft.commit();
                        } else {
                            Toast.makeText(getActivity(), "Please Select Correct Source", Toast.LENGTH_SHORT).show();
                        }
                    } else {

                        destination.setError("Please Enter Destination");
                        btn.setEnabled(true);
                    }


                } else {

                    source.setError("Please Enter Source");
                    btn.setEnabled(true);
                }


            }
        });


        return v;


    }

}