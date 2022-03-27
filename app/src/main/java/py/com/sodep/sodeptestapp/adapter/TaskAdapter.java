package py.com.sodep.sodeptestapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import py.com.sodep.sodeptestapp.R;
import py.com.sodep.sodeptestapp.models.Tasks;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    private ArrayList<Tasks> tasksList;

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_task, parent, false);
        return new TaskViewHolder(itemView);
    }

    public TaskAdapter(ArrayList<Tasks> list) {
        this.tasksList = list;
    }

    @Override
    public void onBindViewHolder(TaskViewHolder holder, int position) {
        holder.title.setText(tasksList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return tasksList.size();
    }

    public class TaskViewHolder extends RecyclerView.ViewHolder {
        public TextView title;

        public TaskViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.tvTitle);
        }
    }
}
