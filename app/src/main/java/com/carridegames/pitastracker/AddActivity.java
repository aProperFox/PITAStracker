package com.carridegames.pitastracker;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Tyler on 10/29/2014.
 */
public class AddActivity extends Activity {

    Database.DataEntry.DatabaseHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        mDbHelper = new Database.DataEntry.DatabaseHelper(this);
    }

    public void newFood(View view) {
        setContentView(R.layout.add_food);

    }

    public void newSymptom(View view) {
        setContentView(R.layout.add_symptom);
    }

}
