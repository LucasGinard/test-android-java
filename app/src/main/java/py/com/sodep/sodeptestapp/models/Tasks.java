package py.com.sodep.sodeptestapp.models;

import com.google.gson.annotations.SerializedName;

public class Tasks {
    @SerializedName("id")Integer id;
    @SerializedName("title")String title;
    @SerializedName("description")String description;
    @SerializedName("favorite")Boolean favorite;
    @SerializedName("user")User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
