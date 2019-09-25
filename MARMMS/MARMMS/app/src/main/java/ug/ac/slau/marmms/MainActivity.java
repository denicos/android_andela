package ug.ac.slau.marmms;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int item_id = item.getItemId();

        switch (item_id){
            case R.id.settings:
                Intent settings_activity = new Intent(this, SettingsActivity.class);
                startActivity(settings_activity);
                break;
            case R.id.about:
                Intent about_activity = new Intent(this, AboutActivity.class);
                startActivity(about_activity);
                break;
            case R.id.terms_conditions:
                Intent terms_conditions_activity = new Intent(this, TermsconditionsActivity.class);
                startActivity(terms_conditions_activity);
                break;
        }
        return true;
    }

    public void AddNewPatient(View view) {
        Intent add_new_patient = new Intent(this, AddPatient.class);
        startActivity(add_new_patient);
    }

    public void ListAllPatients(View view) {
        Intent list_all_patients = new Intent(this, ListAllPatients.class);
        startActivity(list_all_patients);
    }

    public void AddNewAppointment(View view) {
        Intent add_new_appointment = new Intent(this, AddAppointment.class);
        startActivity(add_new_appointment);
    }

    public void ListAllAppointments(View view) {
        Intent list_all_appointments = new Intent(this, ListAllAppointments.class);
        startActivity(list_all_appointments);
    }

    public void AddNewTest(View view) {
        Intent add_new_test = new Intent(this, AddTest.class);
        startActivity(add_new_test);
    }

    public void ListAllTests(View view) {
        Intent list_all_tests = new Intent(this, ListAllTests.class);
        startActivity(list_all_tests);
    }

    public void AddNewMedicationRecord(View view) {
        Intent add_new_medication_record = new Intent(this, AddMedicationRecord.class);
        startActivity(add_new_medication_record);
    }

    public void ListAllMedicationRecords(View view) {
        Intent list_all_medication_records = new Intent(this, ListAllMedicationRecords.class);
        startActivity(list_all_medication_records);
    }

    public void AddNewVisitationRecord(View view) {
        Intent add_new_visitation_record = new Intent(this, AddVisitationRecord.class);
        startActivity(add_new_visitation_record);
    }

    public void ListAllVisitationRecords(View view) {
        Intent list_all_visitation_records = new Intent(this, ListAllVisitationRecords.class);
        startActivity(list_all_visitation_records);
    }

    public void GenerateReportsActivity(View view) {
        Intent reports_activity = new Intent(this, GenerateReports.class);
        startActivity(reports_activity);
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    Patients patients = new Patients();
                    return patients;
                case 1:
                    Appointments appointments = new Appointments();
                    return appointments;
                case 2:
                    Tests tests = new Tests();
                    return tests;
                case 3:
                    Medication medication = new Medication();
                    return medication;
                case 4:
                    Visits visits = new Visits();
                    return visits;
                case 5:
                    Reports reports = new Reports();
                    return reports;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 6;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "PATIENTS";
                case 1:
                    return "APPOINTMENTS";
                case 2:
                    return "TESTS";
                case 3:
                    return "MEDICATION";
                case 4:
                    return "VISITS";
                case 5:
                    return "REPORTS";
            }
            return null;
        }
    }
}
