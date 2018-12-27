package p.pklovestar.bitp_salong;

import p.pklovestar.bitp_salong.Salon.ListSalon;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIRequest {
    @GET("hodela/list_salon")
    Call<ListSalon> getlistSalon();


}
