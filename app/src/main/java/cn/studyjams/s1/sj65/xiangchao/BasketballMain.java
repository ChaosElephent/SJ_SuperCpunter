package cn.studyjams.s1.sj65.xiangchao;

import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by C on 2016/4/27.
 */
public class BasketballMain extends AppCompatActivity {
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basketball_subject);
//        TypedArray Theme = obtainStyledAttributes(R.style.AppTheme);
    }
//    public void onBackBas (View view){
//        startActivity(new Intent(BasketballMain.this,MainActivity.class));
//    }
    public void scoreBas (View view) {
        startActivity(new Intent(BasketballMain.this, BasketballScore.class));
    }
    public void introduceBas (View view){
        startActivity(new Intent(BasketballMain.this, BasketballInt .class));
    }
}
