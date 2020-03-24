package Fragment;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.chintu.Gops.R;

import hari.bounceview.BounceView;

/**
 * A simple {@link Fragment} subclass.
 */
public class adress extends android.app.Fragment {
    Button btn;
    EditText add_1, add_2, town_city, pin;
    AutoCompleteTextView dist_;
    RadioGroup rg;
    String area;

    public adress() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v = inflater.inflate(R.layout.fragment_adress, container, false);
        btn = v.findViewById(R.id.Back1);
        add_1 = v.findViewById(R.id.add1);
        add_2 = v.findViewById(R.id.add2);
        town_city = v.findViewById(R.id.towncity);
        dist_ = v.findViewById(R.id.dist);
        pin = v.findViewById(R.id.pincode);
        rg = v.findViewById(R.id.arearg);

        BounceView.addAnimTo(btn);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = v.findViewById(checkedId);
                area = rb.getText().toString();
            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a1 = add_1.getText().toString();
                String a2 = add_2.getText().toString();
                String tc = town_city.getText().toString();
                String a_rea = area;
                String d = dist_.getText().toString();
                String p = pin.getText().toString();
                if (!a1.equals("")) {
                    btn.setEnabled(!a1.equals(""));
                    if (!a2.equals("")) {
                        btn.setEnabled(!a2.equals(""));
                        if (!tc.equals("")) {
                            btn.setEnabled(!tc.equals(""));
                            if (!a_rea.equals("")) {
                                btn.setEnabled(!a_rea.equals(""));
                                if (!d.equals("")) {
                                    btn.setEnabled(!d.equals(""));
                                    if (!p.equals("")) {/*
                                        btn.setEnabled(!p.equals(""));
                                        new_pass1 new_pass1 = new new_pass1();
                                        android.app.FragmentTransaction ft = getFragmentManager().beginTransaction();
                                        Bundle b = new Bundle();
                                        b.putString("a1key",a1);
                                        b.putString("a2key",a2);
                                        b.putString("tckey",tc);
                                        b.putString("dkey",d);
                                        b.putString("pkey",p);

                                        b.putString("area",a_rea);
                                        ft.addToBackStack("hello");
                                        new_pass1.setArguments(b);
                                        ft.commit();*/
                                        /*getActivity().getFragmentManager().beginTransaction()
                                                .replace(R.id.h_m, new new_pass1(), "frag1")

                                                .commit();*/
                                        //getActivity().getFragmentManager().beginTransaction().remove(new adress()).commit();
                                      /*  new_pass1 new_pass1=new new_pass1();
                                        android.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
                                        transaction.replace(R.id.h_m, new_pass1);
                                        transaction.addToBackStack(null);
                                        transaction.commit();*/
                                        SharedPreferences preferences = getActivity().getSharedPreferences("address", Context.MODE_PRIVATE);
                                        SharedPreferences.Editor ed = preferences.edit();
                                        ed.putString("key1", a1);
                                        ed.putString("key2", a2);
                                        ed.putString("key3", tc);
                                        ed.putString("key4", d);
                                        ed.putString("key5", p);
                                        ed.putString("key6", a_rea);
                                        ed.apply();
                                        new_pass1.Refreshdata(a1, a2, tc, d, p, a_rea);
                                        getFragmentManager().popBackStackImmediate();
                                    } else {

                                        Toast.makeText(getActivity(), "Please Enter Pincode", Toast.LENGTH_SHORT).show();
                                        pin.setError("Please Enter Pincode");
                                        btn.setEnabled(true);
                                    }

                                } else {

                                }

                            } else {

                                Toast.makeText(getActivity(), "Please Select Area", Toast.LENGTH_SHORT).show();

                                btn.setEnabled(true);
                            }
                        } else {
                            Toast.makeText(getActivity(), "Please Enter Town/City", Toast.LENGTH_SHORT).show();
                            town_city.setError("Please Enter Town/City");
                            btn.setEnabled(true);
                        }
                    } else {
                        Toast.makeText(getActivity(), "Please Enter Adress Line 2", Toast.LENGTH_SHORT).show();
                        add_2.setError("Please Enter Adress Line 2");
                        btn.setEnabled(true);
                    }

                } else {
                    Toast.makeText(getActivity(), "Please Enter Adress Line 1", Toast.LENGTH_SHORT).show();
                    add_1.setError("Please Enter Adress Line 1");
                    btn.setEnabled(true);


                }


            }
        });
        return v;

    }


}
