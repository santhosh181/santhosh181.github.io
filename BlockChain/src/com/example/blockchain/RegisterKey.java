package com.example.blockchain;
import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
 
public class RegisterKey extends Activity
{
EditText editTextUserName,editTextPassword,editTextConfirmPassword;
Button btnCreateAccount;
 
LoginDataBaseAdapter loginDataBaseAdapter;
@Override
protected void onCreate(Bundle savedInstanceState)
{
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_register_key);
 
// get Instance of Database Adapter
loginDataBaseAdapter=new LoginDataBaseAdapter(this);
loginDataBaseAdapter=loginDataBaseAdapter.open();
 
// Get Refferences of Views
editTextUserName=(EditText)findViewById(R.id.editText1);
editTextPassword=(EditText)findViewById(R.id.editText2);
editTextConfirmPassword=(EditText)findViewById(R.id.editText3);
 
btnCreateAccount=(Button)findViewById(R.id.button1);
btnCreateAccount.setOnClickListener(new View.OnClickListener() {
 
public void onClick(View v) {
// TODO Auto-generated method stub
 
String userName=editTextUserName.getText().toString();
String password=editTextPassword.getText().toString();
String confirmPassword=editTextConfirmPassword.getText().toString();

Random random = new Random();
int rand = 0;
while (true){
    rand = random.nextInt(1000000);
    if(rand !=0) break;
}
 String s=String.valueOf(rand);
// check if any of the fields are vaccant
if(userName.equals("")||password.equals("")||confirmPassword.equals(""))
{
Toast.makeText(getApplicationContext(), "Field Vaccant", Toast.LENGTH_LONG).show();
return;
}
else
{
// Save the Data in Database
loginDataBaseAdapter.insertEntry(userName, password, confirmPassword, s);
Toast.makeText(getApplicationContext(), "Account Successfully Created "+rand, Toast.LENGTH_LONG).show();
}
}
});
}
@Override
protected void onDestroy() {
// TODO Auto-generated method stub
super.onDestroy();
 
loginDataBaseAdapter.close();
}
}