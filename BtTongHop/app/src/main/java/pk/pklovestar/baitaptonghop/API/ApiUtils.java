package pk.pklovestar.baitaptonghop.API;

public class ApiUtils {
    public static final String BASE_URL = "http://203.190.173.22:9005/MobileService.svc/rest/";

    public static OnAPICilent getAPIService() {
        return RetrofitClient.getClient(BASE_URL).create(OnAPICilent.class);
    }
}
