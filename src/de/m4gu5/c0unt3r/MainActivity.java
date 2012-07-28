package de.m4gu5.c0unt3r;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	private Button counterButton;
	private int number = 0;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		counterButton = (Button) findViewById(R.id.counterButton);
	}

	public void incrementNumber(View v) {
		number++;
		setCounterButtonText(number);
	}

	public void decrementNumber(View v) {
		if (number != 0) {
			number--;
			setCounterButtonText(number);
		}
	}

	public void resetNumber(View v) {
		number = 0;
		setCounterButtonText(number);
	}

	public void setCounterButtonText(int n) {
		counterButton.setText(String.valueOf(n));
	}

	@Override
	public boolean dispatchKeyEvent(KeyEvent event) {
		int action = event.getAction();
		int keyCode = event.getKeyCode();
		switch (keyCode) {
		case KeyEvent.KEYCODE_VOLUME_UP:
			if (action == KeyEvent.ACTION_UP) {
				// A volume up increments the number
				incrementNumber(null);
			}
			return true;
		case KeyEvent.KEYCODE_VOLUME_DOWN:
			if (action == KeyEvent.ACTION_DOWN) {
				// A volume down decrements the number
				decrementNumber(null);
			}
			return true;
		default:
			return super.dispatchKeyEvent(event);
		}
	}

}
