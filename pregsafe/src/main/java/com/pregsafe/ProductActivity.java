package com.pregsafe;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ProductActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.product);

        // Set the barcode
        String barcode = getIntent().getStringExtra("com.pregsafe.BARCODE");
        TextView barcodeTextView = (TextView) findViewById(R.id.product_details_barcode);
        barcodeTextView.setText(barcode);
	}
	
}
