package pk.pklovestar.baitaptonghop.API;

import pk.pklovestar.baitaptonghop.Model.TTKhachHangInput;
import pk.pklovestar.baitaptonghop.Model.ThongTinKhachHang;
import pk.pklovestar.baitaptonghop.Model.UserKhachHangInput;
import pk.pklovestar.baitaptonghop.Model.UserKhachHangOutput;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface OnAPICilent {
    @POST("Login")
    Call<UserKhachHangOutput> getToken(@Body UserKhachHangInput userkh);
    @POST("GetUsersByUsername")
    Call<ThongTinKhachHang> getThongTinKhachHang(@Body TTKhachHangInput ttKhachHangInput);
}
