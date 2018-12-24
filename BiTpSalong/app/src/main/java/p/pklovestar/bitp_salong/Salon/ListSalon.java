package p.pklovestar.bitp_salong.Salon;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ListSalon {
    @SerializedName("data")
    @Expose
    public List<TTSalon> data = null;

    public List<TTSalon> getData() {
        return data;
    }

    public void setData(List<TTSalon> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ListSalon{" +
                "data=" + data +
                '}';
    }
}

