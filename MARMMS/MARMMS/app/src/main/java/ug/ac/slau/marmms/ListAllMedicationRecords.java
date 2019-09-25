package ug.ac.slau.marmms;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListAllMedicationRecords extends AppCompatActivity {
    EditText medication_record_to_delete;
    ListView mListView;
    ArrayList<MedicationRecordModel> mList;
    MedicationListAdapter medicationListAdapter = null;

    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_all_medication_records);

        mListView = (ListView) findViewById(R.id.medication_records_listView);
        mList = new ArrayList<>();
        medicationListAdapter = new MedicationListAdapter(this, R.layout.medication_custom_list_row, mList);
        mListView.setAdapter(medicationListAdapter);

        medication_record_to_delete = (EditText) findViewById(R.id.medication_record_to_delete);

        databaseHelper = new DatabaseHelper(this, "", null, 1);
    }

    public void FinallyListAllMedicationRecords(View view) {
        try {
            Cursor cursor = databaseHelper.ListAllMedications("SELECT * FROM MEDICATION");
            mList.clear();
            while (cursor.moveToNext()) {
                int id = cursor.getInt(0);
                String medicine_names = cursor.getString(1);
                String patient_names = cursor.getString(2);
                String medication_id = cursor.getString(3);
                String reason = cursor.getString(4);
                String date_given = cursor.getString(5);
                String time_given = cursor.getString(6);

                mList.add(new MedicationRecordModel(id, medicine_names, patient_names, medication_id, reason, date_given, time_given));
            }
            medicationListAdapter.notifyDataSetChanged();

            if (mList.size() == 0) {
                Toast.makeText(this, "No records found!", Toast.LENGTH_SHORT).show();
            }

            Toast.makeText(ListAllMedicationRecords.this, "LISTING SUCCESSFUL", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(ListAllMedicationRecords.this, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    public void DeleteMedicationRecord(View view) {
        try{
            databaseHelper.DeleteMedication(medication_record_to_delete.getText().toString());
            Toast.makeText(ListAllMedicationRecords.this, "DELETED", Toast.LENGTH_SHORT).show();
        } catch (Exception ex){
            Toast.makeText(ListAllMedicationRecords.this, ex.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
