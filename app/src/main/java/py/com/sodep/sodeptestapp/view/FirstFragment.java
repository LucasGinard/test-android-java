package py.com.sodep.sodeptestapp.view;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import py.com.sodep.sodeptestapp.databinding.FragmentFirstBinding;
import py.com.sodep.sodeptestapp.models.AuthID;
import py.com.sodep.sodeptestapp.models.Account;
import py.com.sodep.sodeptestapp.models.ModelAuth;
import py.com.sodep.sodeptestapp.network.ApiInterface;
import py.com.sodep.sodeptestapp.network.ApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    ApiService service;
    ApiInterface apiInterface;
    String tokenId;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        service = new ApiService();
        apiInterface = service.getService();
        configureListeners();
    }

    private void configureListeners(){
        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                NavHostFragment.findNavController(FirstFragment.this)
//                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
                getListAccounts();
            }
        });
    }

    private void getListAccounts() {
        Call<Account> call = apiInterface.getListAcounts();
        call.enqueue(new Callback<Account>() {
            @Override
            public void onResponse(Call<Account> call, Response<Account> response) {
                Log.d("testReturn", "exitoso -> "+response.body().getFirstName());

            }

            @Override
            public void onFailure(Call<Account> call, Throwable t) {
                Log.d("testReturn", "errorAcounts -> "+t.getMessage());

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}