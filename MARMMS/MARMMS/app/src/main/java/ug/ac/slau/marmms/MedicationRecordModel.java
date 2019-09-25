package ug.ac.slau.marmms;

public class MedicationRecordModel {
    private int id;
    String medicine_names, patient_names, medication_id, reason, date_given, time_given;

    public MedicationRecordModel(int id, String medicine_names, String patient_names, String medication_id, String reason, String date_given, String time_given) {
        this.id = id;
        this.medicine_names = medicine_names;
        this.patient_names = patient_names;
        this.medication_id = medication_id;
        this.reason = reason;
        this.date_given = date_given;
        this.time_given = time_given;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMedicine_names() {
        return medicine_names;
    }

    public void setMedicine_names(String medicine_names) {
        this.medicine_names = medicine_names;
    }

    public String getPatient_names() {
        return patient_names;
    }

    public void setPatient_names(String patient_names) {
        this.patient_names = patient_names;
    }

    public String getMedication_id() {
        return medication_id;
    }

    public void setMedication_id(String medication_id) {
        this.medication_id = medication_id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDate_given() {
        return date_given;
    }

    public void setDate_given(String date_given) {
        this.date_given = date_given;
    }

    public String getTime_given() {
        return time_given;
    }

    public void setTime_given(String time_given) {
        this.time_given = time_given;
    }
}
