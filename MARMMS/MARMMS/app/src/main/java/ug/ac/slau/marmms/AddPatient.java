package ug.ac.slau.marmms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddPatient extends AppCompatActivity {
    EditText patient_names, gender, nationality, address, email, phone_number, arrival_date;
    Button save_patient;

    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_patient);

        patient_names = (EditText) findViewById(R.id.patient_names);
        gender = (EditText) findViewById(R.id.gender);
        nationality = (EditText) findViewById(R.id.nationality);
        address = (EditText) findViewById(R.id.address);
        email = (EditText) findViewById(R.id.email);
        phone_number = (EditText) findViewById(R.id.phone_number);
        arrival_date = (EditText) findViewById(R.id.arrival_date);
        save_patient = (Button) findViewById(R.id.save_patient);

        databaseHelper = new DatabaseHelper(this, "", null, 1);

        save_patient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    databaseHelper.InsertPatient(patient_names.getText().toString().trim()
                            , gender.getText().toString().trim()
                            , nationality.getText().toString().trim()
                            , address.getText().toString().trim()
                            , email.getText().toString().trim()
                            , phone_number.getText().toString().trim()
                            , arrival_date.getText().toString().trim()
                    );
                    Toast.makeText(AddPatient.this, "Patient Added Successfully", Toast.LENGTH_SHORT).show();
                    patient_names.setText("");
                    gender.setText("");
                    nationality.setText("");
                    address.setText("");
                    email.setText("");
                    phone_number.setText("");
                    arrival_date.setText("");
                } catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(AddPatient.this, e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
