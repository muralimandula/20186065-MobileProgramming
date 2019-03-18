package com.example.android.sunshine;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.preference.CheckBoxPreference;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.support.v7.preference.PreferenceScreen;

// Do steps 5 - 11 within SettingsFragment
// TODO (10) Implement OnSharedPreferenceChangeListener from SettingsFragment

// TODO (8) Create a method called setPreferenceSummary that accepts a Preference and an Object and sets the summary of the preference

// TODO (5) Override onCreatePreferences and add the preference xml file using addPreferencesFromResource

public class SettingsFragment extends PreferenceFragmentCompat implements SharedPreferences.OnSharedPreferenceChangeListener {

    public void setPreferenceSummary(Preference p, Object o) {
        String str = o.toString();
        String strP = p.getKey();
        if (p instanceof ListPreference) {

            ListPreference listPreference = (ListPreference) p;
            int prefIndex = listPreference.findIndexOfValue(str);
            if (prefIndex >= 0) {
                p.setSummary(listPreference.getEntries()[prefIndex]);
            }
        } else {
            p.setSummary(str);
        }
    }

    // Do step 9 within onCreatePreferences
    // TODO (9) Set the preference summary on each preference that isn't a CheckBoxPreference

    // TODO (13) Unregister SettingsFragment (this) as a SharedPreferenceChangedListener in onStop

    // TODO (12) Register SettingsFragment (this) as a SharedPreferenceChangedListener in onStart

    // TODO (11) Override onSharedPreferenceChanged to update non CheckBoxPreferences when they are changed
    @Override
    public void onCreatePreferences(Bundle bundle, String s) {
        addPreferencesFromResource(R.xml.preferencescreen);

        SharedPreferences sharedPreferences = getPreferenceScreen().getSharedPreferences();

        PreferenceScreen prefScreen = getPreferenceScreen();
        int count = prefScreen.getPreferenceCount();
        for (int i = 0; i < count; i++) {
            Preference p = prefScreen.getPreference(i);
            if (!(p instanceof CheckBoxPreference)) {
                String value = sharedPreferences.getString(p.getKey(), "");
                setPreferenceSummary(p, value);
            }
        }


    }

    @Override
    public void onStart() {
        super.onStart();
        getPreferenceScreen().getSharedPreferences()
                .registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        getPreferenceScreen().getSharedPreferences()
                .unregisterOnSharedPreferenceChangeListener(this);
    }


    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        Preference preference = findPreference(key);
        if (null != preference) {
            if (!(preference instanceof CheckBoxPreference)) {
                setPreferenceSummary(preference, sharedPreferences.getString(key, ""));
            }
        }
    }

}
