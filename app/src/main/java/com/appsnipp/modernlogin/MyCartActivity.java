package com.appsnipp.modernlogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyCartActivity extends AppCompatActivity {

    TextView title,number;

    LinearLayout linear_add,linear_count,bottom_linear;
    ImageView add,minus;
    TextView checkout;



    int count=1,adult=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cart);

        checkout=(TextView)findViewById(R.id.checkout);
        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyCartActivity.this, PaymentActivity.class));

            }
        });

        title = findViewById(R.id.title);
        title.setText("Cart");


        //linear_add = findViewById(R.id.linear_add);
        linear_count = findViewById(R.id.linear_count);
        add = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        number = findViewById(R.id.number);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                number.setText(String.valueOf(count));
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count!=1){
                    count--;
                    number.setText(String.valueOf(count));
                }
            }

        });

    }
}
