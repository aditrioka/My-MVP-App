package id.aditrioka.mymvpapp;

import org.junit.Before;
import org.junit.Test;

import id.aditrioka.mymvpapp.login.LoginActivityMVP;
import id.aditrioka.mymvpapp.login.LoginActivityPresenter;
import id.aditrioka.mymvpapp.login.LoginModel;
import id.aditrioka.mymvpapp.login.User;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
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

//    @Test
//    public void noInteractionWithView() {
//        presenter.getCurrentUser();
//
//        verifyZeroInteractions(mockView);
//    }

    @Test
    public void loadTheUserFromTheRepositoryWhenValidUserIsPresent() {
        when(mockModel.getUser()).thenReturn(user);
        presenter.getCurrentUser();

        // verify model interactions
        verify(mockModel, times(1)).getUser();

        // verify view interactions
        verify(mockView, times(1)).setFirstName("Adi");
        verify(mockView, times(1)).setLastName("Trioka");
        verify(mockView, never()).showUserNotAvailable();
    }

    @Test
    public void shouldShowErrorMessageWhenUserIsNull() {
        when(mockModel.getUser()).thenReturn(null);
        presenter.getCurrentUser();

        // verify model interactions
        verify(mockModel, times(1)).getUser();

        // verify view interactions
        verify(mockView, never()).setFirstName("Adi");
        verify(mockView, never()).setLastName("Trioka");
        verify(mockView, times(1)).showUserNotAvailable();
    }

    @Test
    public void shouldShowErrorMessageWhenFieldAreEmpty() {
        // set up the view mock
        when(mockView.getFirstName()).thenReturn("");
        presenter.submitButtonClicked();

        verify(mockView, times(1)).getFirstName();
        verify(mockView, never()).getLastName();
        verify(mockView, times(1)).showError();

        // tell mockView to return a value for first name and and an empty last name
        when(mockView.getFirstName()).thenReturn("Adi");
        when(mockView.getLastName()).thenReturn("");

        presenter.submitButtonClicked();

        verify(mockView, times(2)).getFirstName(); // called now and called before
        verify(mockView, times(1)).getLastName(); // called only once
        verify(mockView, times(2)).showError(); //called now and called before
    }

    @Test
    public void shouldBeAbleToSaveAValidUser() {
        when(mockView.getFirstName()).thenReturn("Adi");
        when(mockView.getLastName()).thenReturn("Trioka");

        presenter.submitButtonClicked();

        // called two times in submitButtonClicked
        verify(mockView, times(2)).getFirstName();
        verify(mockView, times(2)).getLastName();

        // make sure the repository saved the user
        verify(mockModel, times(1)).saveUser("Adi", "Trioka");

        // make sure the view show message
        verify(mockView, times(1)).showUserSaved();
    }
}
