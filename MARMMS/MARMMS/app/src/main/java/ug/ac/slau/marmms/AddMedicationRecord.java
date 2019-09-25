package ug.ac.slau.marmms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddMedicationRecord extends AppCompatActivity {
    EditText medicine_names, patient_names, medication_id, reason, date_given, time_given;

    Button save_medication_record;

    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_medication_record);

        medicine_names = (EditText) findViewById(R.id.medicine_names);
        patient_names = (EditText) findViewById(R.id.patient_names);
        medication_id = (EditText) findViewById(R.id.medication_id);
        reason = (EditText) findViewById(R.id.reason);
        date_given = (EditText) findViewById(R.id.date_given);
        time_given = (EditText) findViewById(R.id.time_given);
        save_medication_record = (Button) findViewById(R.id.save_medication_record);

        databaseHelper = new DatabaseHelper(this, "", null, 1);

        save_medication_record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    databaseHelper.InsertMedicationRecord(medicine_names.getText().toString().trim()
                            , patient_names.getText().toString().trim()
                            , medication_id.getText().toString().trim()
                            , reason.getText().toString().trim()
                            , date_given.getText().toString().trim()
                            , time_given.getText().toString().trim()
                    );
                    Toast.makeText(AddMedicationRecord.this, "Added Successfully", Toast.LENGTH_SHORT).show();
                    medicine_names.setText("");
                    patient_names.setText("");
                    medication_id.setText("");
                    reason.setText("");
                    date_given.setText("");
                    time_given.setText("");
                } catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(AddMedicationRecord.this, e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
