package com.mbhs.analemma.helloworld;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends ActionBarActivity {
    public final static String EXTRA_MESSAGE = "com.mbhs.analemma.helloworld.MESSAGE";
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
        //putExtra sends information between activities (I'm not entirely sure what that means)
        intent.putExtra(EXTRA_MESSAGE, message);
        //Finish the intent
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
