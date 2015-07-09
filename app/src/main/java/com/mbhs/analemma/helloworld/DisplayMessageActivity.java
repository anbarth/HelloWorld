package com.mbhs.analemma.helloworld;

import android.content.Intent;
import android.graphics.Point;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class DisplayMessageActivity extends ActionBarActivity {

    public void nextProb(View view) {
        Intent intent = new Intent(this, GiveProblemActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        //Get the message
        Intent intent = getIntent();
        String message = intent.getStringExtra(GiveProblemActivity.EXTRA_MESSAGE);
        String returnMes = "";
        //Create the textView
        if(message.equals(intent.getStringExtra(GiveProblemActivity.SUM_MESSAGE)))
            returnMes = "The Analemma smiles upon you with its rays of infinity.";
        else
            returnMes = "Incorrect |-|-|";

        //Set the textView as the activity layout
        TextView textView = (TextView) findViewById(R.id.return_mes);
        textView.setTextSize(40);
        textView.setText(returnMes);

        //Get size of window
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int xCorner = size.x - textView.getWidth();
        int yCorner = size.y - textView.getHeight();

        //Animate--in theory, first one flips it and moves to the corner, second one moves it back
        textView.animate().x(xCorner).y(yCorner).rotationYBy(720);
        textView.animate().x(0).y(0);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
