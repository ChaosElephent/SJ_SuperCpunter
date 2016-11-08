package cn.studyjams.s1.sj65.xiangchao;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by C on 2016/4/29.
 */
public class BasketballScore extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basketball_score);
    }

    int scoreA = 0;
    int scoreB = 0;
    int bigScoreA = 0;
    int bigScoreB = 0;
    String smallPoint="";
    String bigPoint="";

    public void displayBigPointBas(int bigScoreA, int bigScoreB) {
        TextView scoreView = (TextView) findViewById(R.id.big_point_bas);
        bigPoint = bigScoreA + ":" + bigScoreB;
        scoreView.setText(bigPoint);
    }

    public void displayForTeamBBas(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_scoreB_bas);
        scoreView.setText(String.valueOf(score));
    }

    public void displayForTeamABas(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_scoreA_bas);
        scoreView.setText(String.valueOf(score));
    }

    public void displaySmallpointBas(int scoreA, int scoreB) {
        TextView scoreView = (TextView) findViewById(R.id.small_point_bas);
        smallPoint += scoreA + ":" + scoreB+"\n";
        scoreView.setText(smallPoint);
    }

    public void add3PointsABas(View view) {
        scoreA = scoreA + 3;
        displayForTeamABas(scoreA);
    }

    public void add2PointsABas(View view) {
        scoreA = scoreA + 2;
        displayForTeamABas(scoreA);
    }

    public void freeThrowABas(View view) {
        scoreA = scoreA + 1;
        displayForTeamABas(scoreA);
    }

    public void add3PointsBBas(View view) {
        scoreB = scoreB + 3;
        displayForTeamBBas(scoreB);
    }

    public void add2PointsBBas(View view) {
        scoreB = scoreB + 2;
        displayForTeamBBas(scoreB);
    }

    public void freeThrowBBas(View view) {
        scoreB = scoreB + 1;
        displayForTeamBBas(scoreB);
    }

    public void resetBas(View view) {
        scoreA = 0;
        scoreB = 0;
        bigScoreB = 0;
        bigScoreA = 0;
        smallPoint = "";
        displayForTeamBBas(scoreB);
        displayForTeamABas(scoreA);
        displayBigPointBas(bigScoreA, bigScoreB);
        displaySmallpointBas(0, 0);
    }

    public void sectionEndBas(View view) {
        displaySmallpointBas(scoreA, scoreB);
        if (scoreA > scoreB) {
            bigScoreA = bigScoreA + 1;
        } else {
            if (scoreB > scoreA) {
                bigScoreB = bigScoreB + 1;
            }
        }
        if (scoreA == scoreB) {
            Toast.makeText(BasketballScore.this,
                    getString(R.string.draw), Toast.LENGTH_SHORT).show();
            return;
        }
        scoreA = 0;
        scoreB = 0;
        displayForTeamABas(scoreA);
        displayForTeamBBas(scoreB);
        displayBigPointBas(bigScoreA, bigScoreB);
    }

    public void sendMailBas(View view) {

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_TEXT, getString(R.string.basketball)+"\n"+
                getString(R.string.big_point) + ":\n"
                + "\t" + bigPoint + "\n\n" + smallPoint + "\n");
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.competition_results));

        if (intent.resolveActivity(getPackageManager()) != null) {
            Toast.makeText(BasketballScore.this, getString(R.string.open_mail), Toast.LENGTH_SHORT).show();
            startActivity(intent);
        } else {
            Toast.makeText(BasketballScore.this, getString(R.string.open_error), Toast.LENGTH_SHORT).show();
        }
    }

}
