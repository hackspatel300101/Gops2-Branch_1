
package Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Otp {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("u_m_number")
    @Expose
    private String uMNumber;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUMNumber() {
        return uMNumber;
    }

    public void setUMNumber(String uMNumber) {
        this.uMNumber = uMNumber;
    }

}
