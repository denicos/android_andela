package ug.ac.slau.marmms;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class PatientDetails extends AppCompatActivity {
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView details_patient_names = (TextView) findViewById(R.id.details_patient_names);
        TextView details_gender = (TextView) findViewById(R.id.details_gender);
        TextView details_nationality = (TextView) findViewById(R.id.details_nationality);
        TextView details_address = (TextView) findViewById(R.id.details_address);
        TextView details_email = (TextView) findViewById(R.id.details_email);
        TextView details_phone_number = (TextView) findViewById(R.id.details_phone_number);
        TextView details_arrival_date = (TextView) findViewById(R.id.details_arrival_date);

//        String patient_id = getIntent().getStringExtra(ListAllPatients.PATIENT_ID).toString();
//        Toast.makeText(PatientDetails.this, "ID : " + patient_id, Toast.LENGTH_SHORT).show();

//        try {
//            Cursor cursor = databaseHelper.ListOnePatient("SELECT * FROM PATIENTS WHERE id = " + patient_id);
//
//            int id = cursor.getInt(0);
//            String patient_names = cursor.getString(1);
//            String gender = cursor.getString(2);
//            String nationality = cursor.getString(3);
//            String address = cursor.getString(4);
//            String email = cursor.getString(5);
//            String phone_number = cursor.getString(6);
//            String arrival_date = cursor.getString(7);
//
//            details_patient_names.setText(patient_names);
//            details_gender.setText(gender);
//            details_nationality.setText(nationality);
//            details_address.setText(address);
//            details_email.setText(email);
//            details_phone_number.setText(phone_number);
//            details_arrival_date.setText(arrival_date);
//
//            Toast.makeText(PatientDetails.this, "LISTING SUCCESSFUL", Toast.LENGTH_SHORT).show();
//        } catch (Exception e) {
//            Toast.makeText(PatientDetails.this, e.toString(), Toast.LENGTH_SHORT).show();
//        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
