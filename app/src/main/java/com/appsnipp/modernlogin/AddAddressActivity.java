package com.appsnipp.modernlogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class AddAddressActivity extends AppCompatActivity {

    TextView title,save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_address);
        save=(TextView)findViewById(R.id.save);
        title = findViewById(R.id.title);
        title.setText("Add New Address");

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddAddressActivity.this, PaymentActivity.class));

            }
        });
    }
}
