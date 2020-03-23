package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class User {
    SimpleIntegerProperty uuid;
    SimpleStringProperty username;
    SimpleStringProperty password;

    public User(Integer uuid, String username, String password) {
        this.uuid = new SimpleIntegerProperty(uuid);
        this.username = new SimpleStringProperty(username);
        this.password = new SimpleStringProperty(password);
    }
    public User(String username, String password) {
        this.username = new SimpleStringProperty(username);
        this.password = new SimpleStringProperty(password);
    }

    public String getPassword(){
        return password.get();
    }

    public void setPassword(String password){
        this.password.set(password);
    }

   public Integer getUuid(){
        return uuid.get();
    }
    public String getUsername() {
        return username.get();
    }
    public void setUsername(String username) {
        this.username.set(username);
    }
}
