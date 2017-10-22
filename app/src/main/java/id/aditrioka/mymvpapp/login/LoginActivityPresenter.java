package id.aditrioka.mymvpapp.login;

import android.support.annotation.Nullable;

/**
 * Created by aditrioka on 10/22/17.
 */

public class LoginActivityPresenter implements LoginActivityMVP.Presenter {
    @Nullable
    private LoginActivityMVP.View view;
    private LoginActivityMVP.Model model;

    public LoginActivityPresenter(LoginActivityMVP.Model model) {
        this.model = model;
    }

    @Override
    public void setView(LoginActivityMVP.View view) {
        this.view = view;
    }

    @Override
    public void submitButtonClicked() {
        if (view != null) {
            if (view.getFirstName().trim().equals("") ||
                    view.getLastName().trim().equals("")) {
                view.showError();
            } else {
                model.saveUser(view.getFirstName(), view.getLastName());
                view.showUserSaved();
            }
        }
    }

    @Override
    public void getCurrentUser() {
        User user = model.getUser();

        if (user == null) {
            if (view != null) {
                view.showUserNotAvailable();
            }
        } else {
            if (view != null) {
                view.setFirstName(user.getFirstName());
                view.setLastName(user.getLastName());
            }
        }
    }
}
