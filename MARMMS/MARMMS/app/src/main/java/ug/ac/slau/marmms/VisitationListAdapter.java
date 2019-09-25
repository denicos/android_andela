package ug.ac.slau.marmms;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class VisitationListAdapter extends BaseAdapter{
    private Context context;
    private int layout;
    private ArrayList<VisitationRecordModel> recordList;

    public VisitationListAdapter(Context context, int layout, ArrayList<VisitationRecordModel> recordList) {
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
        TextView visitor_names, visited_patient, visit_id, visit_reason, visit_date, visit_time;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View custom_list_row = view;
        ViewHolder holder = new ViewHolder();

        if(custom_list_row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            custom_list_row = inflater.inflate(layout, null);

            holder.visitor_names = (TextView) custom_list_row.findViewById(R.id.visitor_names);
            holder.visited_patient = (TextView) custom_list_row.findViewById(R.id.visited_patient);
            holder.visit_id = (TextView) custom_list_row.findViewById(R.id.visit_id);
            holder.visit_reason = (TextView) custom_list_row.findViewById(R.id.visit_reason);
            holder.visit_date = (TextView) custom_list_row.findViewById(R.id.visit_date);
            holder.visit_time = (TextView) custom_list_row.findViewById(R.id.visit_time);

            custom_list_row.setTag(holder);
        } else {
            holder = (ViewHolder) custom_list_row.getTag();
        }

        VisitationRecordModel visitationRecordModel = recordList.get(i);

        holder.visitor_names.setText(visitationRecordModel.getVisitor_names());
        holder.visited_patient.setText(visitationRecordModel.getVisited_patient());
        holder.visit_id.setText(visitationRecordModel.getVisit_id());
        holder.visit_reason.setText(visitationRecordModel.getVisit_reason());
        holder.visit_date.setText(visitationRecordModel.getVisit_date());
        holder.visit_time.setText(visitationRecordModel.getVisit_time());

        return custom_list_row;
    }
}
