package com.chrisberry.mrmglass;

import static com.chrisberry.mrmglass.Constant.Customer_Address;
import static com.chrisberry.mrmglass.Constant.Customer_CSZ;
import static com.chrisberry.mrmglass.Constant.Customer_Name;
import static com.chrisberry.mrmglass.Constant.Customer_PhoneNumber;
import static com.chrisberry.mrmglass.Constant.WorkOrder_Number;

import java.util.ArrayList;
import java.util.HashMap;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;



public class ListCardsScrollActivity extends Activity {
	protected static final String TAG = null;
	ListView listView;
	TableLayout tbLayout;
	LinearLayout ll;
	TableLayout layout_table;
	GridView gridView;
	private ArrayList<HashMap> list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		final ListView lview = (ListView) findViewById(R.id.listview);
		
		populateList();
		listviewAdapter adapter = new listviewAdapter(this, list);
		lview.setAdapter(adapter);
		lview.setClickable(true);
		
		lview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				TextView _custNum = (TextView) view.findViewById(R.id.CustomerName);
				TextView _phNum = (TextView) view.findViewById(R.id.CustomerPhoneNumber);
				// Launch Activity with Call ahead
				Log.d(TAG, "Work Order tapped: " + _phNum.getText());	
				// I would like to be able to see if I could put a listener on the call, also return to this activity after the call is complete
				Intent localIntent = new Intent();
				localIntent.putExtra("com.google.glass.extra.PHONE_NUMBER",_phNum.getText());
				localIntent.setAction("com.google.glass.action.CALL_DIAL");
				sendBroadcast(localIntent);
				Toast.makeText(getBaseContext(),String.format("Calling %s @ %s",_custNum.getText(), _phNum.getText()),Toast.LENGTH_SHORT).show();
			}
		});
	}

	private void populateList() {
		list = new ArrayList<HashMap>();

		HashMap temp = new HashMap();
		temp.put(Customer_Name, "Jane Smith");
		temp.put(WorkOrder_Number, "WO: 616222");
		temp.put(Customer_Address, "1234 South Maple St");
		temp.put(Customer_CSZ, "Columbus, OH 43213");
		temp.put(Customer_PhoneNumber, "614-281-8211");
		list.add(temp);

		HashMap temp1 = new HashMap();
		temp1.put(Customer_Name, "John Jones");
		temp1.put(WorkOrder_Number, "WO: 616395");
		temp1.put(Customer_Address, "12 Apple St. Apt.# 6");
		temp1.put(Customer_CSZ, "Columbus, OH 43232");
		temp1.put(Customer_PhoneNumber, "614-281-8211");
		list.add(temp1);

		HashMap temp2 = new HashMap();
		temp2.put(Customer_Name, "Mike Smith");
		temp2.put(WorkOrder_Number, "WO: 616397");
		temp2.put(Customer_Address, "2469 Michael Dr");
		temp2.put(Customer_CSZ, "Dublin, OH 43212");
		temp2.put(Customer_PhoneNumber, "614-281-8211");
		list.add(temp2);

		HashMap temp3 = new HashMap();
		temp3.put(Customer_Name, "Eric Metcalf");
		temp3.put(WorkOrder_Number, "WO: 616312");
		temp3.put(Customer_Address, "100 Alfred Lerner Way");
		temp3.put(Customer_CSZ, "Cleveland, OH 43212");
		temp3.put(Customer_PhoneNumber, "614-281-8211");
		list.add(temp3);

		HashMap temp4 = new HashMap();
		temp4.put(Customer_Name, "Susan Ware");
		temp4.put(WorkOrder_Number, "WO: 616999");
		temp4.put(Customer_Address, "411 Woody Hayes Dr");
		temp4.put(Customer_CSZ, "Columbus, OH 43212");
		temp4.put(Customer_PhoneNumber, "614-281-8211");
		list.add(temp4);

	}
}