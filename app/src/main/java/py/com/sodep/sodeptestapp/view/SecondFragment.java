package py.com.sodep.sodeptestapp.view;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import py.com.sodep.sodeptestapp.R;
import py.com.sodep.sodeptestapp.adapter.TaskAdapter;
import py.com.sodep.sodeptestapp.databinding.FragmentSecondBinding;
import py.com.sodep.sodeptestapp.models.Tasks;
import py.com.sodep.sodeptestapp.network.ApiInterface;
import py.com.sodep.sodeptestapp.network.ApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    ApiService service;
    ApiInterface apiInterface;
    private ArrayList<Tasks> listTasks;
    private TaskAdapter adapter;
    private RecyclerView recycler;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        service = new ApiService();
        apiInterface = service.getService();
        listTasks = new ArrayList();
        configureRecycler();
        getList();
        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }

    private void configureRecycler() {
        recycler = getActivity().findViewById(R.id.rvTasks);
        adapter = new TaskAdapter(listTasks);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recycler.setLayoutManager(mLayoutManager);
        recycler.setItemAnimator(new DefaultItemAnimator());
        recycler.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void getList() {
        Call<ArrayList<Tasks>> call = apiInterface.getListTasks();
        call.enqueue(new Callback<ArrayList<Tasks>>() {
            @Override
            public void onResponse(Call<ArrayList<Tasks>> call, Response<ArrayList<Tasks>> response) {
                listTasks.clear();
                listTasks.addAll(response.body());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ArrayList<Tasks>> call, Throwable t) {
                Log.d("testReturn","error tasks ->"+t.getMessage());

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}