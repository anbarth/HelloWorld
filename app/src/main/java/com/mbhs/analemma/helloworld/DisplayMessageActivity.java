package com.mbhs.analemma.helloworld;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class DisplayMessageActivity extends ActionBarActivity {

    public void nextProb(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Get the message
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        String returnMes = "";
        //Create the textView
        if(message.equals(intent.getStringExtra(MainActivity.SUM_MESSAGE)))
            returnMes = "The Analemma smiles upon you with its rays of infinity.";
        else
            returnMes = "Incorrect |-|-|";
        TextView textView = (TextView) findViewById(R.id.return_mes);
        textView.setTextSize(40);
        textView.setText(returnMes);
        //Set the textView as the activity layout
        setContentView(textView);
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
