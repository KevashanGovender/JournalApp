package govender.kevashan.com.JournalApp.signin.viewmodel;

import android.content.Intent;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import govender.kevashan.com.JournalApp.signin.view.ISignInView;

import static org.mockito.Mockito.verify;

public class SignInViewModelTest {

    @Mock
    private ISignInView view;
    @Mock
    private Intent data;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void onSuccessfulSignInShouldLaunchHomeActivity(){
        SignInViewModel viewModel = new SignInViewModel(view);

        int requestCode = 123;
        int resultCode = -1;

        viewModel.checkSignInResult(requestCode, resultCode, data);

        verify(view).launchHomeScreen();
    }

    @Test
    public void onErrorSignInShouldUpdateView(){
        SignInViewModel viewModel = new SignInViewModel(view);

        int requestCode = 123;
        int resultCode = 1;

        viewModel.checkSignInResult(requestCode, resultCode, data);

        verify(view).showErrorToast();
    }
}
