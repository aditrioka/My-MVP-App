package id.aditrioka.mymvpapp.root;

import javax.inject.Singleton;

import dagger.Component;
import id.aditrioka.mymvpapp.login.LoginActivity;

/**
 * Created by aditrioka on 10/22/17.
 */

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {
    void inject(LoginActivity target);
}
