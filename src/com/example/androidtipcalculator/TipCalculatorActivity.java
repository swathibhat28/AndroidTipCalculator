package com.example.androidtipcalculator;

import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.AdapterView.OnItemLongClickListener;

public class TipCalculatorActivity extends Activity {
	EditText etAmount;
	Button bt10,bt15,bt20;
	TextView tvTip;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tip_calculator);
		etAmount = (EditText)findViewById(R.id.etAmount);
		bt10 = (Button)findViewById(R.id.bt10);
		bt15 = (Button)findViewById(R.id.bt15);
		bt20 = (Button)findViewById(R.id.bt20);
		tvTip = (TextView)findViewById(R.id.tvTip);
		
		bt10.setEnabled(false);
		bt15.setEnabled(false);
		bt20.setEnabled(false);
		setupEditTextListener();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tip_calculator, menu);
		return true;
	}
	
	public void setupEditTextListener() {
		etAmount.addTextChangedListener(new TextWatcher(){

			@Override
			public void afterTextChanged(Editable s) {
				if(s == null || s.length()==0){
					bt10.setEnabled(false);
					bt15.setEnabled(false);
					bt20.setEnabled(false);
					etAmount.setImeOptions(EditorInfo.IME_FLAG_NO_ENTER_ACTION);
					tvTip.setText("");
				}else{
					bt10.setEnabled(true);
					bt15.setEnabled(true);
					bt20.setEnabled(true);
				}
				
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				if(s == null || s.length()==0){
					bt10.setEnabled(false);
					bt15.setEnabled(false);
					bt20.setEnabled(false);
					etAmount.setImeOptions(EditorInfo.IME_FLAG_NO_ENTER_ACTION);
					tvTip.setText("");
				}else{
					bt10.setEnabled(true);
					bt15.setEnabled(true);
					bt20.setEnabled(true);
				}
			}
		
		});
	}
	
	private void clearTip(TextView tvTip) {	
	    tvTip.setText("");
		
	}

	private float getAmount() {
		EditText etAmount = (EditText)findViewById(R.id.etAmount);
		return Integer.parseInt(etAmount.getText().toString());

	}
	
	public static float calculateTip(int tipPercentage, float total) {
	    float proportion = ((float) tipPercentage) / 100;
	    return proportion * ((float) total);
	}

	public void calculateTenPercentTip(View v) {
		TextView tvTip = (TextView)findViewById(R.id.tvTip);
		clearTip(tvTip);
		float amount = getAmount();
	    float tip = calculateTip(10,amount);
		tvTip.setText("Tip is: "+tip);
	}

	public void calculateFifteenPercentTip(View v) {
		TextView tvTip = (TextView)findViewById(R.id.tvTip);
		clearTip(tvTip);
		float amount = getAmount();
	    float tip = calculateTip(15,amount);
		tvTip.setText("Tip is: "+tip);

	}
	
	public void calculateTwentyPercentTip(View v) {
		TextView tvTip = (TextView)findViewById(R.id.tvTip);
		clearTip(tvTip);
		float amount = getAmount();
	    float tip = calculateTip(20,amount);
		tvTip.setText("Tip is: "+tip);

	}

}
