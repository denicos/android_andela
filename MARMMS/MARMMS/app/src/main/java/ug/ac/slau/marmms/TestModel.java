package ug.ac.slau.marmms;

public class TestModel {
    private int id;
    String test_names, patient_names, test_date, test_time, test_id, test_results;

    public TestModel(int id, String test_names, String patient_names, String test_date, String test_time, String test_id, String test_results) {
        this.id = id;
        this.test_names = test_names;
        this.patient_names = patient_names;
        this.test_date = test_date;
        this.test_time = test_time;
        this.test_id = test_id;
        this.test_results = test_results;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTest_names() {
        return test_names;
    }

    public void setTest_names(String test_names) {
        this.test_names = test_names;
    }

    public String getPatient_names() {
        return patient_names;
    }

    public void setPatient_names(String patient_names) {
        this.patient_names = patient_names;
    }

    public String getTest_date() {
        return test_date;
    }

    public void setTest_date(String test_date) {
        this.test_date = test_date;
    }

    public String getTest_time() {
        return test_time;
    }

    public void setTest_time(String test_time) {
        this.test_time = test_time;
    }

    public String getTest_id() {
        return test_id;
    }

    public void setTest_id(String test_id) {
        this.test_id = test_id;
    }

    public String getTest_results() {
        return test_results;
    }

    public void setTest_results(String test_results) {
        this.test_results = test_results;
    }
}
