package py.com.sodep.sodeptestapp.network;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {

    public ApiInterface getService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://marcos-api.sodep.com.py/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient().newBuilder().addInterceptor(chain -> {
                    Request request = chain.request().newBuilder().addHeader("Authorization", "Bearer ").build();
                    return chain.proceed(request);
                }).build())
                .build();
        return retrofit.create(ApiInterface.class);
    }
}
