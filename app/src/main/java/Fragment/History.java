package Fragment;


import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chintu.Gops.APIClient;
import com.example.chintu.Gops.APIinterface;
import com.example.chintu.Gops.R;

import java.sql.BatchUpdateException;
import java.util.ArrayList;

import javax.xml.transform.Source;

import Adapter.CustomeAdpter;
import Model.Insertnewpas;
import Model.ResultRegistration;
import Model.ResultShowPRofile;
import Model.Showprofile;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class History extends android.app.Fragment {
    ListView lv;
    Button btn1;
    TextView tv;
    ImageView iv;

    ArrayList<Insertnewpas> arrayList;

    String mobile;
    ArrayList<Showprofile> arrayList1;
    ProgressDialog pd;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_history, container, false);
        SharedPreferences preferences = getActivity().getSharedPreferences("data", Context.MODE_PRIVATE);
        mobile = preferences.getString("mobile", null);
        btn1 = v.findViewById(R.id.back2);
        tv = v.findViewById(R.id.title11);
        iv = v.findViewById(R.id.history);
        lv = v.findViewById(R.id.pass);
        arrayList = new ArrayList<>();
        arrayList1 = new ArrayList<>();
        pd = new ProgressDialog(getActivity());
        AnimationUtils animationUtils = new AnimationUtils();
        Animation animation = animationUtils.loadAnimation(getActivity(), R.anim.left);
        Animation animation1 = animationUtils.loadAnimation(getActivity(), R.anim.fade_in);
        Animation animation2 = animationUtils.loadAnimation(getActivity(), R.anim.left);
        Animation animation3 = animationUtils.loadAnimation(getActivity(), R.anim.bounce);
        iv.startAnimation(animation);
        tv.startAnimation(animation1);
        lv.startAnimation(animation2);
        btn1.startAnimation(animation3);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                h_o_m_e h_o_m_e = new h_o_m_e();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.addToBackStack("hello");
                ft.replace(R.id.h_m, h_o_m_e);
                ft.commit();

            }
        });

        pd.setMessage("Loading...");
        pd.show();
        APIinterface apIinterface = APIClient.getClient().create(APIinterface.class);
        Call<ResultShowPRofile> call = apIinterface.getprofile(mobile);
        call.enqueue(new Callback<ResultShowPRofile>() {
            @Override
            public void onResponse(Call<ResultShowPRofile> call, Response<ResultShowPRofile> response) {
                try {
                    pd.dismiss();
                    arrayList1 = (ArrayList<Showprofile>) response.body().getShowprofile();
                    CustomeAdpter customeAdpter = new CustomeAdpter(getActivity(), arrayList1);
                    lv.setAdapter(customeAdpter);
                } catch (Exception e) {
                    pd.dismiss();
                    Toast.makeText(getActivity(), "Data not available", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResultShowPRofile> call, Throwable t) {
                pd.dismiss();

                Toast.makeText(getActivity(), "Data Not Found", Toast.LENGTH_SHORT).show();
            }
        });
        return v;

    }


}
