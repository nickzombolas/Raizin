package com.example.mario.raizin;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class HomeFeed extends AppCompatActivity {

    Button generalInformationButton;
    Button timeOutsideButton;
    TextView uvIndexObject;
    TextView recommendedSPFLevelObject;
    String uvIntensity="";
    //boolean timeOutsideSelected=false;

    Button logoutButton;
    TextView recommendedIntervalOfApplicationObject;
    TextView skinTypeDisplayObject;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_feed);
        generalInformationButton=(Button)findViewById(R.id.generalInfoButtonID);
        timeOutsideButton=(Button)findViewById(R.id.timeOutsideButtonID);
        uvIndexObject=(TextView)findViewById(R.id.uvIndexTextViewID);
        recommendedSPFLevelObject=(TextView)findViewById(R.id.recommendedSPFLevelID);
        logoutButton=(Button)findViewById(R.id.logoutID);
        recommendedIntervalOfApplicationObject=(TextView)findViewById(R.id.recommendedIntervalOfApplication);
        recommendedSPFLevelObject.setVisibility(View.VISIBLE);
        skinTypeDisplayObject=(TextView)findViewById(R.id.skinTypeDisplay);
        /*Intent in=getIntent();
        String spfFactor=in.getStringExtra("spfFactor");
        recommendedSPFLevelObject.setText("Recommended SPF Level: "+spfFactor);
        Intent inType=getIntent();
        String skinType=inType.getStringExtra("skinType");
        int estimatedTime=inType.getIntExtra("estimatedTime",0);*/
        Intent inSkinType=getIntent();
        String spfFactor=inSkinType.getStringExtra("spfFactor");
        recommendedSPFLevelObject.setText("Recommended SPF Level: "+spfFactor);
        String skinType=inSkinType.getStringExtra("skinTypeChosen");
        skinTypeDisplayObject.setText("Skin Type: "+skinType);
        int estimatedTime=inSkinType.getIntExtra("estimatedTime",0);
        Toast.makeText(getApplicationContext(), "Estimated Time without UV index consideration"+estimatedTime, Toast.LENGTH_SHORT).show();
        //pass the estimated time to
        //Toast.makeText(getApplicationContext(), "Skin Type:"+skinType, Toast.LENGTH_SHORT).show();
        recommendedSPFLevelObject.setText("Recommended SPF Level: "+spfFactor);
        //Toast.makeText(getApplicationContext(), "Recommended SPF Level:"+spfFactor, Toast.LENGTH_SHORT).show();

        //recommendedSPFLevelObject.setText(skinTypeDeterminationActivityObject.recommendedSPFLevel);
        generalInformationButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                Intent intent = new Intent(getApplicationContext(), GeneralInformationActivity.class);
                startActivity(intent);
            }
        });
        timeOutsideButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                Intent intent = new Intent(getApplicationContext(), TimeOutsideActivity.class);
                startActivity(intent);
            }
        });
        logoutButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                Intent intent = new Intent(getApplicationContext(), LoginorSignUpActivity.class);
                startActivity(intent);
            }
        });
        //generate a random UV index level between 0 and 11
        Random randomNumberObject=new Random();
        int randomNumber= randomNumberObject.nextInt(12);

        if(randomNumber>0&&randomNumber<=2)
        {
            //Toast.makeText(getApplicationContext(), "The UV index exposure category is low", Toast.LENGTH_SHORT).show();
            uvIndexObject.setText("                            UV index:"+randomNumber+"\n The UV index exposure category is low");
            uvIntensity="low";
            //if the UV index is low, no change to the estimated duration
            recommendedIntervalOfApplicationObject.setText("Interval of sunscreen application: "+estimatedTime+" hours");
        }
        else if(randomNumber>=3&&randomNumber<=5)
        {
            //Toast.makeText(getApplicationContext(), "The UV index exposure category is moderate", Toast.LENGTH_SHORT).show();
            uvIndexObject.setText("                           UV index:"+randomNumber+"\n The UV index exposure category is moderate");
            uvIntensity="moderate";
            //if the UV index is moderate, no change to the estimated duration
            recommendedIntervalOfApplicationObject.setText("Interval of sunscreen application: "+estimatedTime+" hours");
        }
        else if(randomNumber>=6&&randomNumber<=7)
        {
            //Toast.makeText(getApplicationContext(), "The UV index exposure category is high", Toast.LENGTH_SHORT).show();
            uvIndexObject.setText("                           UV index:"+randomNumber+"\n The UV index exposure category is high");
            uvIntensity="high";
            //if the UV index is high, decrease the estimated duration by 1 hour
            recommendedIntervalOfApplicationObject.setText("Interval of sunscreen application: "+(estimatedTime-1)+" hours");  //was estimatedTime-1
        }
        else if(randomNumber>=8&&randomNumber<=10)
        {
            //Toast.makeText(getApplicationContext(), "The UV index exposure category is very high", Toast.LENGTH_SHORT).show();
            uvIndexObject.setText("                           UV index:"+randomNumber+"\n The UV index exposure category is very high");
            uvIntensity="very high";
            //if the UV index is very high, decrease the estimated duration by 2 hours
            recommendedIntervalOfApplicationObject.setText("Interval of sunscreen application: "+(estimatedTime-2)+" hours");
        }
        else if(randomNumber>=11)
        {
            //Toast.makeText(getApplicationContext(), "The UV index exposure category is extreme", Toast.LENGTH_SHORT).show();
            uvIndexObject.setText("                           UV index:"+randomNumber+"\n The UV index exposure category is extreme");
            uvIntensity="extreme";
            //if the UV index is extreme, decrease the estimated duration by 4 hours
            recommendedIntervalOfApplicationObject.setText("Interval of sunscreen application: "+(estimatedTime-4)+" hours");
        }
        if(randomNumber==0)
        {
            //make the time outside button invisible
            timeOutsideButton.setVisibility(View.INVISIBLE);
        }


    }
}
