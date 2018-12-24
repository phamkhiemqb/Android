package p.pklovestar.bitp_salong.Salon;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Relationships {
    @SerializedName("services")
    @Expose
    public List<Service> services = null;
}
