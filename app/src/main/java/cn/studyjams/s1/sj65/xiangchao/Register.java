package cn.studyjams.s1.sj65.xiangchao;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

/**
 * Created by C on 2016/12/22.
 */

public class Register extends Account {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.regester);
    }

    public void accountRegisterInput(View v) {
        EditText email = (EditText) findViewById(R.id.account_set_email);
        EditText password1 = (EditText) findViewById(R.id.account_set_password);
        EditText password2 = (EditText) findViewById(R.id.account_set2_password);
        if (email.getText().toString().matches(EMAIL_FORMAT)) {
            if (password1.getText().toString().equals(password2.getText().toString())) {
                mAuth.createUserWithEmailAndPassword(email.getText().toString(),
                        password1.getText().toString())
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Log.d("Account", "createUserWithEmail: onComplete:" + task.isSuccessful());
                                if (!task.isSuccessful()) {
                                    Toast.makeText(Register.this, getString(R.string.net_error)
                                            , Toast.LENGTH_SHORT).show();
                                    Register.this.finish();
                                }
                            }
                        });
            } else {
                Toast.makeText(Register.this, getString(R.string.invalid_password), Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(Register.this, getString(R.string.invalid_email), Toast.LENGTH_SHORT).show();
        }
    }


}
