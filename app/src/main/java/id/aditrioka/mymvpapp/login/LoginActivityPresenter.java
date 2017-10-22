package id.aditrioka.mymvpapp.login;

/**
 * Created by aditrioka on 10/22/17.
 */

public class LoginActivityPresenter implements LoginActivityMVP.Presenter {
    private LoginActivityMVP.View view;
    private LoginActivityMVP.Model model;

    public LoginActivityPresenter(LoginActivityMVP.Model model) {
        this.model = model;
    }

    @Override
    public void setView(LoginActivityMVP.View view) {

    }

    @Override
    public void submitButtonClicked() {

    }

    @Override
    public void getCurrentUser() {

    }
}
