package com.carridegames.pitastracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainMenu extends Activity {

    private int animState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        animState = 0;
    }

    public void onReview(View view) {
        animState = 0;
        Intent i = new Intent(MainMenu.this, ReviewActivity.class);
        startActivity(i);
    }

    public void onAdd(View view) {
        animState = 1;
        Intent i = new Intent(MainMenu.this, AddActivity.class);
        startActivity(i);
    }

    @Override
    public void onPause() {
        switch (animState) {
            case 0:
                this.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
                break;
            case 1:
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                break;
            default:
                break;
        }
        super.onPause();
    }
}
