package com.example.mario.raizin;

import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class LoginVerification extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_verification);
        Intent in=getIntent();
        String passWordRetrieve=in.getStringExtra("passWordRetrieve");
        String emailRetrieve=in.getStringExtra("emailAddressRetrieve");

        SQLiteDatabase myDataBase = openOrCreateDatabase("Database", MODE_PRIVATE, null);
        Cursor result = myDataBase.rawQuery("Select * from UserTable", null);
        long numberOfRows= DatabaseUtils.queryNumEntries(myDataBase, "UserTable");

            result.moveToLast();
            String password = result.getString(0);              //store the value of the first column into a string called courseID
            String email = result.getString(1);           //store the value of the second column into a string called courseTitle
            if ((passWordRetrieve.equals(password)) && (emailRetrieve.equals(email))) {
                //openHomeFeed();
                Intent intent = new Intent(getApplicationContext(), HomeFeed.class);
                startActivity(intent);
            } else {

                Toast.makeText(getApplicationContext(), "Please enter proper credentials", Toast.LENGTH_SHORT).show();
            /*Toast.makeText(getApplicationContext(), password, Toast.LENGTH_SHORT).show();
            Toast.makeText(getApplicationContext(), email, Toast.LENGTH_SHORT).show();
            Toast.makeText(getApplicationContext(), passWordRetrieve, Toast.LENGTH_SHORT).show();
            Toast.makeText(getApplicationContext(), emailRetrieve, Toast.LENGTH_SHORT).show();*/
                Intent back = new Intent(getApplicationContext(), LoginorSignUpActivity.class);
                startActivity(back);
            }
    }
}
