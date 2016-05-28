package com.mitrastudios.www.restaurantbill;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    //----------------------------------------------------------------------------------------------------------


    //for the plus sign button
    private Button mPlus;

    //for minus equal to button
    private Button mEqual;

    //for Clr sign button
    private Button mClr;

    //for Bill
    private Button mBill;

    //for edit text
    private EditText mEditText;

    //for discount checkbox
    private CheckBox mDisCheck;

    //for discount edit text
    private EditText mDisText;

    //for storing the discont
    private double mDis;

    //for vat checkbox
    private CheckBox mVatCheck;

    //for calculating the vat
    private double mVat;

    //for service tax check box
    private CheckBox mServiceCheck;

    //for calculating the service tax
    private double mService;



    /**
     * a variable that will track that whether the equal to sign is clicked
     *
     * if the equal is 1 and next time plus sign is clicked the edit text value won't be added
     */
    private int eq;

    //for Vat


    // to store the number
    private int mTemp;
    //to store the sum of the items
    private int mSum;
    //to store the final bill
    private double mTotal;



    //-------------------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPlus=(Button)findViewById(R.id.buttonPlus);
        mEqual=(Button)findViewById(R.id.buttonEqual);
        mClr=(Button)findViewById(R.id.buttonClr);
        mBill=(Button)findViewById(R.id.buttonBill);
        mEditText=(EditText)findViewById(R.id.editText);
        mDisCheck=(CheckBox)findViewById(R.id.disCheckBox);
        mDisText=(EditText)findViewById(R.id.disEditText);
        mVatCheck=(CheckBox)findViewById(R.id.vatCheckBox);
        mServiceCheck=(CheckBox)findViewById(R.id.serviceTCheckBox);

        //initializing the value of the sum to be zero
        mSum=0;

        //initializing the value of the eq with zero
        eq=0;

        //by default the edit text for the discount will be off
        mDisText.setEnabled(false);







        /**
         * operations to be done when plus sign is clicked
         */
        mPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /**
                 * a variable that will track that whether the equal to sign is clicked
                 *
                 * if the equal is 1 and next time plus sign is clicked the edit text value won't be added
                 *
                 *
                 *
                 * previously what was happening was that after clicking the equal to sign we were getting the result,
                 * but immediately after clicking plus sign would add the result got as a new parameter.
                 */

                if(eq==0) {
                    //getting the value from edit text and converting it to int
                    mTemp = Integer.parseInt(mEditText.getText().toString());
                    mSum += mTemp;
                }
                /**
                 * removing the numbers||| resetting the edit text
                 */
                mEditText.getText().clear();

                //resetting the equal to sign clicked to zero
                eq=0;

            }
        });


        /**
         * operations to be done when equal to sign is clicked
         */
        mEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //getting the value from edit text and converting it to int
                if(eq==0) {
                    mTemp = Integer.parseInt(mEditText.getText().toString());
                    mSum += mTemp;
                }

                //since equal to sign is clicked
                eq=1;
                //printing the sum to the editText field
                mEditText.setText(""+mSum);
            }
        });


        /**
         * operations to be done when Clr to sign is clicked
         */
        mClr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //resetting the edit field
                mEditText.getText().clear();
                //resetting th value of mSum
                mSum=0;
            }
        });


        /**
         * operations to be done when bill is clicked
         */
        mBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mDisCheck.isChecked()==true)
                    mDis=Double.parseDouble(mDisText.getText().toString());

                //calculating the discount value
                mDis=(mDis/100)*mSum;

                /**
                 * to calculate the vat
                 */
                if(mVat==1)
                    mVat=(5.0/100)*(mSum-mDis);


                /**
                 * to calculate the service tax
                 */
                if(mService==1)
                    mService=(5.8/100)*(mSum-mDis);



                Intent mIntent=new Intent(MainActivity.this,Main2Activity.class);
                mIntent.putExtra("amount",mSum);
                mIntent.putExtra("discount",mDis);
                mIntent.putExtra("vat",mVat);
                mIntent.putExtra("service",mService);
                startActivity(mIntent);

            }
        });


        /**
         * to enable and disable discount edit text
         */
        mDisCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox temp = (CheckBox)v;
                if(temp.isChecked()==true)
                    mDisText.setEnabled(true);
                else
                    mDisText.setEnabled(false);
            }
        });

        /**
         * to calculate the vat depending on the checkbox
         */
        mVatCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox temp=(CheckBox)v;
                if(temp.isChecked()==true)
                    mVat=1;
                else
                    mVat=0;
            }
        });

        /**
         * to calculate the service tax according to the checkbox
         */
        mServiceCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox temp=(CheckBox)v;
                if(temp.isChecked()==true)
                    mService=1;
                else
                    mService=0;
            }
        });




    }
}
