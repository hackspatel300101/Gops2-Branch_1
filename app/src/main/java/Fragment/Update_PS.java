package Fragment;


import android.media.Image;
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

import com.example.chintu.Gops.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Update_PS extends android.app.Fragment {


    TextView tv, tv1, tv2;
    ImageView iv, iv1, iv2;
    Button btn1, btn2, btn3, btn4, btn5;
    LinearLayout l1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_update_, container, false);
        tv = v.findViewById(R.id.u_p);
        iv = v.findViewById(R.id.photo);
        btn1 = v.findViewById(R.id.p_btn);
        tv1 = v.findViewById(R.id.u_s);
        iv1 = v.findViewById(R.id.sign);
        btn2 = v.findViewById(R.id.s_btn);
        l1 = v.findViewById(R.id.L6);
        btn3 = v.findViewById(R.id.back7);
        btn4 = v.findViewById(R.id.ups_submit);
        tv2 = v.findViewById(R.id.u_i);
        iv2 = v.findViewById(R.id.iddoc);
        btn5 = v.findViewById(R.id.id_btn);


        AnimationUtils animationUtils = new AnimationUtils();
        Animation animation = animationUtils.loadAnimation(getActivity(), R.anim.left);
        Animation animation1 = animationUtils.loadAnimation(getActivity(), R.anim.slide_down);
        Animation animation2 = animationUtils.loadAnimation(getActivity(), R.anim.bounce);
        Animation animation3 = animationUtils.loadAnimation(getActivity(), R.anim.left);
        Animation animation4 = animationUtils.loadAnimation(getActivity(), R.anim.slide_down);
        Animation animation5 = animationUtils.loadAnimation(getActivity(), R.anim.bounce);
        Animation animation6 = animationUtils.loadAnimation(getActivity(), R.anim.bounce);
        Animation animation7 = animationUtils.loadAnimation(getActivity(), R.anim.left);
        Animation animation8 = animationUtils.loadAnimation(getActivity(), R.anim.slide_down);
        Animation animation9 = animationUtils.loadAnimation(getActivity(), R.anim.bounce);

        tv.startAnimation(animation);
        iv.startAnimation(animation1);
        btn1.startAnimation(animation2);
        tv1.startAnimation(animation3);
        iv1.startAnimation(animation4);
        btn2.startAnimation(animation5);
        tv2.startAnimation(animation7);
        iv2.startAnimation(animation8);
        btn5.startAnimation(animation9);
        l1.startAnimation(animation6);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User_profile user_profile = new User_profile();
                android.app.FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.h_m, user_profile);
                ft.commit();
            }
        });
        return v;
    }

}
