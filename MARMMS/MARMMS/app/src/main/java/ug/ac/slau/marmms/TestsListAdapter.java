package ug.ac.slau.marmms;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class TestsListAdapter extends BaseAdapter{
    private Context context;
    private int layout;
    private ArrayList<TestModel> recordList;

    public TestsListAdapter(Context context, int layout, ArrayList<TestModel> recordList) {
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
        TextView test_names, patient_names, test_date, test_time, test_id, test_results;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View custom_list_row = view;
        ViewHolder holder = new ViewHolder();

        if(custom_list_row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            custom_list_row = inflater.inflate(layout, null);

            holder.test_names = (TextView) custom_list_row.findViewById(R.id.test_names);
            holder.patient_names = (TextView) custom_list_row.findViewById(R.id.patient_names);
            holder.test_date = (TextView) custom_list_row.findViewById(R.id.test_date);
            holder.test_time = (TextView) custom_list_row.findViewById(R.id.test_time);
            holder.test_id = (TextView) custom_list_row.findViewById(R.id.test_id);
            holder.test_results = (TextView) custom_list_row.findViewById(R.id.test_results);

            custom_list_row.setTag(holder);
        } else {
            holder = (ViewHolder) custom_list_row.getTag();
        }

        TestModel testModel = recordList.get(i);

        holder.test_names.setText(testModel.getTest_names());
        holder.patient_names.setText(testModel.getPatient_names());
        holder.test_date.setText(testModel.getTest_date());
        holder.test_time.setText(testModel.getTest_time());
        holder.test_id.setText(testModel.getTest_id());
        holder.test_results.setText(testModel.getTest_results());

        return custom_list_row;
    }
}
