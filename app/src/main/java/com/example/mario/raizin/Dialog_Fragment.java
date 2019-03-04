package com.example.mario.raizin;

import android.content.DialogInterface;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.app.Dialog;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class Dialog_Fragment extends AppCompatDialogFragment {

    RadioGroup radioGroup;
    RadioButton radioButton;
    SkinTypeDeterminationActivity skinTypeDeterminationActivityObject;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)                                 //creation of the onCreateDialog function which is used to create the dialog fragment
    {

        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        LayoutInflater inflater=getActivity().getLayoutInflater();
        View view=inflater.inflate(R.layout.dialog_layout, null);

        builder.setView(view)
                .setTitle("Please select your closest skin type")                                                    //set the title of the dialog fragment
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {    //creation of the cancel button
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {                         //creation of the save button
                        String selection=radioButton.getText().toString();
                        //store these two values into the database
                        if(selection=="Oily")
                        {


                            //extend the sunscreen duration time by 30 mins

                        }
                        else if(selection=="Dry")
                        {
                            //diminish the sunscreen duration time by 30 mins
                        }
                        else if(selection=="Combination")
                        {
                            //diminish the sunscreen duration time by 15 mins
                        }


                    }
                });
        //editTextCode=view.findViewById(R.id.firstField);                                    //connect the editTextCode object to the xml element
        //editTextTitle=view.findViewById(R.id.secondField);                                  //connect the editTextTitle object to the xml element
        radioGroup=view.findViewById(R.id.RadioGroup);
        int radioId=radioGroup.getCheckedRadioButtonId();
        radioButton=view.findViewById(radioId);

        //radioButton=view.findViewById(R.id.oilyOptionSelected);
        //radioButtonDry=view.findViewById(R.id.dryOptionSelected);
        return builder.create();                                                            //use the builder to create the dialog fragment
    }
    public void checkButton()
    {

        int radioId=radioGroup.getCheckedRadioButtonId();

        if(radioId==1)
        {
            skinTypeDeterminationActivityObject.dialogFragmentSkinType="Oily";
        }

        //radioButton=findViewById(R.id.oilyOptionSelected);
        //Toast.makeText(getApplicationContext(), "Worked", Toast.LENGTH_SHORT).show();
    }
    /*public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.oilyOptionSelected:
                if (checked)
                    // Pirates are the best

                    break;
            case R.id.dryOptionSelected:
                if (checked)
                    // Ninjas rule
                    break;
        }
    }*/

}
