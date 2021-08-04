package com.example.blockchain;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Locker extends Activity {
EditText e1;
Button b1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_locker);
		
		e1=(EditText)findViewById(R.id.editText1);
		b1=(Button)findViewById(R.id.button1);
		
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				String amount=e1.getText().toString();
				if(amount.equals(""))
				{
					Toast.makeText(getApplicationContext(), "Please fill amount",Toast.LENGTH_LONG).show();				
				}
				else
				{
					Toast.makeText(getApplicationContext(), "Amount sent Successfully",Toast.LENGTH_LONG).show();
				}
			}
		
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.locker, menu);
		return true;
	}

}
