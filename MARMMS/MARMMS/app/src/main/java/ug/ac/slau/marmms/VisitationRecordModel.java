package ug.ac.slau.marmms;

public class VisitationRecordModel {
    private int id;
    String visitor_names, visited_patient, visit_id, visit_reason, visit_date, visit_time;

    public VisitationRecordModel(int id, String visitor_names, String visited_patient, String visit_id, String visit_reason, String visit_date, String visit_time) {
        this.id = id;
        this.visitor_names = visitor_names;
        this.visited_patient = visited_patient;
        this.visit_id = visit_id;
        this.visit_reason = visit_reason;
        this.visit_date = visit_date;
        this.visit_time = visit_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVisitor_names() {
        return visitor_names;
    }

    public void setVisitor_names(String visitor_names) {
        this.visitor_names = visitor_names;
    }

    public String getVisited_patient() {
        return visited_patient;
    }

    public void setVisited_patient(String visited_patient) {
        this.visited_patient = visited_patient;
    }

    public String getVisit_id() {
        return visit_id;
    }

    public void setVisit_id(String visit_id) {
        this.visit_id = visit_id;
    }

    public String getVisit_reason() {
        return visit_reason;
    }

    public void setVisit_reason(String visit_reason) {
        this.visit_reason = visit_reason;
    }

    public String getVisit_date() {
        return visit_date;
    }

    public void setVisit_date(String visit_date) {
        this.visit_date = visit_date;
    }

    public String getVisit_time() {
        return visit_time;
    }

    public void setVisit_time(String visit_time) {
        this.visit_time = visit_time;
    }
}
