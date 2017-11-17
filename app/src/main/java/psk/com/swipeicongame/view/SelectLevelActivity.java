package psk.com.swipeicongame.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import psk.com.swipeicongame.R;

public class SelectLevelActivity extends AppCompatActivity {

    Button btnNormalLevel,btnHardLevel,btnChallengingLevel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_level);

        initializeUI();
        setupLevels();
    }

    private void initializeUI() {
        btnNormalLevel=(Button) findViewById(R.id.btnNormalLevel);
        btnHardLevel=(Button) findViewById(R.id.btnHardLevel);
        btnChallengingLevel=(Button) findViewById(R.id.btnChallengingLevel);
    }

    private void setupLevels() {

        btnNormalLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentNormalLevel=new Intent(SelectLevelActivity.this,DetailLevelNormalActivity.class);
                startActivity(intentNormalLevel);
                finish();
            }
        });

        btnHardLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentHardLevel=new Intent(SelectLevelActivity.this,DetailLevelHardActivity.class);
                startActivity(intentHardLevel);
                finish();
            }
        });

        btnChallengingLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentChallengeLevel=new Intent(SelectLevelActivity.this,DetailLevelChallengeActivity.class);
                startActivity(intentChallengeLevel);
                finish();
            }
        });
    }
}
