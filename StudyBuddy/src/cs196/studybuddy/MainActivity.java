package cs196.studybuddy;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

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
		// sample spots:
		master.addSpot(new Spot("Grainger Library", 1.3, true));
		master.addSpot(new Spot("Mechanical Engineering Lab", 1.27, false));
		master.addSpot(new Spot("Talbot Lab", 1.25, true));
		master.addSpot(new Spot("Undergrad Library", .55, false));
		master.addSpot(new Spot("Psychology Building", 0.93, false));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	// searches the list of study spots for one which matches the name typed by
	// the user
	public void sendSearch(View view) {

		Intent intent = new Intent(this, DisplaySearchResults.class);
		EditText editText = (EditText) findViewById(R.id.search_edit_text);
		String search = editText.getText().toString();

		String[] results = master.search(search).toStringArray();

		intent.putExtra(EXTRA_MESSAGE, results);

		startActivity(intent);
	}

	// onRadioButtonClicked method no longer necessary
	// TODO: remove all this and use preferences instead
	/**
	 * private boolean tutors;
	 * 
	 * public void onRadioButtonClicked(View view) { boolean checked =
	 * ((RadioButton) view).isChecked(); switch (view.getId()) { case
	 * R.id.radio_yes_tutors: if (checked) { tutors = true; break; } case
	 * R.id.radio_no_tutors: if (checked) { tutors = false; break; } } }
	 */
	// finds the study spots that best match the user's preferences
	// uses the bestSpots method in SpotList class
	// TODO: the logic of this bestSpots method needs some work
	public void findBest(View view) {
		Intent intent = new Intent(this, DisplayBestResults.class);

		// working on it...
		SharedPreferences myPrefs = PreferenceManager
				.getDefaultSharedPreferences(this);

		// user preference for tutor availability ("true" if they want tutors)
		boolean tutors = myPrefs.getBoolean("tutor_response", false);

		// user preference for max distance from food (between 0 and 2 miles,
		// defaults to 2 miles)
		double distance = Double.parseDouble(myPrefs.getString(
				"food_response_values", "2"));
		// working on it...

		SpotList best = master.bestSpots(1, tutors);
		best.sort(distance, tutors);
		String[] result = best.toStringArray();
		intent.putExtra(EXTRA_MESSAGE, result);
		startActivity(intent);

	}

	// shows study spot preferences (food distance and tutor availability
	public void onPrefsButtonClick(View view) {
		Intent intent = new Intent(this, StudyPreferences.class);
		startActivity(intent);
	}
}
