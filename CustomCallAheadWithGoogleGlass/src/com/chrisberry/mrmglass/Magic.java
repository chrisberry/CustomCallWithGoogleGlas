/*
 * Magic.java
 * @author Cody Engel
 * http://codyengel.info
 * 
 * This is the service which is started from HelloGlass.java, this is where the magic happens.
 */
package com.chrisberry.mrmglass;

import java.util.ArrayList;
import java.util.Arrays;

import com.google.android.glass.app.Card;
import com.google.android.glass.widget.CardScrollAdapter;
import com.google.android.glass.widget.CardScrollView;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class Magic extends Activity {
	protected static final String TAG = null;
	private ArrayList<Card> mlcCards = new ArrayList<Card>();
	//Add to the array to extend the number of cards
	private ArrayList<String> mlsText = new ArrayList<String>(Arrays.asList("Hello", "Work Orders"));


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		for (int i = 0; i < mlsText.size(); i++) {
			Card newCard = new Card(this);
			newCard.setImageLayout(Card.ImageLayout.FULL);
			newCard.setText(mlsText.get(i));
			if (i == 0) {
				newCard.setFootnote("Tech ID: 1817-509");
			}
			if(i==1)
			{
				newCard.setFootnote("tap to get orders");
				
			}
			mlcCards.add(newCard);
		}

		CardScrollView csvCardsView = new CardScrollView(this);
		csaAdapter cvAdapter = new csaAdapter();
		csvCardsView.setAdapter(cvAdapter);
		csvCardsView.activate();
		csvCardsView.setOnItemClickListener(new OnItemClickListener()
        {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
                Log.d(TAG, "item tapped: "+pos); 
                Toast.makeText(getBaseContext(),String.format("Loading work orders..."),Toast.LENGTH_LONG).show();
                Intent i = new Intent(Magic.this, ListCardsScrollActivity.class);
                startActivity(i);
            }
        });
		setContentView(csvCardsView);
	}

	
	
	private class csaAdapter extends CardScrollAdapter {
		@Override
		public int findIdPosition(Object id) {
			return -1;
		}

		@Override
		public int findItemPosition(Object item) {
			return mlcCards.indexOf(item);
		}

		@Override
		public int getCount() {
			return mlcCards.size();
		}

		@Override
		public Object getItem(int position) {
			return mlcCards.get(position);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			return mlcCards.get(position).toView();
		}

	}
}
