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
        radioGroup=view.findViewById(R.id.RadioGroup);
        int radioId=radioGroup.getCheckedRadioButtonId();
        radioButton=view.findViewById(radioId);
        return builder.create();                                                            //use the builder to create the dialog fragment
    }

}
