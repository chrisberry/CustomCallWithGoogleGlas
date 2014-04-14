package com.chrisberry.mrmglass;
import static com.chrisberry.mrmglass.Constant.Customer_Name;
import static com.chrisberry.mrmglass.Constant.Customer_CSZ;
import static com.chrisberry.mrmglass.Constant.Customer_Address;
import static com.chrisberry.mrmglass.Constant.Customer_PhoneNumber;
import static com.chrisberry.mrmglass.Constant.WorkOrder_Number;
 
import java.util.ArrayList;
import java.util.HashMap;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
 

public class listviewAdapter extends BaseAdapter
{
    public ArrayList<HashMap> list;
    Activity activity;
 
    public listviewAdapter(Activity activity, ArrayList<HashMap> list) {
        super();
        this.activity = activity;
        this.list = list;
    }
 
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return list.size();
    }
 
    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return list.get(position);
    }
 
    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }
 
    private class ViewHolder {
           TextView txtFirst;
           TextView txtSecond;
           TextView txtThird;
           TextView txtFourth;
           TextView txtFifth;
      }
 
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
              ViewHolder holder;
                LayoutInflater inflater =  activity.getLayoutInflater();
 
                if (convertView == null)
                {
                    convertView = inflater.inflate(R.layout.list_mobile, null);
                    holder = new ViewHolder();
                    holder.txtFirst = (TextView) convertView.findViewById(R.id.CustomerName);
                    holder.txtSecond = (TextView) convertView.findViewById(R.id.WorkOrderNumber);
                    holder.txtThird = (TextView) convertView.findViewById(R.id.CustomerAddress);
                    holder.txtFourth = (TextView) convertView.findViewById(R.id.CustomerCSZ);
                    holder.txtFifth = (TextView) convertView.findViewById(R.id.CustomerPhoneNumber);
                    convertView.setTag(holder);
                }
                else
                {
                    holder = (ViewHolder) convertView.getTag();
                }
 
                HashMap map = list.get(position);
               
                holder.txtFirst.setText(map.get(Customer_Name).toString());
                holder.txtSecond.setText(map.get(WorkOrder_Number).toString());
                holder.txtThird.setText(map.get(Customer_Address).toString());
                holder.txtFourth.setText(map.get(Customer_CSZ).toString());
                holder.txtFifth.setText(map.get(Customer_PhoneNumber).toString());
            return convertView;
    }
 
}
