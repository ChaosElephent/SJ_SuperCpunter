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
public class TableMain extends AppCompatActivity {
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table_tennis_subject);
//        TypedArray Theme = obtainStyledAttributes(R.style.AppTheme);
    }
//    public void onBackTab (View view){
//        startActivity(new Intent(TableMain.this,MainActivity.class));
//    }
    public void scoreTab (View view) {
        startActivity(new Intent(TableMain.this,TableScore.class));
    }
    public void introduceTab(View view){
        startActivity(new Intent(TableMain.this, TableInt .class));
    }
}
