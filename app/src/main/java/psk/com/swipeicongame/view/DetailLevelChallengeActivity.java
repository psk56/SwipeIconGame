package psk.com.swipeicongame.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import psk.com.swipeicongame.R;

public class DetailLevelChallengeActivity extends AppCompatActivity {
    RelativeLayout btnChallengeLevel1, btnChallengeLevel2, btnChallengeLevel3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_level_challenge);

        initializeUI();
        setupLevel();
    }

    private void initializeUI() {
        btnChallengeLevel1 = (RelativeLayout) findViewById(R.id.btnChallengeLevel1);
        btnChallengeLevel2 = (RelativeLayout) findViewById(R.id.btnChallengeLevel2);
        btnChallengeLevel3 = (RelativeLayout) findViewById(R.id.btnChallengeLevel3);
    }

    private void setupLevel() {

        btnChallengeLevel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentPlayGame = new Intent(DetailLevelChallengeActivity.this, PlayGameActivity.class);
                intentPlayGame.putExtra("level_icon", getString(R.string.icon_challenge_level1));
                startActivity(intentPlayGame);
                finish();
            }
        });

        btnChallengeLevel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentPlayGame = new Intent(DetailLevelChallengeActivity.this, PlayGameActivity.class);
                intentPlayGame.putExtra("level_icon", getString(R.string.icon_challenge_level2));
                startActivity(intentPlayGame);
                finish();
            }
        });

        btnChallengeLevel3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentPlayGame = new Intent(DetailLevelChallengeActivity.this, PlayGameActivity.class);
                intentPlayGame.putExtra("level_icon", getString(R.string.icon_challenge_level3));
                startActivity(intentPlayGame);
                finish();
            }
        });
    }
}
