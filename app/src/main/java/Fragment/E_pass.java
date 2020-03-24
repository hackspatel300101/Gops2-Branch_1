package Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.chintu.Gops.R;

import hari.bounceview.BounceView;


/**
 * A simple {@link Fragment} subclass.
 */
public class E_pass extends android.app.Fragment {

    CardView cv;
    CardView cv1;
    ImageView iv;

    public E_pass() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_e_pass, container, false);
        cv = v.findViewById(R.id.new_pass);
        cv1 = v.findViewById(R.id.Renewal_pass);
        iv = v.findViewById(R.id.epass);
        AnimationUtils animationUtils = new AnimationUtils();
        Animation animation = animationUtils.loadAnimation(getActivity(), R.anim.left);
        Animation animation1 = animationUtils.loadAnimation(getActivity(), R.anim.bounce);
        Animation animation2 = animationUtils.loadAnimation(getActivity(), R.anim.bounce);
        iv.startAnimation(animation);
        cv.startAnimation(animation1);
        cv1.startAnimation(animation2);
        BounceView.addAnimTo(cv);
        BounceView.addAnimTo(cv1);

        cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                New_pass np = new New_pass();
                android.app.FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.h_m, np);
                ft.addToBackStack("hello");
                ft.commit();
            }

        });

        cv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Renewal_pass rp = new Renewal_pass();
                android.app.FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.h_m, rp);
                ft.addToBackStack("hello");
                ft.commit();
            }
        });

        return v;
    }

}
