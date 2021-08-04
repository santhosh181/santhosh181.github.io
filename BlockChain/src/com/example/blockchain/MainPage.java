package com.example.blockchain;

import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainPage extends Activity {
	
	Button b1, b2, b3;
	String newString;	
	LoginDataBaseAdapter loginDataBaseAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_page);
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
		
		
		b1=(Button)findViewById(R.id.button1);
		b2=(Button)findViewById(R.id.button2);
		b3=(Button)findViewById(R.id.button3);
		
	}
		public void locker(View V)
		{
		final Dialog dialog = new Dialog(MainPage.this);
		dialog.setContentView(R.layout.activity_key);
		dialog.setTitle("Private Key Access");
		 
		// get the Refferences of views
		final EditText editTextUserName=(EditText)dialog.findViewById(R.id.editText1);
	
		 
		Button btnSignIn=(Button)dialog.findViewById(R.id.button1);
		 
		// Set On ClickListener
		btnSignIn.setOnClickListener(new View.OnClickListener() {
		 
		public void onClick(View v) {
		// get The User name and Password
		String password=editTextUserName.getText().toString();
		
		 
		// fetch the Password form database for respective user name
		String storedPassword=loginDataBaseAdapter.getSinlgeKey(newString);
		 
		// check if the Stored password matches with Password entered by user
		if(password.equals(storedPassword))
		{
		Intent i=new Intent(MainPage.this, Locker.class);
		i.putExtra("name", newString);
		startActivity(i);
		}
		else
		{
		Toast.makeText(MainPage.this, "User Name or Password does not match", Toast.LENGTH_LONG).show();
		}
		}
		});
		 
		dialog.show();
		}
		
		
		//add Data
		public void adddata(View V)
		{
		final Dialog dialog = new Dialog(MainPage.this);
		dialog.setContentView(R.layout.activity_key);
		dialog.setTitle("Private Key Access");
		 
		// get the Refferences of views
		final EditText editTextUserName=(EditText)dialog.findViewById(R.id.editText1);
	
		 
		Button btnSignIn=(Button)dialog.findViewById(R.id.button1);
		 
		// Set On ClickListener
		btnSignIn.setOnClickListener(new View.OnClickListener() {
		 
		public void onClick(View v) {
		// get The User name and Password
		String password=editTextUserName.getText().toString();
		
		 
		// fetch the Password form database for respective user name
		String storedPassword=loginDataBaseAdapter.getSinlgeKey(newString);
		 
		// check if the Stored password matches with Password entered by user
		if(password.equals(storedPassword))
		{
		Intent i=new Intent(MainPage.this, AddData.class);
		i.putExtra("name", newString);
		startActivity(i);
		}
		else
		{
		Toast.makeText(MainPage.this, "User Name or Password does not match", Toast.LENGTH_LONG).show();
		}
		}
		});
		 
		dialog.show();
		}
		
		//add Data
				public void viewdata(View V)
				{
				final Dialog dialog = new Dialog(MainPage.this);
				dialog.setContentView(R.layout.activity_key);
				dialog.setTitle("Private Key Access");
				 
				// get the Refferences of views
				final EditText editTextUserName=(EditText)dialog.findViewById(R.id.editText1);
			
				 
				Button btnSignIn=(Button)dialog.findViewById(R.id.button1);
				 
				// Set On ClickListener
				btnSignIn.setOnClickListener(new View.OnClickListener() {
				 
				public void onClick(View v) {
				// get The User name and Password
				String password=editTextUserName.getText().toString();
				
				 
				// fetch the Password form database for respective user name
				String storedPassword=loginDataBaseAdapter.getSinlgeKey(newString);
				 
				// check if the Stored password matches with Password entered by user
				if(password.equals(storedPassword))
				{
				Intent i=new Intent(MainPage.this, ViewData.class);
				i.putExtra("name", newString);
				startActivity(i);
				}
				else
				{
				Toast.makeText(MainPage.this, "User Name or Password does not match", Toast.LENGTH_LONG).show();
				}
				}
				});
				 
				dialog.show();
				}
				

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_page, menu);
		return true;
	}

}
