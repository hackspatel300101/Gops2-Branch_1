package Fragment;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chintu.Gops.APIClient;
import com.example.chintu.Gops.APIinterface;
import com.example.chintu.Gops.R;
import com.example.chintu.Gops.WEbService.ApiCallback;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.util.ArrayList;
import java.util.Calendar;

import Model.Contact;
import Model.Mobile;
import hari.bounceview.BounceView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class new_pass1 extends android.app.Fragment implements ApiCallback {

    ImageView iv;
    MaterialBetterSpinner mb, mb1, mb2, mb3;
    Button btn, btn_bdate, go;
    static EditText text;
    EditText nm, i_n;
    Calendar c;
    DatePickerDialog dpd;
    TextView age, tv, tv1, tv2, tv3, tv4, tv5, tv6;
    Spinner sp, sp1;
    RadioGroup radioGroup;
    RadioButton rb;
    String birthday, gender, s0, d0, p_type;
    int fare1, duration;
    static String s_1, s_2, s_3, s_4, s_5;


    static View v;
    ArrayList<String> imageList = new ArrayList<>();
    ArrayList<Mobile> arrayList;
    String dsnmae, dgender, dage, dmobile, denroll, dinstitutename;

    RadioButton r1, r2;
    String sid;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_new_pass1, null);
        mb = v.findViewById(R.id.btype);
        mb1 = v.findViewById(R.id.p_type);
        mb2 = v.findViewById(R.id.duration);
        mb3 = v.findViewById(R.id.idproof);
        btn = v.findViewById(R.id.next);
        text = v.findViewById(R.id.add);
        btn_bdate = v.findViewById(R.id.b_date);
        age = v.findViewById(R.id.age);
        nm = v.findViewById(R.id.name);
        i_n = v.findViewById(R.id.idnumber);
        radioGroup = v.findViewById(R.id.rg);
        iv = v.findViewById(R.id.newpass1);
        tv = v.findViewById(R.id.title5);
        tv1 = v.findViewById(R.id.bust);
        tv2 = v.findViewById(R.id.passt);
        tv3 = v.findViewById(R.id.du_ration);
        tv4 = v.findViewById(R.id.gn);
        tv5 = v.findViewById(R.id.id_proof);
        tv6 = v.findViewById(R.id.address);
        arrayList = new ArrayList<>();
        r1 = v.findViewById(R.id.male);
        r2 = v.findViewById(R.id.female);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (group == radioGroup) {
                    RadioButton rb = v.findViewById(checkedId);
                    gender = rb.getText().toString();
                }
            }
        });


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
        Animation animation13 = animationUtils.loadAnimation(getActivity(), R.anim.left);
        Animation animation14 = animationUtils.loadAnimation(getActivity(), R.anim.left);
        Animation animation15 = animationUtils.loadAnimation(getActivity(), R.anim.left);
        Animation animation16 = animationUtils.loadAnimation(getActivity(), R.anim.left);
        Animation animation17 = animationUtils.loadAnimation(getActivity(), R.anim.bounce);

        iv.startAnimation(animation);
        tv.startAnimation(animation1);
        tv1.startAnimation(animation2);
        mb.startAnimation(animation3);
        tv2.startAnimation(animation4);
        mb1.startAnimation(animation5);
        tv3.startAnimation(animation6);
        mb2.startAnimation(animation7);
        nm.startAnimation(animation8);
        tv4.startAnimation(animation9);
        radioGroup.startAnimation(animation10);
        btn_bdate.startAnimation(animation11);
        tv5.startAnimation(animation12);
        mb3.startAnimation(animation13);
        i_n.startAnimation(animation14);
        tv6.startAnimation(animation15);
        text.startAnimation(animation16);


        String str[] = getResources().getStringArray(R.array.bus_type);
        String str1[] = getResources().getStringArray(R.array.pass_type);
        String str2[] = getResources().getStringArray(R.array.month);
        String str3[] = getResources().getStringArray(R.array.idproof_name);




        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.support_simple_spinner_dropdown_item, str);
        final ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, str1);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getActivity(), R.layout.support_simple_spinner_dropdown_item, str2);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(getActivity(), R.layout.support_simple_spinner_dropdown_item, str3);
        mb.setAdapter(adapter);
        mb1.setAdapter(adapter1);
        mb2.setAdapter(adapter2);
        mb3.setAdapter(adapter3);
        BounceView.addAnimTo(btn);
        BounceView.addAnimTo(btn_bdate);


        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adress adress = new adress();
                android.app.FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.add(R.id.h_m, adress);
                ft.addToBackStack("hello");
                ft.commit();
            }
        });
        text.setFocusable(false);


        mb1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.e("POS", String.valueOf(position));

                switch (position) {
                    case 0:
                        final ProgressDialog pd = new ProgressDialog(getActivity());
                        pd.setTitle("Loading Information");
                        pd.setMessage("Please Wait");
                        pd.show();
                        APIinterface apIinterface = APIClient.getClient().create(APIinterface.class);
                        Call<Contact> call = apIinterface.getdetail("8469000537");
                        call.enqueue(new Callback<Contact>() {
                            @Override
                            public void onResponse(Call<Contact> call, Response<Contact> response) {
                                arrayList = (ArrayList<Mobile>) response.body().getMobile();
                                pd.dismiss();
                                dsnmae = arrayList.get(0).getSname();
                                dgender = arrayList.get(0).getGender();
                                dage = arrayList.get(0).getAge();
                                dmobile = arrayList.get(0).getMobile();
                                denroll = arrayList.get(0).getMobile();
                                dinstitutename = arrayList.get(0).getInstitutename();
                                sid = arrayList.get(0).getId();
                                final Dialog dialog = new Dialog(getActivity());
                                dialog.setContentView(R.layout.layout2);
                                dialog.show();
                                sp = dialog.findViewById(R.id.sch_clg);
                                sp1 = dialog.findViewById(R.id.enroll_gr);
                                go = dialog.findViewById(R.id.go);
                                String sch_clg1[] = {dinstitutename};
                                String enroll_gr[] = {denroll};
                                age.setText("   Age:-" + dage);
                                ArrayAdapter<String> adapter4 = new ArrayAdapter<>(getActivity(), R.layout.support_simple_spinner_dropdown_item, sch_clg1);
                                ArrayAdapter<String> adapter5 = new ArrayAdapter<>(getActivity(), R.layout.support_simple_spinner_dropdown_item, enroll_gr);
                                sp.setAdapter(adapter4);
                                sp1.setAdapter(adapter5);
                                go.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        nm.setText(dsnmae);
                                        if (dgender.equalsIgnoreCase("male")) {
                                            r1.setChecked(true);
                                            dialog.dismiss();
                                        } else {
                                            r2.setChecked(true);
                                            dialog.dismiss();
                                        }
                                    }
                                });
                            }

                            @Override
                            public void onFailure(Call<Contact> call, Throwable t) {

                            }
                        });
                }
            }
        });
        btn_bdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c = Calendar.getInstance();
                final int day = c.get(Calendar.DAY_OF_MONTH);
                int month = c.get(Calendar.MONTH);
                int year = c.get(Calendar.YEAR);
                dpd = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        age.setText("   Age:-" + getAge(year, month, dayOfMonth));
                        int m = month + 1;

                        birthday = dayOfMonth + "/" + m + "/" + year;


                    }
                }, day, month, year);
                dpd.show();
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String name = nm.getText().toString();
                String idnumber = i_n.getText().toString();
                String bustype = mb.getText().toString();
                String passtype = mb1.getText().toString();
                int duration = Integer.parseInt(mb2.getText().toString());
                String Age = age.getText().toString();
                String idproof = mb3.getText().toString();
                String id_number = i_n.getText().toString();
                String address = tv6.getText().toString();
                String add = text.getText().toString();

                if (!bustype.equals("")) {
                    btn.setEnabled(!bustype.equals(""));
                    if (!passtype.equals("")) {
                        btn.setEnabled(!passtype.equals(""));
                        if (duration != 0) {
                            btn.setEnabled(duration != 0);
                            if (!name.equals("")) {
                                btn.setEnabled(!name.equals(""));
                                if (gender != null) {
                                    btn.setEnabled(true);
                                    if (birthday != null) {
                                        btn.setEnabled(true);
                                        if (!idproof.equals("")) {
                                            btn.setEnabled(!idproof.equals(""));
                                            if (!id_number.equals("")) {
                                                btn.setEnabled(!id_number.equals(""));
                                                if (!address.equals("")) {
                                                    btn.setEnabled(!address.equals(""));

                                                    SharedPreferences preferences = getActivity().getSharedPreferences("mypre", Context.MODE_PRIVATE);
                                                    SharedPreferences.Editor ed = preferences.edit();
                                                    ed.putString("nkey", name);
                                                    ed.putString("i_nkey", idnumber);
                                                    ed.putString("buskey", bustype);
                                                    ed.putString("passkey", passtype);
                                                    ed.putInt("d_key", duration);
                                                    ed.putString("agekey", Age);
                                                    ed.putString("idproof", idproof);
                                                    ed.putString("bkey", birthday);
                                                    ed.putString("gender", gender);
                                                    ed.putString("address", s_1 + s_2);
                                                    ed.putString("city", s_2);
                                                    ed.putString("destination", s_3);
                                                    ed.putString("pincode", s_4);
                                                    ed.putString("area", s_5);
                                                    ed.putString("id", sid);
                                                    ed.putBoolean("check", true);
                                                    ed.apply();
                                                    upload_doc up = new upload_doc();
                                                    android.app.FragmentTransaction ft = getFragmentManager().beginTransaction();
                                                    ft.addToBackStack("hello");
                                                    ft.add(R.id.h_m, up);
                                                    ft.commit();


                                                } else {
                                                    Toast.makeText(getActivity(), "Please Enter Your Adress", Toast.LENGTH_SHORT).show();
                                                    tv6.setError("\"Please Enter Your Adress\"");
                                                    btn.setEnabled(true);
                                                }

                                            } else {
                                                Toast.makeText(getActivity(), "Please Enter IDproof Number", Toast.LENGTH_SHORT).show();
                                                i_n.setError("\"Please Enter IDproof Number\"");
                                                btn.setEnabled(true);
                                            }
                                        } else {
                                            Toast.makeText(getActivity(), "Please Select IDproof", Toast.LENGTH_SHORT).show();
                                            mb3.setError("Please Select IDproof");
                                            btn.setEnabled(true);
                                        }
                                    } else {
                                        Toast.makeText(getActivity(), "Please Select Your Birthday", Toast.LENGTH_SHORT).show();
                                        btn_bdate.setError("Please Select Your Birthday");
                                        btn.setEnabled(true);

                                    }

                                } else {
                                    Toast.makeText(getActivity(), "Please Select Your Gender", Toast.LENGTH_SHORT).show();
                                    btn.setEnabled(true);
                                }
                            } else {
                                Toast.makeText(getActivity(), "Please Enter Your Name", Toast.LENGTH_SHORT).show();
                                nm.setError("Please Enter Your Name");
                                btn.setEnabled(true);
                            }
                        } else {

                            Toast.makeText(getActivity(), "Please Select Duration", Toast.LENGTH_SHORT).show();
                            mb2.setError("Please Select Duration");
                            btn.setEnabled(true);
                        }

                    } else {
                        Toast.makeText(getActivity(), "Please Select Pass Type", Toast.LENGTH_SHORT).show();
                        mb1.setError("\"Please Select Pass Type\"");
                        btn.setEnabled(true);
                    }


                } else {
                    Toast.makeText(getActivity(), "Please Select Bus Type", Toast.LENGTH_SHORT).show();
                    mb.setError("\"Please Select Bus Type\"");
                    btn.setEnabled(true);
                }
                SharedPreferences preferences = getActivity().getSharedPreferences("mypre", Context.MODE_PRIVATE);
                s0 = preferences.getString("skey", null);
                d0 = preferences.getString("dkey", null);
                p_type = preferences.getString("passkey", null);
                duration = preferences.getInt("d_key", 0);

                if (s0.equals("Ahmedabad") && d0.equals("Mahemadavad") && p_type.equals("Regular")) {
                    fare1 = 250;
                    fare1 *= duration;


                } else if (s0.equals("Ahmedabad") && d0.equals("Mahemadavad") && p_type.equals("Student")) {
                    fare1 = 100;
                    fare1 *= duration;
                } else if (s0.equals("Nadiad") && d0.equals("Mahemadavad") && p_type.equals("Regular")) {
                    fare1 = 200;
                    fare1 *= duration;

                } else if (s0.equals("Nadiad") && d0.equals("Mahemadavad") && p_type.equals("Student")) {
                    fare1 = 100;
                    fare1 *= duration;
                } else {
                    fare1 = 100;
                }
                SharedPreferences.Editor ed = preferences.edit();
                ed.putInt("fkey", fare1);
                ed.apply();
            }
        });


        return v;
    }


    private String getAge(int year, int month, int day) {
        Calendar dob = Calendar.getInstance();
        Calendar today = Calendar.getInstance();

        dob.set(year, month, day);

        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);

        if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }

        Integer ageInt = new Integer(age);
        String ageS = ageInt.toString();


        return ageS;
    }

    public static void Refreshdata(String s1, String s2, String s3, String s4, String s5, String s6) {

        text = v.findViewById(R.id.add);
        text.setText(s1 + " " + s2 + "" + " " + s3 + " " + s4 + " " + s5 + " " + s6);
        s_1 = s1 + s2;
        s_2 = s3;
        s_3 = s4;
        s_4 = s5;
        s_5 = s6;

    }

    @Override
    public void onApiResultResponse(String responseString) {

    }


    /*  @Override
      public void onResume() {
          super.onResume();
          try {
              SharedPreferences preferences = getActivity().getSharedPreferences("address", Context.MODE_PRIVATE);

              String add1 = preferences.getString("key1", null);
              String add2 = preferences.getString("key2", null);
              String towncity = preferences.getString("key3", null);
              String area = preferences.getString("key4", null);
              String dist = preferences.getString("key5", null);
              String pincode = preferences.getString("key6", null);
              text.setText(add1 + " " + add2 + "" + " " + towncity + " " + dist + " " + pincode + " " + area);
          } catch (Exception e) {

          }*/


}
