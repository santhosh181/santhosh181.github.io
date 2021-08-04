package com.example.blockchain;


import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final Context context = this.getApplicationContext() ;
		new Thread( new Runnable() {
			@Override
			public void run() {
				while( Thread.currentThread().isInterrupted() == false ) {
					try {
						Thread.sleep( 3000 );
						Intent launcher = new Intent( context , Selection.class );
						startActivity( launcher );
					} catch ( InterruptedException e ) {
						//Log.e( Utils.m_appError , "Problem is starting GPS locator" );
						e.printStackTrace();
					}
					Thread.currentThread().interrupt();
				}
			}
		}, "Splash Thread").start(); 
	
	}
}
	