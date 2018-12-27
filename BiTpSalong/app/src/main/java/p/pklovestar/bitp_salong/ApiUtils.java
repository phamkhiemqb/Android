package p.pklovestar.bitp_salong;

public class ApiUtils {
    public static final String BASE_URL = "http://45.77.27.89:8088/api/";

    public static APIRequest getAPIService() {
        return RetrofitClient.getClient(BASE_URL).create(APIRequest.class);
    }
}
