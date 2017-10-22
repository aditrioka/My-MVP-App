package id.aditrioka.mymvpapp.login;

/**
 * Created by aditrioka on 10/22/17.
 */

public interface LoginActivityMVP {
    interface View {
        String getFirstName();
        String getLastName();

        void setFirstName(String firstName);
        void setLastName(String lastName);

        void showError();
        void showUserSaved();
        void showUserNotAvailable();
    }

    interface Presenter {
        void setView(View view);
        void submitButtonClicked();
        void getCurrentUser();
    }

    interface Model {
        void saveUser(String firstName, String lastName);
        User getUser();
    }
}
