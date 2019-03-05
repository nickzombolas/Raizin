package com.example.mario.raizin;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class SkinTypeDeterminationActivityContinuation extends AppCompatActivity {

    String[] skinType={"       Oily Skin", "      Dry Skin", "      Combination Skin", "       Normal Skin"};
    ListView listViewObject;
    String selectedSkinType="";
    String skinTypeSelection;
    Button submit;
    Button cancel;
    //double oilySkinFactor=30;
    //double drySkinFactor=30;
    //double combinationSkinFactor=15;
    //double normalSkinFactor=0;
    //double estimatedTimeWithSkinType;
    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        // dont call **super**, if u want disable back button in current screen.
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skin_type_determination_continuation);
        submit=(Button)findViewById(R.id.SubmitButton);
        cancel=(Button)findViewById(R.id.Cancel);
        listViewObject = (ListView) findViewById(R.id.skinTypeListView);
        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(this, R.layout.simple_list, skinType);
        listViewObject.setAdapter(arrayAdapter);
        listViewObject.setOnItemClickListener(new AdapterView.OnItemClickListener() {   //ass a setOnItemClickListener which will run when one of the items of the listview is clicked
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(SkinTypeDeterminationActivityContinuation.this, skinType[position], Toast.LENGTH_SHORT).show();
                //need to store the selected skin type
                selectedSkinType=skinType[position];
                //determined from nivea sunscreen guide for all skin types
                if(selectedSkinType=="       Oily Skin")
                {
                    skinTypeSelection="Oily Skin";
                }
                else if(selectedSkinType=="      Dry Skin")
                {
                    skinTypeSelection="Dry Skin";
                }
                else if(selectedSkinType=="      Combination Skin")
                {
                    skinTypeSelection="Combination Skin";
                }
                else if(selectedSkinType=="       Normal Skin")
                {
                    skinTypeSelection="Normal Skin";
                }

            }
        });
        submit.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                //need to prevent if skin type from dialog fragment isn't chosen and aslo if item from listview isn't selected
                if(skinTypeSelection=="Oily Skin")
                {
                    //need to get the info from SkinTypeDeterminationActivity and pass it to HomeFeed activity
                    Intent in=getIntent();
                    String spfFactor=in.getStringExtra("spfFactor");
                    Intent inType=getIntent();
                    int estimatedTime=inType.getIntExtra("estimatedTime",0);
                    //estimatedTime=estimatedTime+0.5;
                    //double oilySkinFactor=30;
                    //double estimatedTimeWithSkinType=estimatedTime+oilySkinFactor;
                    Intent inSkinType=new Intent(getApplicationContext(), HomeFeed.class);
                    inSkinType.putExtra("spfFactor", spfFactor);
                    inSkinType.putExtra("estimatedTime", estimatedTime);    //was estimatedTime
                    inSkinType.putExtra("skinTypeChosen", "Oily Skin");
                    startActivity(inSkinType);

                    Intent inTimer=new Intent(getApplicationContext(), HomeFeed.class);
                    inTimer.putExtra("spfFactor", spfFactor);
                    inTimer.putExtra("estimatedTime", estimatedTime);    //was estimatedTime
                    inTimer.putExtra("skinTypeChosen", "Oily Skin");
                    startActivity(inTimer);
                }
                else if(skinTypeSelection=="Dry Skin")
                {
                    //need to get the info from SkinTypeDeterminationActivity and pass it to HomeFeed activity
                    Intent in=getIntent();
                    String spfFactor=in.getStringExtra("spfFactor");
                    Intent inType=getIntent();
                    int estimatedTime=inType.getIntExtra("estimatedTime",0);
                    //estimatedTime=estimatedTime-0.5;
                    //double drySkinFactor=30;
                    //double estimatedTimeWithSkinType=estimatedTime+drySkinFactor;
                    Intent inSkinType=new Intent(getApplicationContext(), HomeFeed.class);
                    inSkinType.putExtra("spfFactor", spfFactor);
                    inSkinType.putExtra("estimatedTime", estimatedTime);                //was estimatedTime
                    inSkinType.putExtra("skinTypeChosen", "Dry Skin");
                    startActivity(inSkinType);
                }
                else if(skinTypeSelection=="Combination")
                {
                    //need to get the info from SkinTypeDeterminationActivity and pass it to HomeFeed activity
                    Intent in=getIntent();
                    String spfFactor=in.getStringExtra("spfFactor");
                    Intent inType=getIntent();
                    int estimatedTime=inType.getIntExtra("estimatedTime",0);
                    //estimatedTime=estimatedTime-0.25;
                    //double combinationSkinFactor=15;
                    //double estimatedTimeWithSkinType=estimatedTime+combinationSkinFactor;
                    Intent inSkinType=new Intent(getApplicationContext(), HomeFeed.class);
                    inSkinType.putExtra("spfFactor", spfFactor);
                    inSkinType.putExtra("estimatedTime", estimatedTime);                            //was estimatedTime
                    inSkinType.putExtra("skinTypeChosen", "Combination Skin");
                    startActivity(inSkinType);
                }
                else if(skinTypeSelection=="Normal")
                {
                    //need to get the info from SkinTypeDeterminationActivity and pass it to HomeFeed activity
                    Intent in=getIntent();
                    String spfFactor=in.getStringExtra("spfFactor");
                    Intent inType=getIntent();
                    int estimatedTime=inType.getIntExtra("estimatedTime",0);
                    //double normalSkinFactor=0;
                    //double estimatedTimeWithSkinType=estimatedTime+normalSkinFactor;
                    Intent inSkinType=new Intent(getApplicationContext(), HomeFeed.class);
                    inSkinType.putExtra("spfFactor", spfFactor);
                    inSkinType.putExtra("estimatedTime", estimatedTime);            //was estimatedTime
                    inSkinType.putExtra("skinTypeChosen", "Normal Skin");
                    startActivity(inSkinType);
                }

                //Intent intent = new Intent(getApplicationContext(), HomeFeed.class);
                //startActivity(intent);
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                Intent intent = new Intent(getApplicationContext(), userInfo.class);
                startActivity(intent);
            }
        });
    }
}
