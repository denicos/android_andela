package ug.ac.slau.marmms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddTest extends AppCompatActivity {
    EditText test_names, patient_names, test_date, test_time, test_id, test_results;

    Button save_test;

    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_test);

        test_names = (EditText) findViewById(R.id.test_names);
        patient_names = (EditText) findViewById(R.id.patient_names);
        test_date = (EditText) findViewById(R.id.test_date);
        test_time = (EditText) findViewById(R.id.test_time);
        test_id = (EditText) findViewById(R.id.test_id);
        test_results = (EditText) findViewById(R.id.test_results);
        save_test = (Button) findViewById(R.id.save_test);

        databaseHelper = new DatabaseHelper(this, "", null, 1);

        save_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    databaseHelper.InsertTest(test_names.getText().toString().trim()
                            , patient_names.getText().toString().trim()
                            , test_date.getText().toString().trim()
                            , test_time.getText().toString().trim()
                            , test_id.getText().toString().trim()
                            , test_results.getText().toString().trim()
                    );
                    Toast.makeText(AddTest.this, "Added Successfully", Toast.LENGTH_SHORT).show();
                    test_names.setText("");
                    patient_names.setText("");
                    test_date.setText("");
                    test_time.setText("");
                    test_id.setText("");
                    test_results.setText("");
                } catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(AddTest.this, e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
