package ug.ac.slau.marmms;

public class AppointmentModel {
    private int id;
    String patient_names, appointment_date, appointment_time, appointment_reason;

    public AppointmentModel(int id, String patient_names, String appointment_date, String appointment_time, String appointment_reason) {
        this.id = id;
        this.patient_names = patient_names;
        this.appointment_date = appointment_date;
        this.appointment_time = appointment_time;
        this.appointment_reason = appointment_reason;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPatient_names() {
        return patient_names;
    }

    public void setPatient_names(String patient_names) {
        this.patient_names = patient_names;
    }

    public String getAppointment_date() {
        return appointment_date;
    }

    public void setAppointment_date(String appointment_date) {
        this.appointment_date = appointment_date;
    }

    public String getAppointment_time() {
        return appointment_time;
    }

    public void setAppointment_time(String appointment_time) {
        this.appointment_time = appointment_time;
    }

    public String getAppointment_reason() {
        return appointment_reason;
    }

    public void setAppointment_reason(String appointment_reason) {
        this.appointment_reason = appointment_reason;
    }
}
