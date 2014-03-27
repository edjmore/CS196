package cs196.studybuddy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends Activity {

	public final static String EXTRA_MESSAGE = "cs196.StudyBuddy.MESSAGE";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void sendSearch(View view) {
		Intent intent = new Intent(this, DisplaySearchResults.class);
		EditText editText = (EditText) findViewById(R.id.search);
		String search = editText.getText().toString();
		intent.putExtra(EXTRA_MESSAGE, search);
		startActivity(intent);
	}

	public void onRadioButtonClicked(View view) {
		boolean checked = ((RadioButton) view).isChecked();
		switch (view.getId()) {
		case R.id.radio_yes_tutors:
			if (checked)
				break;
		case R.id.radio_no_tutors:
			if (checked)
				break;
		}
	}
}
