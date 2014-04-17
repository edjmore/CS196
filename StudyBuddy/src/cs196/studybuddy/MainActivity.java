package cs196.studybuddy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends Activity {

	private SpotList master;

	public final static String EXTRA_MESSAGE = "cs196.StudyBuddy.MESSAGE";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Changing the keyboard for the search edit text so it shows "search"
		// instead of "done"
		EditText mEditText = (EditText) findViewById(R.id.search_edit_text);
		mEditText.setImeActionLabel("Search", KeyEvent.KEYCODE_ENTER);

		master = new SpotList();
		// reading Spot data and putting spots into master list (needs to be
		// fixed)
		master.addSpot(new Spot("", 2, 0, false));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void sendSearch(View view) {
		Intent intent = new Intent(this, DisplaySearchResults.class);
		EditText editText = (EditText) findViewById(R.id.search_edit_text);
		String search = editText.getText().toString();
		intent.putExtra(EXTRA_MESSAGE, search);
		startActivity(intent);
	}

	// onRadioButtonClicked method no longer necessary
	private boolean tutors;

	public void onRadioButtonClicked(View view) {
		boolean checked = ((RadioButton) view).isChecked();
		switch (view.getId()) {
		case R.id.radio_yes_tutors:
			if (checked) {
				tutors = true;
				break;
			}
		case R.id.radio_no_tutors:
			if (checked) {
				tutors = false;
				break;
			}
		}
	}

	public void findBest(View view) {
		Intent intent = new Intent(this, DisplayBestResults.class);
		SpotList best = master.bestSpots(1, 1, tutors);
		if (best.spotPeek(0).getName().equals("VOID")) {
			String[] out = new String[1];
			out[0] = "No Study Spots match your criteria...";
			intent.putExtra(EXTRA_MESSAGE, out);
			startActivity(intent);
		} else {
			String[] out = best.toStringArray();
			intent.putExtra(EXTRA_MESSAGE, out);
			startActivity(intent);
		}
	}

	public void onPrefsButtonClick(View view) {
		Intent intent = new Intent(this, StudyPreferences.class);
		startActivity(intent);
	}
}
