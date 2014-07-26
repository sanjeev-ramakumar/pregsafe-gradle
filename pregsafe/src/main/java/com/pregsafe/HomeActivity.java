package com.pregsafe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class HomeActivity extends ActionBarActivity {

    private Button mScan;
    private static final String TAG = HomeActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        mScan = (Button) findViewById(R.id.scan_button);
        mScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, SimpleScannerActivity.class);
                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                String contents = data.getStringExtra("SCAN_RESULT");
//                String format = data.getStringExtra("SCAN_RESULT_FORMAT");

                // Handle successful scan
                Log.i(TAG, "Barcode = " + contents);

                // Show Product page
                Intent productIntent = new Intent(this, ProductActivity.class);
                productIntent.putExtra("com.pregsafe.BARCODE", contents);
                startActivity(productIntent);

            } else if (resultCode == RESULT_CANCELED) {
                // Handle Cancel
                Log.i(TAG, "Scan unsuccessful");
            }
        }
    }

}
