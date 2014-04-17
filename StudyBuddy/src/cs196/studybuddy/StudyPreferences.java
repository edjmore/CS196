package cs196.studybuddy;

import android.app.Activity;
import android.os.Bundle;
import android.preference.PreferenceFragment;

public class StudyPreferences extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		getFragmentManager().beginTransaction()
				.replace(android.R.id.content, new StudyPrefsFragment())
				.commit();
	}

	public static class StudyPrefsFragment extends PreferenceFragment {
		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			addPreferencesFromResource(R.xml.study_preferences);
		}
	}
}
