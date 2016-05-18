package com.mitrastudios.www.restaurantbill;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    //for the plus sign button
    private Button mPlus;

    //for minus sign button
    private Button mMinus;

    //for equalto sign button
    private Button mEqual;

    //for Bill
    private Button mBill;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPlus=(Button)findViewById(R.id.buttonPlus);
        mMinus=(Button)findViewById(R.id.buttonMinus);
        mEqual=(Button)findViewById(R.id.buttonEqual);
        mBill=(Button)findViewById(R.id.buttonBill);


        /**
         * operations to be done when plus sign is clicked
         */
        mPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        /**
         * operations to be done when minus sign is clicked
         */
        mMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        /**
         * operations to be done when equal to sign is clicked
         */
        mEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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

    }
}
