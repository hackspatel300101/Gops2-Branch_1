package Fragment;


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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chintu.Gops.R;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;


import hari.bounceview.BounceView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class login_fragment extends android.app.Fragment {
    Button btn;
    EditText txt;
    FirebaseAuth auth;
    String verificationCode;
    TextView tv1, tv2;
    ImageView iv;
    ProgressDialog pd;


    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallback;

    String number;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_login_fragment, container, false);
        btn = v.findViewById(R.id.loginbtn);
        tv1 = v.findViewById(R.id.title2);
        tv2 = v.findViewById(R.id.note1);
        iv = v.findViewById(R.id.login);
        BounceView.addAnimTo(btn);
        pd = new ProgressDialog(getActivity());


        txt = v.findViewById(R.id.mnum);
        AnimationUtils animationUtils = new AnimationUtils();
        Animation animation = animationUtils.loadAnimation(getActivity(), R.anim.fade_in);
        Animation animation1 = animationUtils.loadAnimation(getActivity(), R.anim.slide_down);
        Animation animation2 = animationUtils.loadAnimation(getActivity(), R.anim.move);
        Animation animation3 = AnimationUtils.loadAnimation(getActivity(), R.anim.flip);
        tv1.startAnimation(animation);
        tv2.startAnimation(animation1);
        iv.startAnimation(animation2);
        txt.startAnimation(animation3);


        StartFirebaseLogin();


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = txt.getText().toString();
                if (!number.equals("") && number.length() == 10) {
                    SharedPreferences preferences = getActivity().getSharedPreferences("data", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("mobile", number);
                    editor.apply();

                    PhoneAuthProvider.getInstance().

                            verifyPhoneNumber(
                                    "+91" + number,                     // Phone number to verify
                                    60,                           // Timeout duration
                                    TimeUnit.SECONDS,                // Unit of timeout
                                    getActivity(),        // Activity (for callback binding)

                                    mCallback
                            );                     // OnVerificationStateChangedCallbacks
                    btn.setEnabled(number.length() == 10);
                    pd.setMessage("OTP Sent Please Wait...");
                    pd.show();


                } else {
                    txt.setError("Please Enter Correct Mobile No");
                    btn.setEnabled(true);
                }
            }
        });


        return v;
    }

    private void StartFirebaseLogin() {

        auth = FirebaseAuth.getInstance();
        mCallback = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            @Override
            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
                pd.dismiss();
                //          Toast.makeText(getActivity(), "verification completed", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onVerificationFailed(FirebaseException e) {
                pd.dismiss();
                Toast.makeText(getActivity(), "verification fialed", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(s, forceResendingToken);
                pd.dismiss();
                verificationCode = s;
                Toast.makeText(getActivity(), "Code sent", Toast.LENGTH_SHORT).show();

                Verification vf = new Verification();
                android.app.FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.mainid, vf);
                Bundle b = new Bundle();
                String mn = txt.getText().toString();
                Log.e("otp", verificationCode);
                b.putString("otp", verificationCode);
                b.putString("key", mn);
                vf.setArguments(b);
                ft.commit();

            }

        };
    }
}
