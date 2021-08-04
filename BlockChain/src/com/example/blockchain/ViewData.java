package com.example.blockchain;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ViewData extends Activity {
	String newString;
	Button b1;
	TextView t1;
	LoginDataBaseAdapter loginDataBaseAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_data);
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
		b1 = (Button)findViewById(R.id.button1);
		t1=(TextView)findViewById(R.id.textView1);
		
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String storedPassword=loginDataBaseAdapter.getMultiEntry(newString);
				Toast.makeText(getApplicationContext(), storedPassword, Toast.LENGTH_LONG).show();
				t1.setText(storedPassword);
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.view_data, menu);
		return true;
	}

}
