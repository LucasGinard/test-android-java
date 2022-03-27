package py.com.sodep.sodeptestapp;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import py.com.sodep.sodeptestapp.models.MCreatedTask;
import py.com.sodep.sodeptestapp.network.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DialogTask extends AlertDialog {

    private MaterialButton dialogButton;
    private TextInputLayout tvTitle;
    private TextInputLayout tvDescription;
    private TextInputEditText etDescripcion;
    private ApiInterface apiInterface;
    private String title;
    private String description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customview);
        tvTitle = findViewById(R.id.tvTitleDialog);
        tvDescription = findViewById(R.id.tvDescrition);
        dialogButton = findViewById(R.id.buttonOk);
        etDescripcion = findViewById(R.id.etDescription);
        configureOnClickListerner();
    }

    private void configureOnClickListerner() {
        this.getWindow().clearFlags(
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE |
                        WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
        dialogButton.setOnClickListener(view -> {
            title = tvTitle.getEditText().getText().toString();
            description = tvTitle.getEditText().getText().toString();
            Call<MCreatedTask> call = apiInterface.postTasks(new MCreatedTask(title,description,true));
            call.enqueue(new Callback<MCreatedTask>() {
                @Override
                public void onResponse(Call<MCreatedTask> call, Response<MCreatedTask> response) {
                    dismiss();
                }

                @Override
                public void onFailure(Call<MCreatedTask> call, Throwable t) {
                    dismiss();
                }
            });

        });
    }


    public DialogTask(Context context, ApiInterface apiInterface) {
        super(context);
        this.apiInterface = apiInterface;
    }

    protected DialogTask(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    protected DialogTask(Context context, int themeResId) {
        super(context, themeResId);
    }

}
