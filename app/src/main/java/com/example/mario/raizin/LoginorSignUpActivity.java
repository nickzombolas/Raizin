package com.example.mario.raizin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginorSignUpActivity extends AppCompatActivity {

    EditText editTextEmail;
    EditText editTextPassword;
    Button loginButtonObject;
    Button signUpButtonObject;
    boolean emailMatchChecked;
    boolean passwordMatchChecked;

   SharedPreferences sharedPreferences;

    public static final String DEFAULT_VALUE="default";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginor_sign_up);
        editTextEmail = findViewById(R.id.emailAddress);
        editTextPassword = findViewById(R.id.passWord);
        loginButtonObject = findViewById(R.id.loginButton);
        signUpButtonObject = findViewById(R.id.signUpButton);


        signUpButtonObject.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {

                Intent intent = new Intent(getApplicationContext(), userInfo.class);
                startActivity(intent);
            }
        });

        loginButtonObject.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                String emailRetrieve=editTextEmail.getText().toString();
                String passWordRetrieve=editTextPassword.getText().toString();
                //pass the emailRetrieve and the passWordRetrieve to the LoginVerification activity

                if(!TextUtils.isEmpty(emailRetrieve)) {
                    //need to check whether what the user typed is indeed an email addres
                    for(int i=0; i<=emailRetrieve.length()-1; i++)
                    {
                        if((emailRetrieve.charAt(0)!='@')&&(emailRetrieve.charAt(i)=='@')&&(emailRetrieve.charAt(i+1)=='g')&&(emailRetrieve.charAt(i+2)=='m')&&(emailRetrieve.charAt(i+3)=='a')&&(emailRetrieve.charAt(i+4)=='i')&&(emailRetrieve.charAt(i+5)=='l')&&(emailRetrieve.charAt(i+6)=='.')&&(emailRetrieve.charAt(i+7)=='c')&&(emailRetrieve.charAt(i+8)=='o')&&(emailRetrieve.charAt(i+9)=='m'))
                        {
                            //Toast.makeText(getApplicationContext(), "gmail.com match found", Toast.LENGTH_SHORT).show();
                            break;
                        }
                        else if((emailRetrieve.charAt(0)!='@')&&(emailRetrieve.charAt(i)=='@')&&(emailRetrieve.charAt(i+1)=='g')&&(emailRetrieve.charAt(i+2)=='m')&&(emailRetrieve.charAt(i+3)=='a')&&(emailRetrieve.charAt(i+4)=='i')&&(emailRetrieve.charAt(i+5)=='l')&&(emailRetrieve.charAt(i+6)=='.')&&(emailRetrieve.charAt(i+7)=='c')&&(emailRetrieve.charAt(i+8)=='a'))
                        {
                            //Toast.makeText(getApplicationContext(), "gmail.ca match found", Toast.LENGTH_SHORT).show();
                            break;
                        }
                        else if((emailRetrieve.charAt(0)!='@')&&(emailRetrieve.charAt(i)=='@')&&(emailRetrieve.charAt(i+1)=='o')&&(emailRetrieve.charAt(i+2)=='u')&&(emailRetrieve.charAt(i+3)=='t')&&(emailRetrieve.charAt(i+4)=='l')&&(emailRetrieve.charAt(i+5)=='o')&&(emailRetrieve.charAt(i+6)=='o')&&(emailRetrieve.charAt(i+7)=='o')&&(emailRetrieve.charAt(i+8)=='k')&&(emailRetrieve.charAt(i+9)=='.')&&(emailRetrieve.charAt(i+10)=='c')&&(emailRetrieve.charAt(i+11)=='o')&&(emailRetrieve.charAt(i+12)=='m'))
                        {
                            //Toast.makeText(getApplicationContext(), "outlook.com match found", Toast.LENGTH_SHORT).show();
                            break;
                        }
                        else if((emailRetrieve.charAt(0)!='@')&&(emailRetrieve.charAt(i)=='@')&&(emailRetrieve.charAt(i+1)=='o')&&(emailRetrieve.charAt(i+2)=='u')&&(emailRetrieve.charAt(i+3)=='t')&&(emailRetrieve.charAt(i+4)=='l')&&(emailRetrieve.charAt(i+5)=='o')&&(emailRetrieve.charAt(i+6)=='o')&&(emailRetrieve.charAt(i+7)=='o')&&(emailRetrieve.charAt(i+8)=='k')&&(emailRetrieve.charAt(i+9)=='.')&&(emailRetrieve.charAt(i+10)=='c')&&(emailRetrieve.charAt(i+11)=='a'))
                        {
                            //Toast.makeText(getApplicationContext(), "outlook.ca match found", Toast.LENGTH_SHORT).show();
                            break;
                        }
                        else if((emailRetrieve.charAt(0)!='@')&&(emailRetrieve.charAt(i)=='@')&&(emailRetrieve.charAt(i+1)=='h')&&(emailRetrieve.charAt(i+2)=='o')&&(emailRetrieve.charAt(i+3)=='t')&&(emailRetrieve.charAt(i+4)=='m')&&(emailRetrieve.charAt(i+5)=='a')&&(emailRetrieve.charAt(i+6)=='i')&&(emailRetrieve.charAt(i+7)=='l')&&(emailRetrieve.charAt(i+8)=='.')&&(emailRetrieve.charAt(i+9)=='c')&&(emailRetrieve.charAt(i+10)=='o')&&(emailRetrieve.charAt(i+11)=='m'))
                        {
                            //Toast.makeText(getApplicationContext(), "hotmail.com match found", Toast.LENGTH_SHORT).show();
                            break;
                        }
                        else if((emailRetrieve.charAt(0)!='@')&&(emailRetrieve.charAt(i)=='@')&&(emailRetrieve.charAt(i+1)=='h')&&(emailRetrieve.charAt(i+2)=='o')&&(emailRetrieve.charAt(i+3)=='t')&&(emailRetrieve.charAt(i+4)=='m')&&(emailRetrieve.charAt(i+5)=='a')&&(emailRetrieve.charAt(i+6)=='i')&&(emailRetrieve.charAt(i+7)=='l')&&(emailRetrieve.charAt(i+8)=='.')&&(emailRetrieve.charAt(i+9)=='c')&&(emailRetrieve.charAt(i+10)=='a'))
                        {
                            //Toast.makeText(getApplicationContext(), "hotmail.ca match found", Toast.LENGTH_SHORT).show();
                            break;
                        }
                        else if(i==(emailRetrieve.length()-1))
                        {
                            Toast.makeText(getApplicationContext(), "Please enter a proper email address", Toast.LENGTH_SHORT).show();
                            break;
                        }
                    }

                }
                else{
                    Toast.makeText(getApplicationContext(), "Please enter a proper email address", Toast.LENGTH_SHORT).show();

                }
                if(!TextUtils.isEmpty(passWordRetrieve)) {

                    Intent in = new Intent(getApplicationContext(), LoginVerification.class);
                    in.putExtra("passWordRetrieve",passWordRetrieve);
                    in.putExtra("emailAddressRetrieve", emailRetrieve);
                    startActivity(in);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Please enter a proper password", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }
}

