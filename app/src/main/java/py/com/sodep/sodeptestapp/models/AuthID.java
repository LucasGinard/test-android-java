package py.com.sodep.sodeptestapp.models;

import com.google.gson.annotations.SerializedName;

public class AuthID {
    @SerializedName("id_token")String id_token;
    public String getId_token() {
        return id_token;
    }
    public void setId_token(String id_token) {
        this.id_token = id_token;
    }
}