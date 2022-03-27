package py.com.sodep.sodeptestapp.network;

import py.com.sodep.sodeptestapp.models.Account;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("account")
    Call<Account> getListAcounts();
}