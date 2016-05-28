package com.mitrastudios.www.restaurantbill;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class Main2Activity extends AppCompatActivity {

    //for storing the total
    private double mTotal;

    //for storing amount
    private double mAmount;

    //for storing vat
    private double mVat;

    //for storing service tax
    private double mSt;

    //for storing the discount
    private double mDis;


    //-----------------------------------------------------
    //reference to the amount text view
    private TextView amt;

    //reference to discount text view
    private TextView dis;

    //reference to vat text view
    private TextView vat;

    //reference to discount service tax view
    private TextView st;

    //reference to total text view
    private TextView tot;

    //----------------------------------------------------------------------





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        DecimalFormat df = new DecimalFormat("#.00");


        amt=(TextView)findViewById(R.id.amountDisplay);
        dis=(TextView)findViewById(R.id.discountDisplay);
        vat=(TextView)findViewById(R.id.vatDisplay);
        st=(TextView)findViewById(R.id.serviceDisplay);
        tot=(TextView)findViewById(R.id.totalDisplay);










        Intent i =getIntent();
        //getting amount and setting default value as 0
        mAmount=i.getIntExtra("amount",0);

        mDis=i.getDoubleExtra("discount",0);

        mVat=i.getDoubleExtra("vat",0);

        mSt=i.getDoubleExtra("service",0);


        /**
         * calculating total
         */
        mTotal=mAmount+mSt+mVat-mDis;

        amt.setText(Double.toString(mAmount));
        dis.setText(Double.toString(mDis));
        vat.setText(Double.toString(mVat));
        st.setText(Double.toString(mSt));
        tot.setText(Double.toString(mTotal));
    }


}
