package Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.chintu.Gops.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Update_personal extends android.app.Fragment {

    LinearLayout ly1, ly2, ly3;
    TextView tv;
    EditText txt;
    Button btn, btn1, btn2;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_update_personal, container, false);
        ly1 = v.findViewById(R.id.L1);
        ly2 = v.findViewById(R.id.L2);
        ly3 = v.findViewById(R.id.L3);
        tv = v.findViewById(R.id.b_text);
        txt = v.findViewById(R.id.a_edit);
        btn = v.findViewById(R.id.b_btn);
        btn1 = v.findViewById(R.id.back4);
        btn2 = v.findViewById(R.id.up_submit);

        AnimationUtils animationUtils = new AnimationUtils();
        Animation animation = animationUtils.loadAnimation(getActivity(), R.anim.fade_in);
        Animation animation1 = animationUtils.loadAnimation(getActivity(), R.anim.left);
        Animation animation2 = animationUtils.loadAnimation(getActivity(), R.anim.bounce);
        Animation animation3 = animationUtils.loadAnimation(getActivity(), R.anim.left);
        Animation animation4 = animationUtils.loadAnimation(getActivity(), R.anim.fade_in);
        Animation animation5 = animationUtils.loadAnimation(getActivity(), R.anim.bounce);


        ly1.startAnimation(animation);
        ly2.startAnimation(animation1);
        btn.startAnimation(animation2);
        tv.startAnimation(animation3);
        txt.startAnimation(animation4);
        ly3.startAnimation(animation5);

        btn1.setOnClickListener(new View.OnClickListener() {
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
