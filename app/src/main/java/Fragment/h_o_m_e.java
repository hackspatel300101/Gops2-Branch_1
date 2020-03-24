package Fragment;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chintu.Gops.R;

import hari.bounceview.BounceView;

/**
 * A simple {@link Fragment} subclass.
 */
public class h_o_m_e extends android.app.Fragment {

    Button btn, btn1, btn2, btn3;
    ImageView iv;
    TextView tv;

    public h_o_m_e() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        btn = v.findViewById(R.id.e_pass_btn);
        btn1 = v.findViewById(R.id.history_btn);
        btn2 = v.findViewById(R.id.book_pass_btn);
        btn3 = v.findViewById(R.id.profile_btn);
        iv = v.findViewById(R.id.l_1);
        AnimationUtils animationUtils = new AnimationUtils();
        Animation animation = animationUtils.loadAnimation(getActivity(), R.anim.bounce);
        Animation animation1 = animationUtils.loadAnimation(getActivity(), R.anim.bounce);
        Animation animation2 = animationUtils.loadAnimation(getActivity(), R.anim.bounce);
        Animation animation3 = animationUtils.loadAnimation(getActivity(), R.anim.bounce);
        Animation animation4 = animationUtils.loadAnimation(getActivity(), R.anim.left);
        Animation animation5 = animationUtils.loadAnimation(getActivity(), R.anim.left);

        iv.startAnimation(animation4);
        btn.startAnimation(animation);
        btn1.startAnimation(animation1);
        btn2.startAnimation(animation2);
        btn3.startAnimation(animation3);
        BounceView.addAnimTo(btn);
        BounceView.addAnimTo(btn1);
        BounceView.addAnimTo(btn2);
        BounceView.addAnimTo(btn3);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                E_pass ep = new E_pass();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.h_m, ep);
                ft.addToBackStack("hello");
                ft.commit();

            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                History history = new History();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.h_m, history);
                ft.addToBackStack("hello");
                ft.commit();

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Mypass mypass = new Mypass();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.h_m, mypass);
                ft.addToBackStack("hello");
                ft.commit();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User_profile up = new User_profile();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.h_m, up);
                ft.addToBackStack("hello");
                ft.commit();
            }
        });
        return v;
    }


}
