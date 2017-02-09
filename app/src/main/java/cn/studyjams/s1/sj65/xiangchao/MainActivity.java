package cn.studyjams.s1.sj65.xiangchao;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        MenuItem login = menu.findItem(R.id.action_login);
        MenuItem logout = menu.findItem(R.id.action_logout);
        if (Account.checkLoginState()) {
            logout.setVisible(true);
            login.setVisible(false);
        } else {
            login.setVisible(true);
            logout.setVisible(false);
        }
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_login:
                startActivity(new Intent(getApplicationContext(), Account.class));
                break;
            case R.id.action_logout:
                Account.logout();
                Toast.makeText(MainActivity.this, getString(R.string.signout_success), Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_settings:
                break;
            case R.id.action_quit:
                android.os.Process.killProcess(android.os.Process.myPid());
                break;
            default:
                break;
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
