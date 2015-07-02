package com.mbhs.analemma.helloworld;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class GiveProblemActivity extends ActionBarActivity {
    public final static String EXTRA_MESSAGE = "com.mbhs.analemma.helloworld.MESSAGE";
    public final static String SUM_MESSAGE = "com.mbhs.analemma.helloworld.SUM";
    private String sum = "the analemma is angry";
    /**Called when the user presses the send button
     * The View is the view that was clicked (the button)
     **/
    public void sendMessage(View view){
        //An intent represents an app's "intent to do something", usually start another activity
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        //Get the editText that is a view with the specified id
        //So views are the components added to activities
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        //putExtra sends information between activities
        intent.putExtra(EXTRA_MESSAGE, message);
        intent.putExtra(SUM_MESSAGE, sum);
        //Finish the intent
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_give_problem);
        Log.d("HelloWorld", "~~~~~~~~~~I HAVE CREATED~~~~~~~~~~~");
        TextView problem = (TextView) findViewById(R.id.problem_statement);
        int num1 = (int)(Math.random()*144) + 1;
        int num2 = (int)(Math.random()*100) + 1;
        sum = num1 + num2+"";
        problem.setText(num1 + " + " + num2 + " =");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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
