package cn.studyjams.s1.sj65.xiangchao;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


/**
 * Created by C on 2016/12/21.
 */

public class Account extends AppCompatActivity {

    static final String EMAIL_FORMAT = "\\w+\\x40\\w+\\x2e\\w+";
    private static FirebaseUser user;
    public FirebaseAuth mAuth;
    public FirebaseAuth.AuthStateListener mAuthListener;

    public static boolean checkLoginState() {
        user = FirebaseAuth.getInstance().getCurrentUser();
        return user != null;
    }

    public static boolean logout() {
        FirebaseAuth.getInstance().signOut();
        return true;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    //user is signed in
                    Log.d("Account", "onAuthStateChanged:signed_in" + user.getUid());
                } else {
                    //user is signed out
                    Log.d("Account", "onAuthStateChanged:signed_out");
                }
            }
        };
    }

    public void accountLogin(View v) {
        EditText email = (EditText) findViewById(R.id.account_email);
        EditText password = (EditText) findViewById(R.id.account_password);
        mAuth.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d("Account", "signInWithEmail:onComplete:" + task.isSuccessful());
                        if (!task.isSuccessful()) {
                            Log.w("Account", "signInWithEmail:failed", task.getException());
                            Toast.makeText(Account.this, R.string.auth_fail,
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            Account.this.finish();
                        }
                    }
                });
    }

    public void accountRegister(View v) {
        startActivity(new Intent(Account.this, Register.class));
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }


}
