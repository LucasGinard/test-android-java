package py.com.sodep.sodeptestapp.models;

import com.google.gson.annotations.SerializedName;

public class ModelAuth {
    @SerializedName("username")String username;
    @SerializedName("rememberMe")Boolean rememberMe;
    @SerializedName("password")String password;

    public ModelAuth(String username, String password,Boolean rememberMe){
        this.username = username;
        this.rememberMe = rememberMe;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(Boolean rememberMe) {
        this.rememberMe = rememberMe;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
