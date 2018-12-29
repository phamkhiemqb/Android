package p.pklovestar.bitp_salong;

import p.pklovestar.bitp_salong.Salon.ListSalon;
<<<<<<< HEAD
import p.pklovestar.bitp_salong.Salon.Relationships;
import p.pklovestar.bitp_salong.Salon.TTSalon;
=======
>>>>>>> 9f2e7b0f109099f3c293ae98d8916b6eaf10e9fc
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIRequest {
    @GET("hodela/list_salon")
    Call<ListSalon> getlistSalon();
    @GET("hodela/list_salon")
    Call<Relationships> getlistService();


}
