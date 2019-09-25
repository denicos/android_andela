package ug.ac.slau.marmms;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListAllVisitationRecords extends AppCompatActivity {
    EditText visitation_record_to_delete;
    ListView mListView;
    ArrayList<VisitationRecordModel> mList;
    VisitationListAdapter visitationListAdapter = null;

    DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_all_visitation_records);

        mListView = (ListView) findViewById(R.id.visitation_records_listView);
        mList = new ArrayList<>();
        visitationListAdapter = new VisitationListAdapter(this, R.layout.visitation_custom_list_row, mList);
        mListView.setAdapter(visitationListAdapter);

        visitation_record_to_delete = (EditText) findViewById(R.id.visitation_record_to_delete);

        databaseHelper = new DatabaseHelper(this, "", null, 1);
    }

    public void FinallyListAllVisitationRecords(View view) {
        try {
            Cursor cursor = databaseHelper.ListAllVisitsRecord("SELECT * FROM VISITS");
            mList.clear();
            while (cursor.moveToNext()) {
                int id = cursor.getInt(0);
                String visitor_names = cursor.getString(1);
                String visited_patient = cursor.getString(2);
                String visit_id = cursor.getString(3);
                String visit_reason = cursor.getString(4);
                String visit_date = cursor.getString(5);
                String visit_time = cursor.getString(6);

                mList.add(new VisitationRecordModel(id, visitor_names, visited_patient, visit_id, visit_reason, visit_date, visit_time));
            }
            visitationListAdapter.notifyDataSetChanged();

            if (mList.size() == 0) {
                Toast.makeText(this, "No records found!", Toast.LENGTH_SHORT).show();
            }

            Toast.makeText(ListAllVisitationRecords.this, "LISTING SUCCESSFUL", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(ListAllVisitationRecords.this, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    public void DeleteVisitationRecord(View view) {
        try{
            databaseHelper.DeleteVisitRecord(visitation_record_to_delete.getText().toString());
            Toast.makeText(ListAllVisitationRecords.this, "DELETED", Toast.LENGTH_SHORT).show();
        } catch (Exception ex){
            Toast.makeText(ListAllVisitationRecords.this, ex.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
