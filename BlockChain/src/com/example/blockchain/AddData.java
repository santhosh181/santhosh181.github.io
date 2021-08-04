package com.example.blockchain;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddData extends Activity {

	EditText e1, e2, e3;
	Button b1;
	String newString;
	LoginDataBaseAdapter loginDataBaseAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_data);
		if (savedInstanceState == null) {
	         Bundle extras = getIntent().getExtras();
	         if(extras == null) {
	             newString= null;
	         } else {
	             newString= extras.getString("name");
	         }
	     } else {
	         newString= (String) savedInstanceState.getSerializable("name");
	         
	     }
		 System.out.println("session data********"+newString);
		
		// create a instance of SQLite Database
		loginDataBaseAdapter=new LoginDataBaseAdapter(this);
		loginDataBaseAdapter=loginDataBaseAdapter.open();
		
		e1 = (EditText)findViewById(R.id.editText1);
		e2 = (EditText)findViewById(R.id.editText2);
		e3 = (EditText)findViewById(R.id.editText3);
		b1 = (Button)findViewById(R.id.button1);
		
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				String name=e1.getText().toString();
				String date=e2.getText().toString();
				String time=e3.getText().toString();
				
				if(name.equals("") || date.equals("") || time.equals(""))
				{
					Toast.makeText(getApplicationContext(), "Pleas fill all the data", Toast.LENGTH_LONG).show();
				}
				else
				{
					loginDataBaseAdapter.updateEntry(newString, name, date, time);
				}
				
				
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_data, menu);
		return true;
	}

}
