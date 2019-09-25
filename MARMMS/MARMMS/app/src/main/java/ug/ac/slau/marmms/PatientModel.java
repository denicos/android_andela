package ug.ac.slau.marmms;

/**
 * Created by issaabdullah on 07-May-18.
 */
public class PatientModel {
    private int id;
    String patient_names, gender, nationality, address, email, phone_number, arrival_date;

    public PatientModel(int id, String patient_names, String gender, String nationality, String address, String email, String phone_number, String arrival_date) {
        this.id = id;
        this.patient_names = patient_names;
        this.gender = gender;
        this.nationality = nationality;
        this.address = address;
        this.email = email;
        this.phone_number = phone_number;
        this.arrival_date = arrival_date;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getArrival_date() {
        return arrival_date;
    }

    public void setArrival_date(String arrival_date) {
        this.arrival_date = arrival_date;
    }
}
