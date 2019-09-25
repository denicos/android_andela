package ug.ac.slau.marmms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddVisitationRecord extends AppCompatActivity {
    EditText visitor_names, visited_patient, visit_id, visit_reason, visit_date, visit_time;

    Button save_visitation_record;

    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_visitation_record);

        visitor_names = (EditText) findViewById(R.id.visitor_names);
        visited_patient = (EditText) findViewById(R.id.visited_patient);
        visit_id = (EditText) findViewById(R.id.visit_id);
        visit_reason = (EditText) findViewById(R.id.visit_reason);
        visit_date = (EditText) findViewById(R.id.visit_date);
        visit_time = (EditText) findViewById(R.id.visit_time);
        save_visitation_record = (Button) findViewById(R.id.save_visitation_record);

        databaseHelper = new DatabaseHelper(this, "", null, 1);

        save_visitation_record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    databaseHelper.InsertVisitRecord(visitor_names.getText().toString().trim()
                            , visited_patient.getText().toString().trim()
                            , visit_id.getText().toString().trim()
                            , visit_reason.getText().toString().trim()
                            , visit_date.getText().toString().trim()
                            , visit_time.getText().toString().trim()
                    );
                    Toast.makeText(AddVisitationRecord.this, "Added Successfully", Toast.LENGTH_SHORT).show();
                    visitor_names.setText("");
                    visited_patient.setText("");
                    visit_id.setText("");
                    visit_reason.setText("");
                    visit_date.setText("");
                    visit_time.setText("");
                } catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(AddVisitationRecord.this, e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
