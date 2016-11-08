package cn.studyjams.s1.sj65.xiangchao;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by C on 2016/4/29.
 */
public class TableScore extends AppCompatActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table_score);
    }
    int scoreA=0;
    int scoreB=0;
    int bigScoreA=0;
    int bigScoreB=0;
    String smallPoint="";
    String bigPoint="";
    public void displayBigPointTab(int bigScoreA,int bigScoreB){
        TextView scoreView =(TextView) findViewById(R.id.big_point_tab);
        bigPoint=bigScoreA+":"+bigScoreB;
        scoreView.setText(bigPoint);
    }
    public void displayForTeamBTab(int score){
        TextView scoreView = (TextView) findViewById(R.id.team_a_scoreB_tab);
        scoreView.setText(String.valueOf(score));
    }
    public void displayForTeamATab(int score){
        TextView scoreView = (TextView) findViewById(R.id.team_a_scoreA_tab);
        scoreView.setText(String.valueOf(score));
    }
    public  void displaySmallpointTab(int scoreA,int scoreB){
        TextView scoreView = (TextView) findViewById(R.id.small_point_tab);
        smallPoint += scoreA+":"+scoreB+"\n";
        scoreView.setText(smallPoint);
    }

    public void freeThrowATab(View view){
        scoreA = scoreA + 1;
        displayForTeamATab(scoreA);
    }
    public void freeThrowBTab(View view){
        scoreB = scoreB + 1;
        displayForTeamBTab(scoreB);
    }
    public void resetTab(View view){
        scoreA = 0;
        scoreB = 0;
        bigScoreB=0;
        bigScoreA=0;
        smallPoint="";
        displayForTeamBTab(scoreB);
        displayForTeamATab(scoreA);
        displayBigPointTab(bigScoreA,bigScoreB);
        displaySmallpointTab(0,0);
    }

    public void sectionEndTab(View view) {
        if (scoreA > scoreB) {
            bigScoreA = bigScoreA + 1;
        } else {
            if (scoreB > scoreA) {
                bigScoreB = bigScoreB + 1;
            }
        }
        if (scoreA == scoreB) {
            Toast.makeText(TableScore.this,
                    getString(R.string.draw), Toast.LENGTH_SHORT).show();
        }

        displaySmallpointTab(scoreA,scoreB);
        displayBigPointTab(bigScoreA, bigScoreB);
        scoreA = 0;
        scoreB = 0;
        displayForTeamATab(scoreA);
        displayForTeamBTab(scoreB);
    }
    public void sendMailTab(View view) {

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_TEXT, getString(R.string.table_tennis)+"\n"+
                getString(R.string.big_point) + ":\n"
                + "\t" + bigPoint + "\n\n" + smallPoint + "\n");
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.competition_results));

        if (intent.resolveActivity(getPackageManager()) != null) {
            Toast.makeText(TableScore.this, getString(R.string.open_mail), Toast.LENGTH_SHORT).show();
            startActivity(intent);
        } else {
            Toast.makeText(TableScore.this, getString(R.string.open_error), Toast.LENGTH_SHORT).show();
        }
    }
}
