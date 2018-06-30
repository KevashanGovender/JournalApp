package govender.kevashan.com.JournalApp.signin.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;

import java.util.Arrays;
import java.util.List;

import govender.kevashan.com.JournalApp.signin.viewmodel.SignInViewModel;
import govender.kevashan.com.journalapp3.R;

public class LaunchActivity extends AppCompatActivity implements ISignInView {

    final int RC_SIGN_IN = 123;
    private SignInViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.loginBtn);
        Button signOutBtn = findViewById(R.id.logoutBtn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                List<AuthUI.IdpConfig> providers = Arrays.asList(
                        new AuthUI.IdpConfig.GoogleBuilder().build());

                startActivityForResult(
                        AuthUI.getInstance()
                                .createSignInIntentBuilder()
                                .setAvailableProviders(providers)
                                .build(),
                        RC_SIGN_IN);

            }
        });

        signOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AuthUI.getInstance()
                        .signOut(getApplicationContext());
            }
        });

        viewModel = new SignInViewModel(this);

    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        viewModel.checkSignInResult(requestCode, resultCode, data);
    }

    @Override
    public void launchHomeScreen() {
        Toast.makeText(this, "Sign in successful", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErrorToast() {
        Toast.makeText(this, "Sign in error. Please try again", Toast.LENGTH_SHORT).show();
    }
}
