package id.aditrioka.mymvpapp.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import id.aditrioka.mymvpapp.R;
import id.aditrioka.mymvpapp.root.App;

public class LoginActivity extends AppCompatActivity implements LoginActivityMVP.View {
    private static final String TAG = LoginActivity.class.getSimpleName();

    private EditText etFirstName;
    private EditText etLastName;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ((App) getApplication()).getComponent().inject(this);

        initializeViews();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public String getFirstName() {
        return etFirstName.getText().toString();
    }

    @Override
    public String getLastName() {
        return etLastName.getText().toString();
    }

    @Override
    public void setFirstName(String firstName) {
        etFirstName.setText(firstName);
    }

    @Override
    public void setLastName(String lastName) {
        etLastName.setText(lastName);
    }

    @Override
    public void showError() {
        Toast.makeText(this, R.string.msg_error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showUserSaved() {
        Toast.makeText(this, getString(R.string.msg_user_saved), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showUserNotAvailable() {
        Toast.makeText(this, getString(R.string.msg_user_not_available), Toast.LENGTH_SHORT).show();
    }

    private void initializeViews() {
        etFirstName = (EditText) findViewById(R.id.et_first_name);
        etLastName = (EditText) findViewById(R.id.et_last_name);
        btnSubmit = (Button) findViewById(R.id.btn_submit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "button clicked");
                Log.d(TAG, "first name: " + etFirstName.getText());
                Log.d(TAG, "last name: " + etLastName.getText());
            }
        });
    }
}