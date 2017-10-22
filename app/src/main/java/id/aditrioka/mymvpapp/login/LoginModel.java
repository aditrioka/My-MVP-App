package id.aditrioka.mymvpapp.login;

/**
 * Created by aditrioka on 10/22/17.
 */

public class LoginModel implements LoginActivityMVP.Model {
    private LoginRepository repository;

    public LoginModel(LoginRepository repository) {
        this.repository = repository;
    }

    @Override
    public void saveUser(String firstName, String lastName) {
        repository.setUser(new User(firstName, lastName));
    }

    @Override
    public User getUser() {
        return repository.getUser();
    }
}
