package com.example.mario.raizin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;


public class userInfo extends AppCompatActivity {

    EditText editTextFirstName;
    EditText editTextLastName;
    EditText editTextPassword;
    EditText editTextEmailAddress;
    Button nextButtonObject;
    Button cancelButtonObject;
    SharedPreferences sharedPreferences;
    boolean firstNameCheck;
    boolean lastNameCheck;
    boolean passWordCheck;
    boolean emailAddressCheck;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);


        editTextFirstName=(EditText)findViewById(R.id.firstNameID);
        editTextLastName=(EditText)findViewById(R.id.lastNameID);
        editTextPassword=(EditText)findViewById(R.id.passwordID);
        editTextEmailAddress=(EditText)findViewById(R.id.emailAddressID);
        nextButtonObject=(Button)findViewById(R.id.nextButton);
        cancelButtonObject=(Button)findViewById(R.id.cancelButton);

        nextButtonObject.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                //SQLiteDatabase myDataBase = openOrCreateDatabase("Database", MODE_PRIVATE, null);
                //myDataBase.execSQL("CREATE TABLE IF NOT EXISTS UserInfoTable(firstName VARCHAR, lastName VARCHAR, password VARCHAR, email VARCHAR);");
                //SharedPreferences.Editor editor = sharedPreferences.edit();
                String firstNameRetrieve = editTextFirstName.getText().toString();
                if(!TextUtils.isEmpty(firstNameRetrieve)) {
                    //editor.putString(firstNameString, firstNameRetrieve);
                    firstNameCheck=true;
                }
                else{
                    Toast.makeText(getApplicationContext(), "Please enter a proper first name", Toast.LENGTH_SHORT).show();
                    firstNameCheck=false;
                }

                String lastNameRetrieve=editTextLastName.getText().toString();
                if(!TextUtils.isEmpty(lastNameRetrieve)) {
                    //editor.putString(lastNameString, lastNameRetrieve);
                    lastNameCheck=true;
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Please enter a proper last name", Toast.LENGTH_SHORT).show();
                    lastNameCheck=false;
                }
                String passwordRetrieve = editTextPassword.getText().toString();
                if(!TextUtils.isEmpty(passwordRetrieve))
                {
                    //editor.putString(passwordString, passwordRetrieve);
                    passWordCheck=true;
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Please enter a proper password", Toast.LENGTH_SHORT).show();
                    passWordCheck=false;
                }

                String emailAddressRetrieve=editTextEmailAddress.getText().toString();
                if(!TextUtils.isEmpty(emailAddressRetrieve))
                {
                    //need to check whether what the user typed is indeed an email addres
                    for(int i=0; i<=emailAddressRetrieve.length()-1; i++)
                    {
                        if((emailAddressRetrieve.charAt(0)!='@')&&(emailAddressRetrieve.charAt(i)=='@')&&(emailAddressRetrieve.charAt(i+1)=='g')&&(emailAddressRetrieve.charAt(i+2)=='m')&&(emailAddressRetrieve.charAt(i+3)=='a')&&(emailAddressRetrieve.charAt(i+4)=='i')&&(emailAddressRetrieve.charAt(i+5)=='l')&&(emailAddressRetrieve.charAt(i+6)=='.')&&(emailAddressRetrieve.charAt(i+7)=='c')&&(emailAddressRetrieve.charAt(i+8)=='o')&&(emailAddressRetrieve.charAt(i+9)=='m'))
                        {
                            //editor.putString(emailAddressString, emailAddressRetrieve);
                            emailAddressCheck=true;
                            //Toast.makeText(getApplicationContext(), "gmail.com match found", Toast.LENGTH_SHORT).show();
                            break;
                        }
                        else if((emailAddressRetrieve.charAt(0)!='@')&&(emailAddressRetrieve.charAt(i)=='@')&&(emailAddressRetrieve.charAt(i+1)=='g')&&(emailAddressRetrieve.charAt(i+2)=='m')&&(emailAddressRetrieve.charAt(i+3)=='a')&&(emailAddressRetrieve.charAt(i+4)=='i')&&(emailAddressRetrieve.charAt(i+5)=='l')&&(emailAddressRetrieve.charAt(i+6)=='.')&&(emailAddressRetrieve.charAt(i+7)=='c')&&(emailAddressRetrieve.charAt(i+8)=='a'))
                        {
                            //editor.putString(emailAddressString, emailAddressRetrieve);
                            emailAddressCheck=true;
                            //Toast.makeText(getApplicationContext(), "gmail.ca match found", Toast.LENGTH_SHORT).show();
                            break;
                        }
                        else if((emailAddressRetrieve.charAt(0)!='@')&&(emailAddressRetrieve.charAt(i)=='@')&&(emailAddressRetrieve.charAt(i+1)=='o')&&(emailAddressRetrieve.charAt(i+2)=='u')&&(emailAddressRetrieve.charAt(i+3)=='t')&&(emailAddressRetrieve.charAt(i+4)=='l')&&(emailAddressRetrieve.charAt(i+5)=='o')&&(emailAddressRetrieve.charAt(i+6)=='o')&&(emailAddressRetrieve.charAt(i+7)=='o')&&(emailAddressRetrieve.charAt(i+8)=='k')&&(emailAddressRetrieve.charAt(i+9)=='.')&&(emailAddressRetrieve.charAt(i+10)=='c')&&(emailAddressRetrieve.charAt(i+11)=='o')&&(emailAddressRetrieve.charAt(i+12)=='m'))
                        {
                            //editor.putString(emailAddressString, emailAddressRetrieve);
                            emailAddressCheck=true;
                            //Toast.makeText(getApplicationContext(), "outlook.com match found", Toast.LENGTH_SHORT).show();
                            break;
                        }
                        else if((emailAddressRetrieve.charAt(0)!='@')&&(emailAddressRetrieve.charAt(i)=='@')&&(emailAddressRetrieve.charAt(i+1)=='o')&&(emailAddressRetrieve.charAt(i+2)=='u')&&(emailAddressRetrieve.charAt(i+3)=='t')&&(emailAddressRetrieve.charAt(i+4)=='l')&&(emailAddressRetrieve.charAt(i+5)=='o')&&(emailAddressRetrieve.charAt(i+6)=='o')&&(emailAddressRetrieve.charAt(i+7)=='o')&&(emailAddressRetrieve.charAt(i+8)=='k')&&(emailAddressRetrieve.charAt(i+9)=='.')&&(emailAddressRetrieve.charAt(i+10)=='c')&&(emailAddressRetrieve.charAt(i+11)=='a'))
                        {
                            //editor.putString(emailAddressString, emailAddressRetrieve);
                            emailAddressCheck=true;
                            //Toast.makeText(getApplicationContext(), "outlook.ca match found", Toast.LENGTH_SHORT).show();
                            break;
                        }
                        else if((emailAddressRetrieve.charAt(0)!='@')&&(emailAddressRetrieve.charAt(i)=='@')&&(emailAddressRetrieve.charAt(i+1)=='h')&&(emailAddressRetrieve.charAt(i+2)=='o')&&(emailAddressRetrieve.charAt(i+3)=='t')&&(emailAddressRetrieve.charAt(i+4)=='m')&&(emailAddressRetrieve.charAt(i+5)=='a')&&(emailAddressRetrieve.charAt(i+6)=='i')&&(emailAddressRetrieve.charAt(i+7)=='l')&&(emailAddressRetrieve.charAt(i+8)=='.')&&(emailAddressRetrieve.charAt(i+9)=='c')&&(emailAddressRetrieve.charAt(i+10)=='o')&&(emailAddressRetrieve.charAt(i+11)=='m'))
                        {
                            //editor.putString(emailAddressString, emailAddressRetrieve);
                            emailAddressCheck=true;
                            //Toast.makeText(getApplicationContext(), "hotmail.com match found", Toast.LENGTH_SHORT).show();
                            break;
                        }
                        else if((emailAddressRetrieve.charAt(0)!='@')&&(emailAddressRetrieve.charAt(i)=='@')&&(emailAddressRetrieve.charAt(i+1)=='h')&&(emailAddressRetrieve.charAt(i+2)=='o')&&(emailAddressRetrieve.charAt(i+3)=='t')&&(emailAddressRetrieve.charAt(i+4)=='m')&&(emailAddressRetrieve.charAt(i+5)=='a')&&(emailAddressRetrieve.charAt(i+6)=='i')&&(emailAddressRetrieve.charAt(i+7)=='l')&&(emailAddressRetrieve.charAt(i+8)=='.')&&(emailAddressRetrieve.charAt(i+9)=='c')&&(emailAddressRetrieve.charAt(i+10)=='a'))
                        {
                            //editor.putString(emailAddressString, emailAddressRetrieve);
                            emailAddressCheck=true;
                            //Toast.makeText(getApplicationContext(), "hotmail.ca match found", Toast.LENGTH_SHORT).show();
                            break;
                        }
                        else if(i==(emailAddressRetrieve.length()-1))
                        {

                            emailAddressCheck=false;
                            Toast.makeText(getApplicationContext(), "Please enter a proper email address", Toast.LENGTH_SHORT).show();
                            break;
                        }
                    }
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Please enter a proper email address", Toast.LENGTH_SHORT).show();
                    emailAddressCheck=false;
                }
                if(firstNameCheck==true&&lastNameCheck==true&&passWordCheck==true&&emailAddressCheck==true) {
                    //editor.putString(emailAddressString, emailAddressRetrieve);
                    //editor.commit();


                    Intent intent = new Intent(getApplicationContext(), SkinTypeDeterminationActivity.class);
                    intent.putExtra("firstNameRetrieve", firstNameRetrieve);
                    intent.putExtra("lastNameRetrieve", lastNameRetrieve);
                    intent.putExtra("passwordRetrieve", passwordRetrieve);
                    intent.putExtra("emailAddressRetrieve", emailAddressRetrieve);
                    startActivity(intent);

                }
            }
        });
        cancelButtonObject.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {

                Intent intent = new Intent(getApplicationContext(), LoginorSignUpActivity.class);
                startActivity(intent);
            }
        });
    }
}
