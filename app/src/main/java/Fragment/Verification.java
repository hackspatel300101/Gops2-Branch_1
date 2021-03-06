package Fragment;


import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chintu.Gops.Home;
import Model.User;
import com.example.chintu.Gops.R;
import com.goodiebag.pinview.Pinview;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import hari.bounceview.BounceView;

public class Verification extends android.app.Fragment {
    Button btn;
    Pinview pv;
    TextView tv, tv1;

    FirebaseAuth auth;
    LinearLayout ly;
    String verificationCode;
    String v1;
    ProgressDialog pd;
    private  String NODE_USER= "User";
    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallback;
    String number;


    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_verification, null);


        tv1 = view.findViewById(R.id.note);
        pv = view.findViewById(R.id.pin_view);
        btn = view.findViewById(R.id.submitbtn);
        pd = new ProgressDialog(getActivity());
        AnimationUtils animationUtils = new AnimationUtils();
        Animation animation = animationUtils.loadAnimation(getActivity(), R.anim.slide_down);
        Animation animation1 = animationUtils.loadAnimation(getActivity(), R.anim.slide_down);
        Animation animation2 = animationUtils.loadAnimation(getActivity(), R.anim.rotate);
        Animation animation3 = animationUtils.loadAnimation(getActivity(), R.anim.bounce);
        Animation animation4 = animationUtils.loadAnimation(getActivity(), R.anim.blink);

        tv1.startAnimation(animation1);

        btn.startAnimation(animation3);
        auth=FirebaseAuth.getInstance();

        Bundle b = getArguments();
        v1 = b.getString("otp");
        number = b.getString("key");
        tv1.setText("Please Type the verification code sent to +91" + number);

        StartFirebaseLogin();

        BounceView.addAnimTo(btn);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String otp = pv.getValue();

                if (!otp.equals("")) {
                    btn.setEnabled(otp.length() == 1);
                    PhoneAuthCredential credential = PhoneAuthProvider.getCredential(v1, otp);
                    SigninWithPhone(credential);
                    pd.setMessage("OTP Verify Please Wait...");
                    pd.show();


                } else {
                    btn.setError("plese Enter Correct OTP");
                    btn.setEnabled(true);
                }
            }
        });


        return view;
    }

    private void SigninWithPhone(PhoneAuthCredential credential) {
        auth.signInWithCredential(credential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            pd.dismiss();
                            SaveUser();
                            Toast.makeText(getActivity(), "Correct OTP", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(getActivity(), Home.class);
                            startActivity(i);
                            SharedPreferences preferences = getActivity().getSharedPreferences("login", Context.MODE_PRIVATE);
                            SharedPreferences.Editor ed = preferences.edit();
                            ed.putBoolean("check", true);
                            ed.apply();
                        } else {
                            pd.dismiss();
                            Toast.makeText(getActivity(), "Incorrect OTP", Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }

    private void SaveUser() {
        String mnumber=auth.getCurrentUser().getPhoneNumber();
        User user = new User(mnumber);
        DatabaseReference dbuser = FirebaseDatabase.getInstance().getReference(NODE_USER);
        dbuser.child(auth.getCurrentUser().getUid())
                .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                if (task.isSuccessful()){
                    Toast.makeText(getActivity(), "Success", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void StartFirebaseLogin() {

        auth = FirebaseAuth.getInstance();
        mCallback = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            @Override
            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
                Toast.makeText(getActivity(), "verification completed", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onVerificationFailed(FirebaseException e) {
//          Toast.makeText(getActivity(), "verification fialed", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(s, forceResendingToken);
                verificationCode = s;
                Toast.makeText(getActivity(), "Code sent", Toast.LENGTH_SHORT).show();
                Log.e("key", verificationCode);


            }

        };
    }




}
