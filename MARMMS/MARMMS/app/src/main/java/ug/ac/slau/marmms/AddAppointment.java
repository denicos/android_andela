package ug.ac.slau.marmms;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddAppointment extends AppCompatActivity {
    EditText patient_names, appointment_date, appointment_time, appointment_reason;
    Button save_appointment;

    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_appointment);

        patient_names = (EditText) findViewById(R.id.patient_names);
        appointment_date = (EditText) findViewById(R.id.appointment_date);
        appointment_time = (EditText) findViewById(R.id.appointment_time);
        appointment_reason = (EditText) findViewById(R.id.appointment_reason);
        save_appointment = (Button) findViewById(R.id.save_test);

        databaseHelper = new DatabaseHelper(this, "", null, 1);

        save_appointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    databaseHelper.InsertAppointment(patient_names.getText().toString().trim()
                            , appointment_date.getText().toString().trim()
                            , appointment_time.getText().toString().trim()
                            , appointment_reason.getText().toString().trim()
                    );
                    Toast.makeText(AddAppointment.this, "Added Successfully", Toast.LENGTH_SHORT).show();
                    patient_names.setText("");
                    appointment_date.setText("");
                    appointment_time.setText("");
                    appointment_reason.setText("");
                } catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(AddAppointment.this, e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
