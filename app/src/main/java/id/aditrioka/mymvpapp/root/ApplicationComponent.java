package id.aditrioka.mymvpapp.root;

import javax.inject.Singleton;

import dagger.Component;
import id.aditrioka.mymvpapp.login.LoginActivity;
import id.aditrioka.mymvpapp.login.LoginModule;

/**
 * Created by aditrioka on 10/22/17.
 */

@Singleton
@Component(modules = {ApplicationModule.class, LoginModule.class})
public interface ApplicationComponent {
    void inject(LoginActivity target);
}
