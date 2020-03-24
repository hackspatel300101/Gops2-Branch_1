
package Model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultShowPRofile {

    @SerializedName("showprofile")
    @Expose
    private List<Showprofile> showprofile = null;

    public List<Showprofile> getShowprofile() {
        return showprofile;
    }

    public void setShowprofile(List<Showprofile> showprofile) {
        this.showprofile = showprofile;
    }

}
