package Fragment;


import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
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
import android.widget.Toast;

import com.example.chintu.Gops.Home;
import com.example.chintu.Gops.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import Adapter.CustomeAdpter;

import hari.bounceview.BounceView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class User_profile extends android.app.Fragment {

    TextView tv, tv1, tv2, tv3, tv4, tv5, tv6;
    ImageView iv, iv1, iv2;
    LinearLayout l1, l2, l3, l4, l5, l6;
    Button btn4;
    String mobile;

    ProgressDialog pd;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_user_profile, container, false);
        SharedPreferences preferences = getActivity().getSharedPreferences("data", Context.MODE_PRIVATE);
        mobile = preferences.getString("mobile", null);
        btn4 = v.findViewById(R.id.back3);
        tv = v.findViewById(R.id.title12);
        iv = v.findViewById(R.id.userprofile);
        l1 = v.findViewById(R.id.ll1);
        l2 = v.findViewById(R.id.ll2);
        l3 = v.findViewById(R.id.ll3);
        l4 = v.findViewById(R.id.ll4);
        l5 = v.findViewById(R.id.ll5);
        iv1 = v.findViewById(R.id.photo);
        iv2 = v.findViewById(R.id.sign);
        l6 = v.findViewById(R.id.ll6);
        tv1 = v.findViewById(R.id.p_name);
        tv2 = v.findViewById(R.id.b_profile);
        tv3 = v.findViewById(R.id.gender_profile);
        tv4 = v.findViewById(R.id.idproof_profile);
        tv5 = v.findViewById(R.id.id_number_profile);
        tv6 = v.findViewById(R.id.add_profile);

        pd = new ProgressDialog(getActivity());

        AnimationUtils animationUtils = new AnimationUtils();
        Animation animation = animationUtils.loadAnimation(getActivity(), R.anim.left);
        Animation animation1 = animationUtils.loadAnimation(getActivity(), R.anim.fade_in);
        Animation animation2 = animationUtils.loadAnimation(getActivity(), R.anim.left);
        Animation animation3 = animationUtils.loadAnimation(getActivity(), R.anim.left);
        Animation animation4 = animationUtils.loadAnimation(getActivity(), R.anim.left);
        Animation animation5 = animationUtils.loadAnimation(getActivity(), R.anim.left);
        Animation animation6 = animationUtils.loadAnimation(getActivity(), R.anim.left);
        Animation animation7 = animationUtils.loadAnimation(getActivity(), R.anim.slide_down);
        Animation animation8 = animationUtils.loadAnimation(getActivity(), R.anim.slide_down);
        Animation animation9 = animationUtils.loadAnimation(getActivity(), R.anim.left);
        Animation animation13 = animationUtils.loadAnimation(getActivity(), R.anim.bounce);


        iv.startAnimation(animation);
        tv.startAnimation(animation1);
        l1.startAnimation(animation2);
        l2.startAnimation(animation3);
        l3.startAnimation(animation4);
        l4.startAnimation(animation5);
        l5.startAnimation(animation6);
        iv1.startAnimation(animation7);
        iv2.startAnimation(animation8);
        l6.startAnimation(animation9);
        btn4.startAnimation(animation13);
        BounceView.addAnimTo(btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                h_o_m_e h_o_m_e = new h_o_m_e();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.h_m, h_o_m_e);
                ft.commit();

            }
        });

        pd.setMessage("Loading...");
        pd.show();


        return v;
    }
}
