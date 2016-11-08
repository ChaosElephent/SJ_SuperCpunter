package cn.studyjams.s1.sj65.xiangchao;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by C on 2016/4/30.
 */
public class volleyballScore extends AppCompatActivity {
    int scoreA = 0;
    int scoreB = 0;
    int bigScoreA = 0;
    int bigScoreB = 0;
    String smallPoint = "";
    String bigPoint = "";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.volleyball_score);
    }

    public void displayBigPointvol(int bigScoreA, int bigScoreB) {
        TextView scoreView = (TextView) findViewById(R.id.big_point_vol);
        bigPoint = bigScoreA + ":" + bigScoreB;
        scoreView.setText(bigPoint);
    }

    public void displayForTeamBvol(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_scoreB_vol);
        scoreView.setText(String.valueOf(score));
    }

    public void displayForTeamAvol(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_scoreA_vol);
        scoreView.setText(String.valueOf(score));
    }

    public void displaySmallpointvol(int scoreA, int scoreB) {
        TextView scoreView = (TextView) findViewById(R.id.small_point_vol);
        smallPoint += scoreA + ":" + scoreB + "\n";
        scoreView.setText(smallPoint);
    }

    public void freeThrowAvol(View view) {
        scoreA = scoreA + 1;
        displayForTeamAvol(scoreA);
    }

    public void freeThrowBvol(View view) {
        scoreB = scoreB + 1;
        displayForTeamBvol(scoreB);
    }

    public void resetvol(View view) {
        scoreA = 0;
        scoreB = 0;
        bigScoreB = 0;
        bigScoreA = 0;
        smallPoint = "";
        displayForTeamBvol(scoreB);
        displayForTeamAvol(scoreA);
        displayBigPointvol(bigScoreA, bigScoreB);
        TextView scoreView = (TextView) findViewById(R.id.small_point_vol);
        scoreView.setText("0:0");
    }

    public void sectionEndvol(View view) {

        if (scoreA > scoreB) {
            bigScoreA = bigScoreA + 1;
        } else {
            if (scoreB > scoreA) {
                bigScoreB = bigScoreB + 1;
            }
        }
        if (scoreA == scoreB) {
            Toast.makeText(volleyballScore.this,
                    getString(R.string.draw), Toast.LENGTH_SHORT).show();
        }

        displaySmallpointvol(scoreA, scoreB);
        displayBigPointvol(bigScoreA, bigScoreB);
        scoreA = 0;
        scoreB = 0;
        displayForTeamAvol(scoreA);
        displayForTeamBvol(scoreB);
    }

    public void sendMailvol(View view) {

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_TEXT, getString(R.string.volleyball) + "\n" +
                getString(R.string.big_point) + ":\n"
                + "\t" + bigPoint + "\n\n" + smallPoint + "\n");
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.competition_results));

        if (intent.resolveActivity(getPackageManager()) != null) {
            Toast.makeText(volleyballScore.this, getString(R.string.open_mail), Toast.LENGTH_SHORT).show();
            startActivity(intent);
        } else {
            Toast.makeText(volleyballScore.this, getString(R.string.open_error), Toast.LENGTH_SHORT).show();
        }
    }
}