package govender.kevashan.com.JournalApp.signin.viewmodel;

import android.content.Intent;

import com.firebase.ui.auth.IdpResponse;

import govender.kevashan.com.JournalApp.signin.view.ISignInView;

import static android.app.Activity.RESULT_OK;

public class SignInViewModel {
    private final String TAG = SignInViewModel.class.getSimpleName();

    private ISignInView view;

    public SignInViewModel(ISignInView view) {
        this.view = view;
    }

    public void checkSignInResult(int requestCode, int resultCode, Intent data) {
        int RC_SIGN_IN = 123;
        if(requestCode == RC_SIGN_IN){
            IdpResponse response = IdpResponse.fromResultIntent(data);

            if(resultCode == RESULT_OK){
                view.launchHomeScreen();
            } else {
                view.showErrorToast();
            }
        }
    }
}
