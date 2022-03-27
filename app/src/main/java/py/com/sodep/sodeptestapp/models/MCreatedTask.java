package py.com.sodep.sodeptestapp.models;

import com.google.gson.annotations.SerializedName;

public class MCreatedTask {
    @SerializedName("title")String title;
    @SerializedName("description")String description;
    @SerializedName("favorite")Boolean favorite;

    public MCreatedTask(String title,String description,Boolean isFavorite){
        this.title = title;
        this.description = description;
        this.favorite = isFavorite;
    }
}