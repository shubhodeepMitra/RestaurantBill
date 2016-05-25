package com.mitrastudios.www.restaurantbill;

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
    private EditText mDis;

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
        mDis=(EditText)findViewById(R.id.disEditText);

        //initializing the value of the sum to be zero
        mSum=0;

        //initializing the value of the eq with zero
        eq=0;

        //by default the edit text for the discount will be off
        mDis.setEnabled(false);







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
                mTemp= Integer.parseInt(mEditText.getText().toString());
                mSum+=mTemp;


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
                    mDis.setEnabled(true);
                else
                    mDis.setEnabled(false);
            }
        });




    }
}
