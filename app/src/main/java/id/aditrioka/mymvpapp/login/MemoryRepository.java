package id.aditrioka.mymvpapp.login;

/**
 * Created by aditrioka on 10/22/17.
 */

public class MemoryRepository implements LoginRepository {
    private User user;

    @Override
    public void setUser(User user) {
        if (user == null) {
            user = getUser();
        }
        this.user = user;
    }

    @Override
    public User getUser() {
        if (user == null) {
            User user = new User("Adi", "Trioka");
            user.setId(0);
            return user;
        } else {
            return this.user;
        }
    }
}
