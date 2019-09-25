package ug.ac.slau.marmms;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListAllTests extends AppCompatActivity {
    EditText test_to_delete;
    ListView mListView;
    ArrayList<TestModel> mList;
    TestsListAdapter testsListAdapter = null;

    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_all_tests);

        mListView = (ListView) findViewById(R.id.tests_listView);
        mList = new ArrayList<>();
        testsListAdapter = new TestsListAdapter(this, R.layout.tests_custom_list_row, mList);
        mListView.setAdapter(testsListAdapter);

        test_to_delete = (EditText) findViewById(R.id.test_to_delete);

        databaseHelper = new DatabaseHelper(this, "", null, 1);
    }

    public void FinallyListAllTests(View view) {
        try {
            Cursor cursor = databaseHelper.ListAllTests("SELECT * FROM TESTS");
            mList.clear();
            while (cursor.moveToNext()) {
                int id = cursor.getInt(0);
                String test_names = cursor.getString(1);
                String patient_names = cursor.getString(2);
                String test_date = cursor.getString(3);
                String test_time = cursor.getString(4);
                String test_id = cursor.getString(5);
                String test_results = cursor.getString(6);

                mList.add(new TestModel(id, test_names, patient_names, test_date, test_time, test_id, test_results));
            }
            testsListAdapter.notifyDataSetChanged();

            if (mList.size() == 0) {
                Toast.makeText(this, "No records found!", Toast.LENGTH_SHORT).show();
            }

            Toast.makeText(ListAllTests.this, "LISTING SUCCESSFUL", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(ListAllTests.this, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    public void DeleteTest(View view) {
        try{
            databaseHelper.DeleteTest(test_to_delete.getText().toString());
            Toast.makeText(ListAllTests.this, "DELETED", Toast.LENGTH_SHORT).show();
        } catch (Exception ex){
            Toast.makeText(ListAllTests.this, ex.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
