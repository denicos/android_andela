package ug.ac.slau.marmms;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class AppointmentsListAdapter extends BaseAdapter{
    private Context context;
    private int layout;
    private ArrayList<AppointmentModel> recordList;

    public AppointmentsListAdapter(Context context, int layout, ArrayList<AppointmentModel> recordList) {
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
        TextView patient_names, appointment_date, appointment_time, appointment_reason;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View custom_list_row = view;
        ViewHolder holder = new ViewHolder();

        if(custom_list_row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            custom_list_row = inflater.inflate(layout, null);

            holder.patient_names = (TextView) custom_list_row.findViewById(R.id.patient_names);
            holder.appointment_date = (TextView) custom_list_row.findViewById(R.id.appointment_date);
            holder.appointment_time = (TextView) custom_list_row.findViewById(R.id.appointment_time);
            holder.appointment_reason = (TextView) custom_list_row.findViewById(R.id.appointment_reason);

            custom_list_row.setTag(holder);
        } else {
            holder = (ViewHolder) custom_list_row.getTag();
        }

        AppointmentModel appointmentModel = recordList.get(i);

        holder.patient_names.setText(appointmentModel.getPatient_names());
        holder.appointment_date.setText(appointmentModel.getAppointment_date());
        holder.appointment_time.setText(appointmentModel.getAppointment_time());
        holder.appointment_reason.setText(appointmentModel.getAppointment_reason());

        return custom_list_row;
    }
}
