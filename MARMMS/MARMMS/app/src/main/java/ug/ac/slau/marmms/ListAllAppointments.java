package ug.ac.slau.marmms;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListAllAppointments extends AppCompatActivity {
    EditText patient_appointment_to_delete;
    ListView mListView;
    ArrayList<AppointmentModel> mList;
    AppointmentsListAdapter appointmentsListAdapter = null;

    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_all_appointments);

        mListView = (ListView) findViewById(R.id.appointments_listView);
        mList = new ArrayList<>();
        appointmentsListAdapter = new AppointmentsListAdapter(this, R.layout.appointments_custom_list_row, mList);
        mListView.setAdapter(appointmentsListAdapter);

        patient_appointment_to_delete = (EditText) findViewById(R.id.appointment_to_delete);

        databaseHelper = new DatabaseHelper(this, "", null, 1);
    }

    public void FinallyListAllAppointments(View view) {
        try {
            Cursor cursor = databaseHelper.ListAllAppointments("SELECT * FROM APPOINTMENTS");
            mList.clear();
            while (cursor.moveToNext()) {
                int id = cursor.getInt(0);
                String patient_names = cursor.getString(1);
                String appointment_date = cursor.getString(2);
                String appointment_time = cursor.getString(3);
                String appointment_reason = cursor.getString(4);

                mList.add(new AppointmentModel(id, patient_names, appointment_date, appointment_time, appointment_reason));
            }
            appointmentsListAdapter.notifyDataSetChanged();

            if (mList.size() == 0) {
                Toast.makeText(this, "No records found!", Toast.LENGTH_SHORT).show();
            }

            Toast.makeText(ListAllAppointments.this, "LISTING SUCCESSFUL", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(ListAllAppointments.this, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    public void DeleteAppointment(View view) {
        try{
            databaseHelper.DeleteAppointment(patient_appointment_to_delete.getText().toString());
            Toast.makeText(ListAllAppointments.this, "DELETED", Toast.LENGTH_SHORT).show();
        } catch (Exception ex){
            Toast.makeText(ListAllAppointments.this, ex.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
