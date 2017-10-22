package id.aditrioka.mymvpapp;

import org.junit.Before;
import org.junit.Test;

import id.aditrioka.mymvpapp.login.LoginActivityMVP;
import id.aditrioka.mymvpapp.login.LoginActivityPresenter;
import id.aditrioka.mymvpapp.login.LoginModel;
import id.aditrioka.mymvpapp.login.User;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

/**
 * Created by aditrioka on 10/22/17.
 */


public class PresenterTests {
    LoginActivityMVP.Model mockModel;
    LoginActivityMVP.View mockView;
    LoginActivityPresenter presenter;
    User user;

    @Before
    public void setup() {
        mockModel = mock(LoginActivityMVP.Model.class);
        user = new User("Adi", "Trioka");

//        when(mockModel.getUser()).thenReturn(user);
        mockView = mock(LoginActivityMVP.View.class);

        presenter = new LoginActivityPresenter(mockModel);
        presenter.setView(mockView);
    }

    @Test
    public void noInteractionWithView() {
        presenter.getCurrentUser();

        verifyZeroInteractions(mockView);
    }
}