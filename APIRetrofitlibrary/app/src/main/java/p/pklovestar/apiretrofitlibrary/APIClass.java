package p.pklovestar.apiretrofitlibrary;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIClass {

    @GET("hodela//list_produce")
    Call<ListProduce> getListProducer();
}
