package cn.studyjams.s1.sj65.xiangchao;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            Toast.makeText(MainActivity.this, user.getUid() + " Login successfully", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(MainActivity.this, "Login fail", Toast.LENGTH_LONG).show();
        }
//        mAuthListener = new FirebaseAuth.AuthStateListener(){
//            @Override
//            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth){
//                FirebaseUser user = firebaseAuth.getCurrentUser();
//                if (user != null){
//                    Toast.makeText(MainActivity.this, user.getUid()+" Login successfully", Toast.LENGTH_LONG).show();
//                }else{
//                    Toast.makeText(MainActivity.this, "Login fail", Toast.LENGTH_LONG).show();
//                }
//            }
//        };




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onSoccer (View view){
        startActivity(new Intent(MainActivity.this,SoccerMain.class));
    }
    public void onBasketball (View view){
        startActivity(new Intent(MainActivity.this,BasketballMain.class));
    }
    public void onTable (View view){
        startActivity(new Intent(MainActivity.this,TableMain.class));
    }
    public void onBadminton (View view){
        startActivity(new Intent(MainActivity.this,BadmintonMain.class));
    }
    public void onVolleyball (View view){
        startActivity(new Intent(MainActivity.this, VolleyballMain.class));
    }

}
/**
 *
 *----------Dragon be here!----------/
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┃神兽保佑
 * 　　　　┃　　　┃代码无BUG！
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━━━神兽出没━━━━━━from:coder-pig
 */
