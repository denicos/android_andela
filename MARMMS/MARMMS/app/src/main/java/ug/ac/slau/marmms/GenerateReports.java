package ug.ac.slau.marmms;

import android.database.Cursor;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class GenerateReports extends AppCompatActivity {
    Button export_patients_list, export_tests_list, export_appointment_list, export_medication_records, export_visitation_records;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_reports);

        databaseHelper = new DatabaseHelper(this, "", null, 1);

        export_patients_list = (Button) findViewById(R.id.export_patients_list);
        export_tests_list = (Button) findViewById(R.id.export_tests_list);
        export_appointment_list = (Button) findViewById(R.id.export_appointment_list);
        export_medication_records = (Button) findViewById(R.id.export_medication_records);
        export_visitation_records = (Button) findViewById(R.id.export_visitation_records);

        // All Patients report

        export_patients_list.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                try {
                    Cursor cursor = databaseHelper.ListAllPatients("SELECT * FROM PATIENTS");
                    int rowcount = 0;
                    int colcount = 0;
                    File sdCardDir = Environment.getExternalStorageDirectory();
                    String filename = "AllPatients.csv";
                    // the name of the file to export with
                    File saveFile = new File(sdCardDir, filename);
                    FileWriter fw = new FileWriter(saveFile);

                    BufferedWriter bw = new BufferedWriter(fw);
                    rowcount = cursor.getCount();
                    colcount = cursor.getColumnCount();
                    if (rowcount > 0) {
                        cursor.moveToFirst();

                        for (int i = 0; i < colcount; i++) {
                            if (i != colcount - 1) {

                                bw.write(cursor.getColumnName(i) + ",");

                            } else {

                                bw.write(cursor.getColumnName(i));

                            }
                        }
                        bw.newLine();

                        for (int i = 0; i < rowcount; i++) {
                            cursor.moveToPosition(i);

                            for (int j = 0; j < colcount; j++) {
                                if (j != colcount - 1)
                                    bw.write(cursor.getString(j) + ",");
                                else
                                    bw.write(cursor.getString(j));
                            }
                            bw.newLine();
                        }
                        bw.flush();
                        Toast.makeText(GenerateReports.this, "Exported Successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(GenerateReports.this, "No Data Found", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(GenerateReports.this, e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        // All Tests report

        export_tests_list.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                try {
                    Cursor cursor = databaseHelper.ListAllTests("SELECT * FROM TESTS");
                    int rowcount = 0;
                    int colcount = 0;
                    File sdCardDir = Environment.getExternalStorageDirectory();
                    String filename = "AllTests.csv";
                    // the name of the file to export with
                    File saveFile = new File(sdCardDir, filename);
                    FileWriter fw = new FileWriter(saveFile);

                    BufferedWriter bw = new BufferedWriter(fw);
                    rowcount = cursor.getCount();
                    colcount = cursor.getColumnCount();
                    if (rowcount > 0) {
                        cursor.moveToFirst();

                        for (int i = 0; i < colcount; i++) {
                            if (i != colcount - 1) {

                                bw.write(cursor.getColumnName(i) + ",");

                            } else {

                                bw.write(cursor.getColumnName(i));

                            }
                        }
                        bw.newLine();

                        for (int i = 0; i < rowcount; i++) {
                            cursor.moveToPosition(i);

                            for (int j = 0; j < colcount; j++) {
                                if (j != colcount - 1)
                                    bw.write(cursor.getString(j) + ",");
                                else
                                    bw.write(cursor.getString(j));
                            }
                            bw.newLine();
                        }
                        bw.flush();
                        Toast.makeText(GenerateReports.this, "Exported Successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(GenerateReports.this, "No Data Found", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(GenerateReports.this, e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        // All Appointments report

        export_appointment_list.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                try {
                    Cursor cursor = databaseHelper.ListAllTests("SELECT * FROM APPOINTMENTS");
                    int rowcount = 0;
                    int colcount = 0;
                    File sdCardDir = Environment.getExternalStorageDirectory();
                    String filename = "AllAppointments.csv";
                    // the name of the file to export with
                    File saveFile = new File(sdCardDir, filename);
                    FileWriter fw = new FileWriter(saveFile);

                    BufferedWriter bw = new BufferedWriter(fw);
                    rowcount = cursor.getCount();
                    colcount = cursor.getColumnCount();
                    if (rowcount > 0) {
                        cursor.moveToFirst();

                        for (int i = 0; i < colcount; i++) {
                            if (i != colcount - 1) {

                                bw.write(cursor.getColumnName(i) + ",");

                            } else {

                                bw.write(cursor.getColumnName(i));

                            }
                        }
                        bw.newLine();

                        for (int i = 0; i < rowcount; i++) {
                            cursor.moveToPosition(i);

                            for (int j = 0; j < colcount; j++) {
                                if (j != colcount - 1)
                                    bw.write(cursor.getString(j) + ",");
                                else
                                    bw.write(cursor.getString(j));
                            }
                            bw.newLine();
                        }
                        bw.flush();
                        Toast.makeText(GenerateReports.this, "Exported Successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(GenerateReports.this, "No Data Found", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(GenerateReports.this, e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        // All Medication Records report

        export_medication_records.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                try {
                    Cursor cursor = databaseHelper.ListAllTests("SELECT * FROM MEDICATION");
                    int rowcount = 0;
                    int colcount = 0;
                    File sdCardDir = Environment.getExternalStorageDirectory();
                    String filename = "AllMedicationRecords.csv";
                    // the name of the file to export with
                    File saveFile = new File(sdCardDir, filename);
                    FileWriter fw = new FileWriter(saveFile);

                    BufferedWriter bw = new BufferedWriter(fw);
                    rowcount = cursor.getCount();
                    colcount = cursor.getColumnCount();
                    if (rowcount > 0) {
                        cursor.moveToFirst();

                        for (int i = 0; i < colcount; i++) {
                            if (i != colcount - 1) {

                                bw.write(cursor.getColumnName(i) + ",");

                            } else {

                                bw.write(cursor.getColumnName(i));

                            }
                        }
                        bw.newLine();

                        for (int i = 0; i < rowcount; i++) {
                            cursor.moveToPosition(i);

                            for (int j = 0; j < colcount; j++) {
                                if (j != colcount - 1)
                                    bw.write(cursor.getString(j) + ",");
                                else
                                    bw.write(cursor.getString(j));
                            }
                            bw.newLine();
                        }
                        bw.flush();
                        Toast.makeText(GenerateReports.this, "Exported Successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(GenerateReports.this, "No Data Found", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(GenerateReports.this, e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        // All Visitation Records report

        export_visitation_records.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                try {
                    Cursor cursor = databaseHelper.ListAllTests("SELECT * FROM VISITS");
                    int rowcount = 0;
                    int colcount = 0;
                    File sdCardDir = Environment.getExternalStorageDirectory();
                    String filename = "AllVisitationRecords.csv";
                    // the name of the file to export with
                    File saveFile = new File(sdCardDir, filename);
                    FileWriter fw = new FileWriter(saveFile);

                    BufferedWriter bw = new BufferedWriter(fw);
                    rowcount = cursor.getCount();
                    colcount = cursor.getColumnCount();
                    if (rowcount > 0) {
                        cursor.moveToFirst();

                        for (int i = 0; i < colcount; i++) {
                            if (i != colcount - 1) {

                                bw.write(cursor.getColumnName(i) + ",");

                            } else {

                                bw.write(cursor.getColumnName(i));

                            }
                        }
                        bw.newLine();

                        for (int i = 0; i < rowcount; i++) {
                            cursor.moveToPosition(i);

                            for (int j = 0; j < colcount; j++) {
                                if (j != colcount - 1)
                                    bw.write(cursor.getString(j) + ",");
                                else
                                    bw.write(cursor.getString(j));
                            }
                            bw.newLine();
                        }
                        bw.flush();
                        Toast.makeText(GenerateReports.this, "Exported Successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(GenerateReports.this, "No Data Found", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(GenerateReports.this, e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
