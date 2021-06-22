package com.intenteksplisit;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
public class SecondActivity extends Activity  {

	// Unique tag for the intent reply.
    public static final String EXTRA_REPLY = "com.intenteksplisit.EXTRA_REPLY";
    // EditText for the reply.
    EditText mReply;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		  // Inisialisasi view variables.
        mReply = (EditText) findViewById(R.id.editText_second);
        // Get the intent that launched this activity, and the message in
        // the intent extra.
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        // Put that message into the text_message TextView
        TextView textView = (TextView) findViewById(R.id.text_message);
        if (textView != null) {
            textView.setText(message);
        }
	}
	/* (non-Javadoc)
	 * @see android.app.Activity#onPause()
	 */
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}
	/* (non-Javadoc)
	 * @see android.app.Activity#onRestart()
	 */
	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
	}
	/* (non-Javadoc)
	 * @see android.app.Activity#onStart()
	 */
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	}
	/* (non-Javadoc)
	 * @see android.app.Activity#onStop()
	 */
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}
	public void returnReply(View view) {
        // Get the reply message from the edit text.
        String reply = mReply.getText().toString();
        // Create a new intent for the reply, add the reply message to it as an extra,
        // set the intent result, and close the activity.
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK, replyIntent);
        finish();
    }	
}

