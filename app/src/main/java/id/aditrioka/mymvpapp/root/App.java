package id.aditrioka.mymvpapp.root;

import android.app.Application;

import id.aditrioka.mymvpapp.login.LoginModule;

/**
 * Created by aditrioka on 10/22/17.
 */

public class App extends Application {
    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .loginModule(new LoginModule())
                .build();
    }

    public ApplicationComponent getComponent() {
        return component;
    }
}
