package com.cyanogenmod.cmparts.activities;

import com.cyanogenmod.cmparts.R;
import android.content.Context;
import android.app.Activity;
import android.content.ContentResolver;
import android.provider.Settings;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.os.Bundle;
import android.app.Dialog;

/**
 * Dialog to set custom carrier text
 */
 
public class CustomCarrier extends Activity {
    private final static String TAG = "CustomCarrier";

    private EditText mCarrierTextField;
    private Button mOKButton;
    private Button mCancelButton;
    
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

		// set the view and get fields
        setContentView(R.layout.carrier);
        mCarrierTextField = (EditText)findViewById(R.id.carrier);

		// ok button
        mOKButton = (Button)findViewById(R.id.ok_button);
        mOKButton.setOnClickListener(new View.OnClickListener() {
        	@Override
            public void onClick(View v) {
				// put carrier text back to the db
				Settings.System.putString(getContentResolver(), Settings.System.CUSTOM_CARRIER_TEXT, mCarrierTextField.getText().toString());
				finish();
            }
		});

		// cancel
        mCancelButton = (Button)findViewById(R.id.cancel_button);
        mCancelButton.setOnClickListener(new View.OnClickListener() {
        	@Override
            public void onClick(View v) {
            	// nothing, just close
				finish();
            }
		});

		// get carrier text from database
		mCarrierTextField.setText(Settings.System.getString(getContentResolver(), Settings.System.CUSTOM_CARRIER_TEXT));
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        return super.onCreateDialog(id);
    }

    @Override
    protected void onPrepareDialog(int id, Dialog dialog) {
        super.onPrepareDialog(id, dialog);
    }
}

