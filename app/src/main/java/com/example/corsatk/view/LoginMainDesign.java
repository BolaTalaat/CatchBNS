package com.example.corsatk.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.percent.PercentLayoutHelper;
import android.support.percent.PercentRelativeLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.corsatk.R;
import com.example.corsatk.controller.MainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginMainDesign extends AppCompatActivity implements View.OnClickListener {

    private TextView tvSignupInvoker;
    private LinearLayout llSignup;
    private TextView tvSigninInvoker;
    private LinearLayout llSignin;
    private Button btnRegister;
    private Button btnSignin;
    private FirebaseAuth.AuthStateListener authListener;
    private EditText etdEmailLogIn, etdPasswordLogin, userNameInNav;
    private EditText inputEmail, inputPassword;
    private Button btnLogIn, btnSignUp, btnResetPassword;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_desgin);
        tvSigninInvoker = (TextView) findViewById(R.id.tvSigninInvoker);
        tvSignupInvoker = (TextView) findViewById(R.id.tvSignupInvoker);
        btnSignin = (Button) findViewById(R.id.btnLogin);
        btnSignin.setOnClickListener(this);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(this);
        llSignin = (LinearLayout) findViewById(R.id.llSignin);
        llSignup = (LinearLayout) findViewById(R.id.llSignup);
        etdEmailLogIn = (EditText) findViewById(R.id.emailLogin);
        etdPasswordLogin = (EditText) findViewById(R.id.password_login);
        btnLogIn = (Button) findViewById(R.id.btnLogin);
        //Store username in sharedPerfernces
        userNameInNav = (EditText) findViewById(R.id.personalUsernameInNav);

        //////////////////////////
        auth = FirebaseAuth.getInstance();

        authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    startActivity(new Intent(LoginMainDesign.this, MainActivity.class));
                    finish();
                }
            }
        };
        inputEmail = (EditText) findViewById(R.id.emailRegister);
        inputPassword = (EditText) findViewById(R.id.passwordRegister);
        /////////////////////////////
        tvSigninInvoker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSigninForm();
            }
        });

        tvSignupInvoker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSignupForm();
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onRegister();
                Animation clockwise = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_right_to_left);
                btnRegister.startAnimation(clockwise);

            }
        });
    }

    private void showSignupForm() {
        PercentRelativeLayout.LayoutParams paramsLogin = (PercentRelativeLayout.LayoutParams) llSignin.getLayoutParams();
        PercentLayoutHelper.PercentLayoutInfo infoLogin = paramsLogin.getPercentLayoutInfo();
        infoLogin.widthPercent = 0.15f;
        llSignin.requestLayout();
        PercentRelativeLayout.LayoutParams paramsSignup = (PercentRelativeLayout.LayoutParams) llSignup.getLayoutParams();
        PercentLayoutHelper.PercentLayoutInfo infoSignup = paramsSignup.getPercentLayoutInfo();
        infoSignup.widthPercent = 0.85f;
        llSignup.requestLayout();
        tvSignupInvoker.setVisibility(View.GONE);
        tvSigninInvoker.setVisibility(View.VISIBLE);
        Animation translate = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.translate_right_to_left);
        llSignup.startAnimation(translate);
        Animation clockwise = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_right_to_left);
        btnRegister.startAnimation(clockwise);

    }

    private void showSigninForm() {
        PercentRelativeLayout.LayoutParams paramsLogin = (PercentRelativeLayout.LayoutParams) llSignin.getLayoutParams();
        PercentLayoutHelper.PercentLayoutInfo infoLogin = paramsLogin.getPercentLayoutInfo();
        infoLogin.widthPercent = 0.85f;
        llSignin.requestLayout();


        PercentRelativeLayout.LayoutParams paramsSignup = (PercentRelativeLayout.LayoutParams) llSignup.getLayoutParams();
        PercentLayoutHelper.PercentLayoutInfo infoSignup = paramsSignup.getPercentLayoutInfo();
        infoSignup.widthPercent = 0.15f;
        llSignup.requestLayout();

        Animation translate = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.translate_left_to_right);
        llSignin.startAnimation(translate);

        tvSignupInvoker.setVisibility(View.VISIBLE);
        tvSigninInvoker.setVisibility(View.GONE);
        Animation clockwise = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_left_to_right);
        btnSignin.startAnimation(clockwise);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btnLogin:
                onLogin();
        }
    }

    private void onRegister() {

        String email = inputEmail.getText().toString().trim();
        String password = inputPassword.getText().toString().trim();

        //Store username in sharedPerfernces
        String username = userNameInNav.getText().toString().trim();
        if (TextUtils.isEmpty(username)) {
            Toast.makeText(this, "Please Enter Your Name", Toast.LENGTH_SHORT).show();
            return;
        }
         else if( username.length()>10){

            Toast.makeText(this, "Please Enter Your Name With Short Length", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            SharedPreferences sp = getSharedPreferences("StoreUserNameNav", MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            editor.putString("USER_NAME", username); //username the user has entered
            editor.commit();

        }

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (password.length() < 6) {
            Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
            return;
        }


        //create user
        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(LoginMainDesign.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {


                        if (task.isSuccessful()) {
                            Toast.makeText(LoginMainDesign.this, "Great You Created One", Toast.LENGTH_SHORT).show();
                        } else

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Toast.makeText(LoginMainDesign.this, "Authentication failed." + task.getException().getMessage(),
                                    Toast.LENGTH_LONG).show();
                            Toast.makeText(LoginMainDesign.this, "Try Again Please", Toast.LENGTH_SHORT).show();
                            //Log.d("tmmmmmmmmmm", "createUserWithEmail:onComplete:" + task.getException());
                        } else {
                            startActivity(new Intent(LoginMainDesign.this, MainActivity.class));
                            finish();
                        }
                    }
                });


    }


    private void onLogin() {
        String email = etdEmailLogIn.getText().toString();
        final String password = etdPasswordLogin.getText().toString();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(), "Enter email address !", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(), "Enter password ! ", Toast.LENGTH_LONG).show();
            return;
        }


        //auth user
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(LoginMainDesign.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (!task.isSuccessful()) {
                    //there was an error
                    if (password.length() < 6) {
                        inputPassword.setError(getString(R.string.minimum_pass));
                        Toast.makeText(LoginMainDesign.this, getString(R.string.minimum_pass), Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(LoginMainDesign.this, getString(R.string.auth_failed), Toast.LENGTH_LONG).show();
                    }

                } else {

                    Intent intent = new Intent(LoginMainDesign.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();
        auth.addAuthStateListener(authListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (authListener != null) {
            auth.removeAuthStateListener(authListener);
        }
    }


}

