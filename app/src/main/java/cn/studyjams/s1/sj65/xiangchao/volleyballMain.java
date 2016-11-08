package cn.studyjams.s1.sj65.xiangchao;

/**
 * Created by C on 2016/4/30.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class volleyballMain extends AppCompatActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.volleyball_subjuect);
    }
    public void scoreVol (View view) {
        startActivity(new Intent(volleyballMain.this, volleyballScore.class));
    }
    public void introduceVol (View view){
        startActivity(new Intent(volleyballMain.this, volleyballInt.class));
    }
}