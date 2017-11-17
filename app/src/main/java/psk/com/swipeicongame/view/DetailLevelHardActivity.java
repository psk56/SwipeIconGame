package psk.com.swipeicongame.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import psk.com.swipeicongame.R;

public class DetailLevelHardActivity extends AppCompatActivity {

    RelativeLayout btnHardLevel1,btnHardLevel2,btnHardLevel3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_level_hard);

        initializeUI();
        setupLevel();
    }

    private void initializeUI() {
        btnHardLevel1=(RelativeLayout) findViewById(R.id.btnHardLevel1);
        btnHardLevel2=(RelativeLayout) findViewById(R.id.btnHardLevel2);
        btnHardLevel3=(RelativeLayout) findViewById(R.id.btnHardLevel3);
    }

    private void setupLevel() {
        btnHardLevel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentPlayGame=new Intent(DetailLevelHardActivity.this,PlayGameActivity.class);
                intentPlayGame.putExtra("level_icon",getString(R.string.icon_hard_level1));
                startActivity(intentPlayGame);
                finish();
            }
        });

        btnHardLevel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentPlayGame=new Intent(DetailLevelHardActivity.this,PlayGameActivity.class);
                intentPlayGame.putExtra("level_icon",getString(R.string.icon_hard_level2));
                startActivity(intentPlayGame);
                finish();
            }
        });

        btnHardLevel3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentPlayGame=new Intent(DetailLevelHardActivity.this,PlayGameActivity.class);
                intentPlayGame.putExtra("level_icon",getString(R.string.icon_hard_level3));
                startActivity(intentPlayGame);
                finish();
            }
        });
    }
}
