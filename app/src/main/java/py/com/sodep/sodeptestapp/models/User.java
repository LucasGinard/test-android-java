package py.com.sodep.sodeptestapp.models;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("id")Integer id;
    @SerializedName("login")String login;
    @SerializedName("firstName")String firstName;
    @SerializedName("lastName")String lastName;
    @SerializedName("email")String email;
    @SerializedName("activated")Boolean activated;
    @SerializedName("langKey")String langKey;
    @SerializedName("imageUrl")String imageUrl;
    @SerializedName("resetDate")String resetDate;
}
