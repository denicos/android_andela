package ug.ac.slau.marmms;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class PatientsListAdapter extends BaseAdapter{
    private Context context;
    private int layout;
    private ArrayList<PatientModel> recordList;

    public PatientsListAdapter(Context context, int layout, ArrayList<PatientModel> recordList) {
        this.context = context;
        this.layout = layout;
        this.recordList = recordList;
    }

    @Override
    public int getCount() {
        return recordList.size();
    }

    @Override
    public Object getItem(int i) {
        return recordList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    private class ViewHolder {
        TextView patient_names, gender, nationality, address, email, phone_number, arrival_date, call_patient, message_patient;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View custom_list_row = view;
        ViewHolder holder = new ViewHolder();

        if(custom_list_row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            custom_list_row = inflater.inflate(layout, null);

            holder.patient_names = (TextView) custom_list_row.findViewById(R.id.patient_names);
            holder.gender = (TextView) custom_list_row.findViewById(R.id.gender);
            holder.nationality = (TextView) custom_list_row.findViewById(R.id.nationality);
            holder.address = (TextView) custom_list_row.findViewById(R.id.address);
            holder.email = (TextView) custom_list_row.findViewById(R.id.email);
            holder.phone_number = (TextView) custom_list_row.findViewById(R.id.phone_number);
            holder.arrival_date = (TextView) custom_list_row.findViewById(R.id.arrival_date);
            holder.call_patient = (TextView) custom_list_row.findViewById(R.id.message_patient);
            holder.message_patient = (TextView) custom_list_row.findViewById(R.id.message_patient);

            custom_list_row.setTag(holder);
        } else {
            holder = (ViewHolder) custom_list_row.getTag();
        }

        PatientModel patientModel = recordList.get(i);

        holder.patient_names.setText(patientModel.getPatient_names());
        holder.gender.setText(patientModel.getGender());
        holder.nationality.setText(patientModel.getNationality());
        holder.address.setText(patientModel.getAddress());
        holder.email.setText(patientModel.getEmail());
        holder.phone_number.setText(patientModel.getPhone_number());
        holder.arrival_date.setText(patientModel.getArrival_date());

        return custom_list_row;
    }
}
