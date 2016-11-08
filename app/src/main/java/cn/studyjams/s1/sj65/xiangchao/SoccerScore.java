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
public class SoccerScore extends AppCompatActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.soccer_score);
    }
    int scoreA=0;
    int scoreB=0;
    int bigScoreA=0;
    int bigScoreB=0;
    String smallPoint="";
    String bigPoint="";
    public void displayBigPointSoc(int bigScoreA,int bigScoreB){
        TextView scoreView =(TextView) findViewById(R.id.big_point_soc);
        bigPoint=bigScoreA+":"+bigScoreB;
        scoreView.setText(bigPoint);
    }
    public void displayForTeamBSoc(int score){
        TextView scoreView = (TextView) findViewById(R.id.team_a_scoreB_soc);
        scoreView.setText(String.valueOf(score));
    }
    public void displayForTeamASoc(int score){
        TextView scoreView = (TextView) findViewById(R.id.team_a_scoreA_soc);
        scoreView.setText(String.valueOf(score));
    }
    public  void displaySmallpointSoc(int scoreA,int scoreB){
        TextView scoreView = (TextView) findViewById(R.id.small_point_soc);
        smallPoint += scoreA+":"+scoreB+"\n";
        scoreView.setText(smallPoint);
    }

    public void freeThrowASoc(View view){
        scoreA = scoreA + 1;
        displayForTeamASoc(scoreA);
    }
    public void freeThrowBSoc(View view){
        scoreB = scoreB + 1;
        displayForTeamBSoc(scoreB);
    }
    public void resetSoc(View view){
        scoreA = 0;
        scoreB = 0;
        bigScoreB=0;
        bigScoreA=0;
        smallPoint="";
        displayForTeamBSoc(scoreB);
        displayForTeamASoc(scoreA);
        displayBigPointSoc(bigScoreA,bigScoreB);
        TextView scoreView = (TextView) findViewById(R.id.small_point_soc);
        scoreView.setText("0:0");
    }

    public void sectionEndSoc(View view) {

        if (scoreA > scoreB) {
            bigScoreA = bigScoreA + 1;
        } else {
            if (scoreB > scoreA) {
                bigScoreB = bigScoreB + 1;
            }
        }
        if (scoreA == scoreB) {
            Toast.makeText(SoccerScore.this,
                    getString(R.string.draw), Toast.LENGTH_SHORT).show();
        }

        displaySmallpointSoc(scoreA,scoreB);
        displayBigPointSoc(bigScoreA, bigScoreB);
        scoreA = 0;
        scoreB = 0;
        displayForTeamASoc(scoreA);
        displayForTeamBSoc(scoreB);
    }
    public void sendMailSoc(View view) {

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_TEXT, getString(R.string.badminton)+"\n"+
                getString(R.string.big_point) + ":\n"
                + "\t" + bigPoint + "\n\n" + smallPoint + "\n");
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.competition_results));

        if (intent.resolveActivity(getPackageManager()) != null) {
            Toast.makeText(SoccerScore.this, getString(R.string.open_mail), Toast.LENGTH_SHORT).show();
            startActivity(intent);
        } else {
            Toast.makeText(SoccerScore.this, getString(R.string.open_error), Toast.LENGTH_SHORT).show();
        }}
}
