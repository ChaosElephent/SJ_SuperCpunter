package cn.studyjams.s1.sj65.xiangchao;

import android.app.Application;
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
public class BadmintonScore extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.badminton_score);
    }
        int scoreA=0;
        int scoreB=0;
        int bigScoreA=0;
        int bigScoreB=0;
        String smallPoint="";
        String bigPoint="";
    public void displayBigPointBad(int bigScoreA,int bigScoreB){
        TextView scoreView =(TextView) findViewById(R.id.big_point_bad);
        bigPoint=bigScoreA+":"+bigScoreB;
        scoreView.setText(bigPoint);
    }
    public void displayForTeamBBad(int score){
        TextView scoreView = (TextView) findViewById(R.id.team_a_scoreB_bad);
        scoreView.setText(String.valueOf(score));
    }
    public void displayForTeamABad(int score){
        TextView scoreView = (TextView) findViewById(R.id.team_a_scoreA_bad);
        scoreView.setText(String.valueOf(score));
    }
    public  void displaySmallpointBad(int scoreA,int scoreB){
        TextView scoreView = (TextView) findViewById(R.id.small_point_bad);
        smallPoint += scoreA+":"+scoreB+"\n";
        scoreView.setText(smallPoint);
    }

    public void freeThrowABad(View view){
        scoreA = scoreA + 1;
        displayForTeamABad(scoreA);
    }
    public void freeThrowBBad(View view){
        scoreB = scoreB + 1;
        displayForTeamBBad(scoreB);
    }
    public void resetBad(View view){
        scoreA = 0;
        scoreB = 0;
        bigScoreB=0;
        bigScoreA=0;
        smallPoint="";
        displayForTeamBBad(scoreB);
        displayForTeamABad(scoreA);
        displayBigPointBad(bigScoreA,bigScoreB);
        TextView scoreView = (TextView) findViewById(R.id.small_point_bad);
        scoreView.setText("0:0");
    }

    public void sectionEndBad(View view) {

        if (scoreA > scoreB) {
            bigScoreA = bigScoreA + 1;
        } else {
            if (scoreB > scoreA) {
                bigScoreB = bigScoreB + 1;
            }
        }
        if (scoreA == scoreB) {
            Toast.makeText(BadmintonScore.this,
                    getString(R.string.draw), Toast.LENGTH_SHORT).show();
        }

        displaySmallpointBad(scoreA,scoreB);
        displayBigPointBad(bigScoreA, bigScoreB);
        scoreA = 0;
        scoreB = 0;
        displayForTeamABad(scoreA);
        displayForTeamBBad(scoreB);
    }
    public void sendMailBad(View view) {

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_TEXT, getString(R.string.badminton)+"\n"+
                getString(R.string.big_point) + ":\n"
                + "\t" + bigPoint + "\n\n" + smallPoint + "\n");
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.competition_results));

        if (intent.resolveActivity(getPackageManager()) != null) {
            Toast.makeText(BadmintonScore.this, getString(R.string.open_mail), Toast.LENGTH_SHORT).show();
            startActivity(intent);
        } else {
            Toast.makeText(BadmintonScore.this, getString(R.string.open_error), Toast.LENGTH_SHORT).show();
        }
    }



}
