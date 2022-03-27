package py.com.sodep.sodeptestapp.network;

import java.util.ArrayList;
import py.com.sodep.sodeptestapp.models.Account;
import py.com.sodep.sodeptestapp.models.MCreatedTask;
import py.com.sodep.sodeptestapp.models.Tasks;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    @GET("account")
    Call<Account> getListAcounts();

    @GET("tasks")
    Call<ArrayList<Tasks>> getListTasks();

    @POST("tasks")
    Call<MCreatedTask> postTasks(@Body MCreatedTask task);
}