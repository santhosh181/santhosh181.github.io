package com.example.blockchain;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
 
public class LoginDataBaseAdapter
{
static final String DATABASE_NAME = "blockc.db";
static final int DATABASE_VERSION = 1;
public static final int NAME_COLUMN = 1;
// TODO: Create public field for each column in your table.
// SQL Statement to create a new database.
static final String DATABASE_CREATE = "create table "+"LOGINDATA"+
"( " +"ID"+" integer primary key autoincrement,"+ "USERNAME text,ACCNO text, PASSWORD text,PKEY text, ADDNAME text, DATEVAL text, TIMEVAL text ); ";


// Variable to hold the database instance
public SQLiteDatabase db;
// Context of the application using the database.
private final Context context;
// Database open/upgrade helper
private DataBaseHelper dbHelper;
public LoginDataBaseAdapter(Context _context)
{
context = _context;
dbHelper = new DataBaseHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
}
public LoginDataBaseAdapter open() throws SQLException
{
db = dbHelper.getWritableDatabase();
return this;
}
public void close()
{
db.close();
}
 
public SQLiteDatabase getDatabaseInstance()
{
return db;
}
 
public void insertEntry(String userName,String password, String confirmpassword, String privatekey)
{
ContentValues newValues = new ContentValues();
//Assign values for each row.
newValues.put("USERNAME", userName);
newValues.put("ACCNO",password);
newValues.put("PASSWORD",confirmpassword);
newValues.put("PKEY",privatekey);
newValues.put("ADDNAME",privatekey);
newValues.put("DATEVAL",privatekey);
newValues.put("TIMEVAL",privatekey);
// Insert the row into your table
db.insert("LOGINDATA", null, newValues);
///Toast.makeText(context, "Reminder Is Successfully Saved", Toast.LENGTH_LONG).show();
}

public void insertEntryData(String userName,String password, String confirmpassword, String privatekey)
{
ContentValues newValues = new ContentValues();
// Assign values for each row.

//Assign values for each row.
newValues.put("USERNAME", userName);
newValues.put("NAM",password);
newValues.put("DATEVAL",confirmpassword);
newValues.put("TIMEVAL",privatekey);

 
// Insert the row into your table
db.insert("USERDATA", null, newValues);
///Toast.makeText(context, "Reminder Is Successfully Saved", Toast.LENGTH_LONG).show();
}

public int deleteEntry(String UserName)
{
//String id=String.valueOf(ID);
String where="USERNAME=?";
int numberOFEntriesDeleted= db.delete("LOGIN", where, new String[]{UserName}) ;
// Toast.makeText(context, "Number fo Entry Deleted Successfully : "+numberOFEntriesDeleted, Toast.LENGTH_LONG).show();
return numberOFEntriesDeleted;
}
public String getSinlgeEntry(String userName)
{
Cursor cursor=db.query("LOGINDATA", null, " USERNAME=?", new String[]{userName}, null, null, null);
if(cursor.getCount()<1) // UserName Not Exist
{
cursor.close();
return "NOT EXIST";
}
cursor.moveToFirst();
String password= cursor.getString(cursor.getColumnIndex("PASSWORD"));
cursor.close();
return password;
}
public String getSinlgeKey(String userName)
{
Cursor cursor=db.query("LOGINDATA", null, " USERNAME=?", new String[]{userName}, null, null, null);
if(cursor.getCount()<1) // UserName Not Exist
{
cursor.close();
return "NOT EXIST";
}
cursor.moveToFirst();
String password= cursor.getString(cursor.getColumnIndex("PKEY"));
cursor.close();
return password;
}

public String getMultiEntry(String userName)
{
Cursor cursor=db.query("LOGINDATA", null, " USERNAME=?", new String[]{userName}, null, null, null);
if(cursor.getCount()<1) // UserName Not Exist
{
cursor.close();
return "NOT EXIST";
}
cursor.moveToFirst();
String name= cursor.getString(cursor.getColumnIndex("ADDNAME"));
String dateval= cursor.getString(cursor.getColumnIndex("DATEVAL"));
String timeval= cursor.getString(cursor.getColumnIndex("TIMEVAL"));

String rr= "Name :"+name+ " Date : "+dateval+ " Time: "+timeval;

cursor.close();
return rr;
}

public void updateEntry(String userName,String addname, String dateval, String timeval)
{
// Define the updated row content.
ContentValues updatedValues = new ContentValues();
// Assign values for each row.
updatedValues.put("ADDNAME", addname);
updatedValues.put("DATEVAL",dateval);
updatedValues.put("TIMEVAL",timeval);
 
String where="USERNAME = ?";
db.update("LOGINDATA",updatedValues, where, new String[]{userName});
}
}