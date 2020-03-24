package Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.chintu.Gops.R;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

/**
 * A simple {@link Fragment} subclass.
 */
public class Update_Id extends android.app.Fragment {


    LinearLayout l1, l2;
    Button btn, btn1;
    MaterialBetterSpinner mb;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_update__id, container, false);
        l1 = v.findViewById(R.id.L4);
        l2 = v.findViewById(R.id.L5);
        btn = v.findViewById(R.id.back5);
        btn1 = v.findViewById(R.id.ui_submit);
        mb = v.findViewById(R.id.idproof);

        AnimationUtils animationUtils = new AnimationUtils();
        Animation animation = animationUtils.loadAnimation(getActivity(), R.anim.left);
        Animation animation1 = animationUtils.loadAnimation(getActivity(), R.anim.bounce);
        l1.startAnimation(animation);
        l2.startAnimation(animation1);
        String str1[] = getResources().getStringArray(R.array.idproof_name);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.support_simple_spinner_dropdown_item, str1);
        mb.setAdapter(adapter);
        btn.setOnClickListener(new View.OnClickListener() {
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
