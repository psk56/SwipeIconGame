package psk.com.swipeicongame.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import psk.com.swipeicongame.R;

public class DetailLevelNormalActivity extends AppCompatActivity {

    RelativeLayout btnNormalLevel1,btnNormalLevel2,btnNormalLevel3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_level_normal);

        initializeUI();
        setupLevel();
    }


    private void initializeUI() {
        btnNormalLevel1=(RelativeLayout) findViewById(R.id.btnNormalLevel1);
        btnNormalLevel2=(RelativeLayout) findViewById(R.id.btnNormalLevel2);
        btnNormalLevel3=(RelativeLayout) findViewById(R.id.btnNormalLevel3);
    }

    private void setupLevel() {

        btnNormalLevel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentPlayGame=new Intent(DetailLevelNormalActivity.this,PlayGameActivity.class);
                intentPlayGame.putExtra("level_icon",getString(R.string.icon_normal_level1));
                startActivity(intentPlayGame);
                finish();
            }
        });

        btnNormalLevel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentPlayGame=new Intent(DetailLevelNormalActivity.this,PlayGameActivity.class);
                intentPlayGame.putExtra("level_icon",getString(R.string.icon_normal_level2));
                startActivity(intentPlayGame);
                finish();
            }
        });

        btnNormalLevel3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentPlayGame=new Intent(DetailLevelNormalActivity.this,PlayGameActivity.class);
                intentPlayGame.putExtra("level_icon",getString(R.string.icon_normal_level3));
                startActivity(intentPlayGame);
                finish();
            }
        });
    }

}
