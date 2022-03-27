package py.com.sodep.sodeptestapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import py.com.sodep.sodeptestapp.R;
import py.com.sodep.sodeptestapp.models.Tasks;
import py.com.sodep.sodeptestapp.network.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    private ArrayList<Tasks> tasksList;
    private ApiInterface apiInterface;

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_task, parent, false);
        return new TaskViewHolder(itemView);
    }

    public TaskAdapter(ArrayList<Tasks> list,ApiInterface Api) {
        this.tasksList = list;
        this.apiInterface = Api;
    }

    @Override
    public void onBindViewHolder(TaskViewHolder holder, int position) {
        holder.title.setText(tasksList.get(position).getTitle());
        holder.btnEdit.setOnClickListener(view -> {
            Call call = apiInterface.deleteTask(tasksList.get(position).getId().toString());
            call.enqueue(new Callback() {
                @Override
                public void onResponse(Call call, Response response) {
                    tasksList.remove(position);
                    notifyDataSetChanged();
                }

                @Override
                public void onFailure(Call call, Throwable t) {

                }
            });
        });
    }

    @Override
    public int getItemCount() {
        return tasksList.size();
    }

    public class TaskViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ImageView btnEdit;

        public TaskViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.tvTitle);
            btnEdit = view.findViewById(R.id.btnEdit);
        }
    }
}
