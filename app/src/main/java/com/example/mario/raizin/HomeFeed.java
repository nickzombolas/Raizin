package com.example.mario.raizin;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

public class HomeFeed extends AppCompatActivity {

    Button generalInformationButton;
    Button timeOutsideButton;
    TextView uvIndexObject;
    TextView recommendedSPFLevelObject;
    String uvIntensity="";
    Button logoutButton;
    TextView recommendedIntervalOfApplicationObject;
    TextView skinTypeDisplayObject;
    TextView skinToneDisplayObject;
    String[] skinTipOily=new String[10];
    String[] skinTipDry=new String[10];
    String[] skinTipCombination=new String[10];
    String[] skinTipNormal=new String[10];

    // nick bluetooth
    BluetoothAdapter bluetoothAdapter = null;
    BluetoothSocket bluetoothSocket = null;
    Set<BluetoothDevice> pairedBluetoothDevices;
    String bluetoothAddress = null;
    String bluetoothDeviceName = null;
    Button uvButton;
    static final UUID uuid = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    int measuredUVIndex = -1;

    public void onBackPressed() {
        //super.onBackPressed();
        // dont call **super**, if u want disable back button in current screen.
    }

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
        skinToneDisplayObject=(TextView)findViewById(R.id.skinToneID);

        Intent inSkinType=getIntent();
        String spfFactor=inSkinType.getStringExtra("spfFactor");
        recommendedSPFLevelObject.setText("Recommended SPF Level: "+spfFactor);
        String skinType=inSkinType.getStringExtra("skinTypeChosen");
        String skinTone=inSkinType.getStringExtra("skinToneSelected");
        skinToneDisplayObject.setText("Skin tone: "+skinTone);
        skinTypeDisplayObject.setText("Skin Type: "+skinType);
        int estimatedTime=inSkinType.getIntExtra("estimatedTime",0);
        Toast.makeText(getApplicationContext(), "Estimated Time without UV index consideration"+estimatedTime, Toast.LENGTH_SHORT).show();
        SQLiteDatabase myDataBase = openOrCreateDatabase("Database", MODE_PRIVATE, null);

        myDataBase.execSQL("CREATE TABLE IF NOT EXISTS UserSkinSelectionTable(spf VARCHAR, type VARCHAR, tone VARCHAR);");
        myDataBase.execSQL("INSERT INTO UserSkinSelectionTable VALUES('"+spfFactor+"', '"+skinType+"', '"+skinTone+"' );");

        recommendedSPFLevelObject.setText("Recommended SPF Level: "+spfFactor);
        if(skinType=="Oily")
        {
            //Tips for oily skin here
            //then randomly choose from them
            //source: https://health.howstuffworks.com/skin-care/beauty/sun-care/quick-tips-best-sunscreens-for-oily-skin.htm
            //https://www.verywellhealth.com/how-to-choose-sunscreen-for-acne-prone-skin-15916
            skinTipOily[0]="Look for oil-free and waterbased sunscreen products when conducting your purchases, this will hellp prevent your pores from clogging";
            skinTipOily[1]="It is preferable to select gels in terms of skin care products since they are quickly absorbed into the skin.";
            skinTipOily[2]="Use a cleanser containing salyscylic acid often in order to remove excess oil from the surface of your skin.";

        }
        else if(skinType=="Dry")
        {
            //Tips for dry skin here
            //then randomly choose from them
            //source:https://www.verywellhealth.com/how-to-choose-sunscreen-for-acne-prone-skin-15916
            //source:https://www.cbc.ca/life/style/choosing-the-right-sunscreen-for-your-skin-type-1.4736900
            skinTipDry[0]="Sunscreen lotions or creams are highly recommended for dry skin.";
            skinTipDry[1]="It is important to constantly moisturize your skin, make sure to apply the sunscreen first before applying the moisturizer.";
            skinTipDry[2]="Look for skin products that are lacking in zinc oxide, which is known to dry skin and instead look for products constaining glycerins and oils.";
        }
        else if(skinType=="Combination")
        {
            skinTipCombination[0]="Look for oil-free and waterbased sunscreen products when conducting your purchases, this will hellp prevent your pores from clogging";
            skinTipCombination[1]="For oily areas of skin, it is preferable to select gels in terms of skin care products since they are quickly absorbed into the skin.";
            skinTipCombination[2]="Sunscreen lotions or creams are highly recommended for dry skin areas.";
            skinTipCombination[3]="It is important to constantly moisturize your dry skin, make sure to apply the sunscreen first before applying the moisturizer.";
            skinTipCombination[4]="Refrain from applying skin products that contain zinc oxide to dry skin areas, which is known to further dry skin and instead look for products constaining glycerins and oils.";
        }

        generalInformationButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                Intent intent = new Intent(getApplicationContext(), GeneralInformationActivity.class);
                //Intent inSkinType=new Intent(getApplicationContext(), GeneralInformationActivity.class);

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

            uvIndexObject.setText("                            UV index:"+randomNumber+"\n The UV index exposure category is low");
            uvIntensity="low";
            //if the UV index is low, no change to the estimated duration
            recommendedIntervalOfApplicationObject.setText("Interval of sunscreen application: "+estimatedTime+" hours");
        }
        else if(randomNumber>=3&&randomNumber<=5)
        {
            uvIndexObject.setText("                           UV index:"+randomNumber+"\n The UV index exposure category is moderate");
            uvIntensity="moderate";
            //if the UV index is moderate, no change to the estimated duration
            recommendedIntervalOfApplicationObject.setText("Interval of sunscreen application: "+estimatedTime+" hours");
        }
        else if(randomNumber>=6&&randomNumber<=7)
        {
            uvIndexObject.setText("                           UV index:"+randomNumber+"\n The UV index exposure category is high");
            uvIntensity="high";
            //if the UV index is high, decrease the estimated duration by 1 hour
            recommendedIntervalOfApplicationObject.setText("Interval of sunscreen application: "+(estimatedTime-1)+" hours");  //was estimatedTime-1
        }
        else if(randomNumber>=8&&randomNumber<=10)
        {
            uvIndexObject.setText("                           UV index:"+randomNumber+"\n The UV index exposure category is very high");
            uvIntensity="very high";
            //if the UV index is very high, decrease the estimated duration by 2 hours
            recommendedIntervalOfApplicationObject.setText("Interval of sunscreen application: "+(estimatedTime-2)+" hours");
        }
        else if(randomNumber>=11)
        {

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
    //Find all bluetooth pairs and get their address and name
    private void connectBluetoothDevice() throws IOException {
        try{
            bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
            bluetoothAddress = bluetoothAdapter.getAddress();
            pairedBluetoothDevices = bluetoothAdapter.getBondedDevices();
            if(pairedBluetoothDevices.size() > 0){
                for(BluetoothDevice bluetoothDev : pairedBluetoothDevices){
                    bluetoothAddress = bluetoothDev.getAddress();
                    bluetoothDeviceName = bluetoothAdapter.getName();
                    //Toast.makeText(getApplicationContext(),bluetoothDeviceName, Toast.LENGTH_SHORT).show();
                }
            }
        }catch(Exception e){ }
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        BluetoothDevice bluetoothDevice = bluetoothAdapter.getRemoteDevice(bluetoothAddress);
        bluetoothSocket = bluetoothDevice.createInsecureRfcommSocketToServiceRecord(uuid);
        bluetoothSocket.connect();
        try{
            //Toast.makeText(getApplicationContext(),bluetoothDeviceName, Toast.LENGTH_SHORT).show();
        }catch(Exception exception){}
    }

    private void getInputData(){

        InputStream in;
        int bytes; //number of bytes read
        byte[] buffer = new byte[4]; //read 4 bytes from bluetooth to store 1 float
        String bluetoothSerial = "";
        try{
            if(!(bluetoothSocket == null)) {
                in = bluetoothSocket.getInputStream();
                bytes = in.read(buffer);
                bluetoothSerial = new String(buffer, 0, bytes);
            }
        }catch(Exception exception){}
        Toast.makeText(getApplicationContext(),bluetoothSerial, Toast.LENGTH_SHORT).show();
    }
}
