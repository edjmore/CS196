package cs196.studybuddy;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.format.Time;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

	private SpotList master;

	public final static String EXTRA_MESSAGE = "cs196.StudyBuddy.MESSAGE";
	public final static String EXTRA_MESSAGE_2 = "cs196.StudyBuddy.MESSAGE2";

	// NOT testing
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Changing the keyboard for the search edit text so it shows "search"
		// instead of "done"
		EditText mEditText = (EditText) findViewById(R.id.search_edit_text);
		mEditText.setImeActionLabel("Search", KeyEvent.KEYCODE_ENTER);

		Coffee bevande = new Coffee("Bevande", 630, 1730);
		Coffee caff = new Coffee("Caffeinator", 600, 2300);
		Coffee royale = new Coffee("Espresso Royale", 600, 2300);
		Coffee tom = new Coffee("Only the best...", 0, 2300);
		Coffee red = new Coffee("No", 0, 0);

		Food cravings = new Food("Cravings", 1000, 2030);
		Food subway = new Food("Subway", 800, 2200);
		Food veggie = new Food("Red Herring Vegetarian", 1000, 1330);
		Food perkins = new Food("Perkins Bakery", 0, 2300);
		Food rain = new Food("Rainbow Garden", 1000, 2030);
		Food wendys = new Food("Wendy's", 830, 2300);
		Food mia = new Food("Mia Za's", 900, 2000);
		Food thomas = new Food("Cheerios", 0, 2300);
		Food herring = new Food("Hardcore Herring", 0, 2300);
		Food i57 = new Food("I-57", 800, 2300);

		master = new SpotList();
		master.addSpot(new Spot("Grainger Library", bevande, cravings, true,
				true, true, 730, 2300));
		master.addSpot(new Spot("Talbot Lab", bevande, cravings, false, true,
				true, 600, 2100));
		master.addSpot(new Spot("Mechanical Engineering Lab (MEL)", bevande,
				cravings, false, true, true, 600, 2300));
		master.addSpot(new Spot("Psychology Building", royale, subway, false,
				false, false, 600, 1900));
		master.addSpot(new Spot("Undegraduate Library (UGL)", royale, veggie,
				true, false, false, 0, 2300));
		master.addSpot(new Spot("Siebel Center", bevande, perkins, true, true,
				true, 600, 2300));
		master.addSpot(new Spot("Ikenberry Commons (SDRP)", caff, i57, false,
				false, false, 0, 2300));
		master.addSpot(new Spot("Main Library", royale, veggie, false, false,
				false, 500, 2300));
		master.addSpot(new Spot("Business Instructional Facility (BIF)",
				royale, veggie, false, false, false, 500, 2300));
		master.addSpot(new Spot("Illini Student Union", royale, wendys, false,
				false, false, 0, 2300));
		master.addSpot(new Spot("Loomis Lab", bevande, veggie, true, true,
				false, 600, 2000));
		master.addSpot(new Spot("Activities and Recreation Center (ARC)",
				royale, rain, false, false, false, 600, 2300));
		master.addSpot(new Spot("Engineering Hall", bevande, cravings, false,
				true, true, 600, 2300));
		master.addSpot(new Spot("The Armory", royale, subway, false, false,
				false, 400, 2200));
		master.addSpot(new Spot("Digital Computer Lab (DCL)", bevande,
				cravings, false, true, true, 545, 2400));
		master.addSpot(new Spot("Altgeld Library", royale, mia, true, false,
				false, 600, 2200));
		master.addSpot(new Spot("Chemistry Library (Noyes)", royale, veggie,
				true, false, false, 600, 2200));
		master.addSpot(new Spot("Foreign Language Building", royale, veggie,
				false, false, false, 600, 2100));
		master.addSpot(new Spot("Everitt Lab", royale, cravings, true, true,
				true, 600, 2100));
		master.addSpot(new Spot("Thomas's House", tom, thomas, true, true,
				false, 0, 2300));
		master.addSpot(new Spot("Red Lion", red, herring, false, false, false,
				700, 2500));
		// reading Spot data and putting spots into master list (needs to be
		// fixed)
		// sample spots:

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void onSettingsClick(View view) {
		//Intent = intent = new Intent(this, Help.class);
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

		// true if user selected north of green street
		boolean north = myPrefs.getString("cardinal_response", "North").equals(
				"North");

		boolean EWS = myPrefs.getBoolean("ews_response", false);

		String prefs = (north ? "North " : "South ") + "of Green "
				+ (tutors ? "+ Tutors " : "") + (EWS ? "+ EWS" : "");

		SpotList best = master.bestSpots(north, tutors, EWS);
		best.sort(north, tutors);
		String[] result = best.toStringArray();
		intent.putExtra(EXTRA_MESSAGE, result);
		intent.putExtra(EXTRA_MESSAGE_2, prefs);
		startActivity(intent);

	}

	// shows study spot preferences (food distance and tutor availability
	public void onPrefsButtonClick(View view) {
		Intent intent = new Intent(this, StudyPreferences.class);
		startActivity(intent);
	}
}
