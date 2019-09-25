package ug.ac.slau.marmms;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper{

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "marmms_pjha_db.sqlite", factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS PATIENTS(id INTEGER PRIMARY KEY AUTOINCREMENT, patient_names VARCHAR" +
                ", gender VARCHAR, nationality VARCHAR, address VARCHAR, email VARCHAR, phone_number VARCHAR, arrival_date VARCHAR)");

        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS APPOINTMENTS(id INTEGER PRIMARY KEY AUTOINCREMENT, patient_names VARCHAR" +
                ", appointment_date VARCHAR, appointment_time VARCHAR, appointment_reason TEXT)");

        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS TESTS(id INTEGER PRIMARY KEY AUTOINCREMENT, test_names VARCHAR, patient_names VARCHAR" +
                ", test_date VARCHAR, test_time VARCHAR, test_id VARCHAR, test_results TEXT)");

        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS MEDICATION(id INTEGER PRIMARY KEY AUTOINCREMENT, medicine_names VARCHAR, patient_names VARCHAR" +
                ", medication_id VARCHAR, reason TEXT, date_given VARCHAR, time_given VARCHAR)");

        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS VISITS(id INTEGER PRIMARY KEY AUTOINCREMENT, visitor_names VARCHAR, visited_patient VARCHAR" +
                ", visit_id VARCHAR, visit_reason VARCHAR, visit_date VARCHAR, visit_time VARCHAR)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS PATIENTS;");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS APPOINTMENTS;");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS TESTS;");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS MEDICATION;");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS VISITS;");
        onCreate(sqLiteDatabase);
    }

    /******** PATIENTS *********/

    public void InsertPatient(String patient_names, String gender, String nationality, String address, String email, String phone_number, String arrival_date){

        ContentValues contentValues = new ContentValues();
        contentValues.put("patient_names", patient_names);
        contentValues.put("gender", gender);
        contentValues.put("nationality", nationality);
        contentValues.put("address", address);
        contentValues.put("email", email);
        contentValues.put("phone_number", phone_number);
        contentValues.put("arrival_date", arrival_date);

        this.getWritableDatabase().insertOrThrow("PATIENTS", "", contentValues);
    }

    public void DeletePatient(String patient_to_delete){
        this.getWritableDatabase().delete("PATIENTS", "patient_names='" + patient_to_delete + "'", null);
    }

//    public void UpdateEmployee(String edit_by_email, String names, String gender, String nationality, String address, String email
//            ,String phone_number, String hire_date, String clock_in_time, String clock_out_time, byte[] image){
//        this.getWritableDatabase().execSQL("UPDATE EMPLOYEES set names='"+names+"' ,gender='"+gender+"' ,nationality='"+nationality+"' ,address='"+address+"' ,email='"+email+"' ,phone_number='"+phone_number+"' ,employee_hire_date='"+hire_date+"' ,employee_usual_clock_in_time='"+clock_in_time+"' ,employee_usual_clock_out_time='"+clock_out_time+"' ,image='"+image+"' where email='"+edit_by_email+"'");
//    }

    public Cursor ListAllPatients(String sql){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        return  sqLiteDatabase.rawQuery(sql, null);
    }

    public Cursor ListOnePatient(String sql) {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        return sqLiteDatabase.rawQuery(sql, null);
    }

    /******** APPOINTMENTS ********/

    public void InsertAppointment(String patient_names, String appointment_date, String appointment_time, String appointment_reason){

        ContentValues contentValues = new ContentValues();
        contentValues.put("patient_names", patient_names);
        contentValues.put("appointment_date", appointment_date);
        contentValues.put("appointment_time", appointment_time);
        contentValues.put("appointment_reason", appointment_reason);

        this.getWritableDatabase().insertOrThrow("APPOINTMENTS", "", contentValues);
    }

    public void DeleteAppointment(String patient_appointment_to_delete){
        this.getWritableDatabase().delete("APPOINTMENTS", "patient_names='" + patient_appointment_to_delete + "'", null);
    }

    public Cursor ListAllAppointments(String sql){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        return  sqLiteDatabase.rawQuery(sql, null);
    }

    /******** TESTS ********/

    public void InsertTest(String test_names, String patient_names, String test_date, String test_time, String test_id, String test_results){

        ContentValues contentValues = new ContentValues();
        contentValues.put("test_names", test_names);
        contentValues.put("patient_names", patient_names);
        contentValues.put("test_date", test_date);
        contentValues.put("test_time", test_time);
        contentValues.put("test_id", test_id);
        contentValues.put("test_results", test_results);

        this.getWritableDatabase().insertOrThrow("TESTS", "", contentValues);
    }

    public void DeleteTest(String test_to_delete){
        this.getWritableDatabase().delete("TESTS", "test_id='" + test_to_delete + "'", null);
    }

    public Cursor ListAllTests(String sql){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        return  sqLiteDatabase.rawQuery(sql, null);
    }

    /******** MEDICATION ********/

    public void InsertMedicationRecord(String medicine_names, String patient_names, String medication_id, String reason, String date_given, String time_given){

        ContentValues contentValues = new ContentValues();
        contentValues.put("medicine_names", medicine_names);
        contentValues.put("patient_names", patient_names);
        contentValues.put("medication_id", medication_id);
        contentValues.put("reason", reason);
        contentValues.put("date_given", date_given);
        contentValues.put("time_given", time_given);

        this.getWritableDatabase().insertOrThrow("MEDICATION", "", contentValues);
    }

    public void DeleteMedication(String record_to_delete){
        this.getWritableDatabase().delete("MEDICATION", "medication_id='" + record_to_delete + "'", null);
    }

    public Cursor ListAllMedications(String sql){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        return  sqLiteDatabase.rawQuery(sql, null);
    }

    /******** VISITS ********/

    public void InsertVisitRecord(String visitor_names, String visited_patient, String visit_id, String visit_reason, String visit_date, String visit_time){

        ContentValues contentValues = new ContentValues();
        contentValues.put("visitor_names", visitor_names);
        contentValues.put("visited_patient", visited_patient);
        contentValues.put("visit_id", visit_id);
        contentValues.put("visit_reason", visit_reason);
        contentValues.put("visit_date", visit_date);
        contentValues.put("visit_time", visit_time);

        this.getWritableDatabase().insertOrThrow("VISITS", "", contentValues);
    }

    public void DeleteVisitRecord(String record_to_delete){
        this.getWritableDatabase().delete("VISITS", "visit_id='" + record_to_delete + "'", null);
    }

    public Cursor ListAllVisitsRecord(String sql){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        return  sqLiteDatabase.rawQuery(sql, null);
    }

    /******** REPORTS ********/



}
