package p.pklovestar.bitp_salong.Salon;

import java.util.List;

public class ListSalon {
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
