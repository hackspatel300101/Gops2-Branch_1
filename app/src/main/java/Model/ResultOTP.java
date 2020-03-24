package Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResultOTP {
    @SerializedName("otp")
    @Expose
    private List<Otp> otp = null;

    public List<Otp> getOtp() {
        return otp;
    }

    public void setOtp(List<Otp> otp) {
        this.otp = otp;
    }

}
