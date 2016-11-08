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
public class SoccerMain extends AppCompatActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.soccer_subject);
//        TypedArray Theme = obtainStyledAttributes(R.style.AppTheme);
    }
//    public void onBackSoc (View view){
//        startActivity(new Intent(SoccerMain.this,MainActivity.class));
//    }
    public void scoreSoc (View view) {
        startActivity(new Intent(SoccerMain.this, SoccerScore.class));
    }
    public void introduceSoc (View view){
        startActivity(new Intent(SoccerMain.this, SoccerInt.class));
    }
}
