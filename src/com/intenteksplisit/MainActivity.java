package com.intenteksplisit;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.preference.PreferenceManager.OnActivityResultListener;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
public class MainActivity extends ActionBarActivity {

	// Nama Class digunakan untuk Log tag
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    // Unique tag diperlukan untuk intent extra
    public static final String EXTRA_MESSAGE = "com.intenteksplisit.EXTRA_MESSAGE";
    // Unique tag diperlukan untuk intent reply
    public static final int TEXT_REQUEST = 1;
    // EditText untuk input pesan
    EditText mMessageEditText;
    // TextView untuk reply header
    TextView mReplyHeadTextView;
    // TextView untuk reply body
    TextView mReplyTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // inisialisasi seluruh variabel objek.
        mMessageEditText = (EditText) findViewById(R.id.editText_main);
        mReplyHeadTextView = (TextView) findViewById(R.id.text_header_reply);
        mReplyTextView = (TextView) findViewById(R.id.text_message_reply);        
    }
    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, SecondActivity.class);
        String message = mMessageEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(intent, TEXT_REQUEST);
    }
    /**
     * method onActivityResult di masukkan melalui 
     * klik kanan->source->override/Implement Methods->centang method onActivityResult
     */
     @Override	
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		// Test for the right intent reply
        if (requestCode == TEXT_REQUEST) {
            // Test to make sure the intent reply result was good.
            if (resultCode == RESULT_OK) {
                String reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);
                // Make the reply head visible.
                mReplyHeadTextView.setVisibility(View.VISIBLE);
                // Set the reply and make it visible.
                mReplyTextView.setText(reply);
                mReplyTextView.setVisibility(View.VISIBLE);
            }
        }
    }
	/* (non-Javadoc)
	 * @see android.app.Activity#onRestart()
	 */
	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
	}
   
}
