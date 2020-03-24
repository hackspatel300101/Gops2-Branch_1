
package Model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultRegistration {

    @SerializedName("insertnewpass")
    @Expose
    private List<Insertnewpas> insertnewpass = null;

    public List<Insertnewpas> getInsertnewpass() {
        return insertnewpass;
    }

    public void setInsertnewpass(List<Insertnewpas> insertnewpass) {
        this.insertnewpass = insertnewpass;
    }

}
