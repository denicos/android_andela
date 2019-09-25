package ug.ac.slau.marmms;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class MedicationListAdapter extends BaseAdapter{
    private Context context;
    private int layout;
    private ArrayList<MedicationRecordModel> recordList;

    public MedicationListAdapter(Context context, int layout, ArrayList<MedicationRecordModel> recordList) {
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
        //        TextView  patient_names, gender;
        TextView medicine_names, patient_names, medication_id, reason, date_given, time_given;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View custom_list_row = view;
        ViewHolder holder = new ViewHolder();

        if(custom_list_row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            custom_list_row = inflater.inflate(layout, null);

            holder.medicine_names = (TextView) custom_list_row.findViewById(R.id.medicine_names);
            holder.patient_names = (TextView) custom_list_row.findViewById(R.id.patient_names);
            holder.medication_id = (TextView) custom_list_row.findViewById(R.id.medication_id);
            holder.reason = (TextView) custom_list_row.findViewById(R.id.reason);
            holder.date_given = (TextView) custom_list_row.findViewById(R.id.date_given);
            holder.time_given = (TextView) custom_list_row.findViewById(R.id.time_given);

            custom_list_row.setTag(holder);
        } else {
            holder = (ViewHolder) custom_list_row.getTag();
        }

        MedicationRecordModel medicationRecordModel = recordList.get(i);

        holder.medicine_names.setText(medicationRecordModel.getMedicine_names());
        holder.patient_names.setText(medicationRecordModel.getPatient_names());
        holder.medication_id.setText(medicationRecordModel.getMedication_id());
        holder.reason.setText(medicationRecordModel.getReason());
        holder.date_given.setText(medicationRecordModel.getDate_given());
        holder.time_given.setText(medicationRecordModel.getTime_given());

        return custom_list_row;
    }
}
