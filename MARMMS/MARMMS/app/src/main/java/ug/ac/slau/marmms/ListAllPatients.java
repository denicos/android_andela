package ug.ac.slau.marmms;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListAllPatients extends AppCompatActivity {
//    public static final String PATIENT_ID = "PATIENT_ID";
    EditText patient_to_delete;
    ListView mListView;
    ArrayList<PatientModel> mList;
    PatientsListAdapter patientsListAdapter = null;

    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_all_patients);

        mListView = (ListView) findViewById(R.id.patients_listView);
        mList = new ArrayList<>();
        patientsListAdapter = new PatientsListAdapter(this, R.layout.custom_list_row, mList);
        mListView.setAdapter(patientsListAdapter);

        patient_to_delete = (EditText) findViewById(R.id.patient_to_delete);

        databaseHelper = new DatabaseHelper(this, "", null, 1);

//        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent patient_details = new Intent(ListAllPatients.this, PatientDetails.class);
//
//                PatientModel patient = mList.get(position);
//                patient_details.putExtra(PATIENT_ID, patient.getId());
//
//                startActivity(patient_details);
//            }
//        });
    }

    public void FinallyListAllPatients(View view) {
        try {
            Cursor cursor = databaseHelper.ListAllPatients("SELECT * FROM PATIENTS");
            mList.clear();
            while (cursor.moveToNext()) {
                int id = cursor.getInt(0);
                String patient_names = cursor.getString(1);
                String gender = cursor.getString(2);
                String nationality = cursor.getString(3);
                String address = cursor.getString(4);
                String email = cursor.getString(5);
                String phone_number = cursor.getString(6);
                String arrival_date = cursor.getString(7);

                mList.add(new PatientModel(id, patient_names, gender, nationality, address, email, phone_number, arrival_date));
            }
            patientsListAdapter.notifyDataSetChanged();

            if (mList.size() == 0) {
                Toast.makeText(this, "No records found!", Toast.LENGTH_SHORT).show();
            }

            Toast.makeText(ListAllPatients.this, "LISTING SUCCESSFUL", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(ListAllPatients.this, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    public void DeletePatient(View view) {
        try{
            databaseHelper.DeletePatient(patient_to_delete.getText().toString());
            Toast.makeText(ListAllPatients.this, "DELETED", Toast.LENGTH_SHORT).show();
        } catch (Exception ex){
            Toast.makeText(ListAllPatients.this, ex.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    public void CallPatient(View view) {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:0"));

        if (ActivityCompat.checkSelfPermission(ListAllPatients.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        startActivity(callIntent);
    }

    public void SMSPatient(View view) {
        Intent smsIntent = new Intent(Intent.ACTION_VIEW);

        smsIntent.setData(Uri.parse("smsto:"));
        smsIntent.setType("vnd.android-dir/mms-sms");
        smsIntent.putExtra("address"  , new String ("01234"));
        smsIntent.putExtra("sms_body"  , "Test ");

        startActivity(smsIntent);
    }
}
