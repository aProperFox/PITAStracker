package com.carridegames.pitastracker;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

/**
 * Created by Tyler on 10/29/2014.
 */
public class ReviewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        Button button = (Button) findViewById(R.id.next_day);
        button.setText(">");
        button = (Button) findViewById(R.id.previous_day);
        button.setText("<");
    }

}
