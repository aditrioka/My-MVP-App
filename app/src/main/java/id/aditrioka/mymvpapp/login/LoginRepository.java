package id.aditrioka.mymvpapp.login;

/**
 * Created by aditrioka on 10/22/17.
 */

public interface LoginRepository {
    void setUser(User user);
    User getUser();
}
