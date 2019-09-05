package com.appsnipp.modernlogin;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.appsnipp.modernlogin.Adapter.FavouriteAdapter;
import com.appsnipp.modernlogin.Adapter.SmartPhoneAdapter;
import com.appsnipp.modernlogin.Model.favourite;


import java.util.ArrayList;

/**
 * Created by trending design on 15/3/19.
 */
public class DashboardActivity extends AppCompatActivity {

    /*Favourite Recyclerview data is here*/

    private ArrayList<favourite> favouriteModelClasses;
    private RecyclerView recyclerView;
    private FavouriteAdapter bAdapter;
    ImageView navigation_menu;
    ImageView sale;
    TextView viewmore;



    private int image[] = {R.drawable.headphone,R.drawable.rayban,R.drawable.shoes,R.drawable.headphone,R.drawable.rayban,R.drawable.shoes};
    private String title[] = {"Headphone","Rayban","Shoes","Headphone","Rayban","Shoes"};
    private String price[] = {"Rs 1699","Rs 550","Rs 2019","Rs 500","Rs 550","Rs 750"};



     /*Smartphones Recyclerview data is here*/

    private ArrayList<favourite> favouriteModelClasses1;
    private RecyclerView recyclerView1;
    private SmartPhoneAdapter bAdapter1;

    private int image1[] = {R.drawable.samsung_galaxy_m10,R.drawable.iphone_x,R.drawable.vivov15,R.drawable.pixel,R.drawable.s7,R.drawable.iphone_7};
    private String title1[] = {"Samsung Galaxy M10","I Phone X","Vivo V15","Google Pixel 3","Samsung S7","I Phone 7"};
    private String price1[] = {"Rs 8,990","Rs 69,000","Rs 67,418","Rs 40,000","Rs 43,000","Rs 51,000"};

    EditText editext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        viewmore=(TextView)findViewById(R.id.viewmore);


        viewmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardActivity.this, ProductListActivity.class));

            }
        });

        sale=(ImageView) findViewById(R.id.sale);
        sale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardActivity.this, ProductDetailActivity.class));

            }
        });

        navigation_menu=(ImageView)findViewById(R.id.navigation_menu);

        navigation_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardActivity.this, NavigationActivity.class));

            }
        });
        editext = findViewById(R.id.editext);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }

        recyclerView = findViewById(R.id.favourit_recyclerview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(DashboardActivity.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        favouriteModelClasses = new ArrayList<>();

        for (int i = 0; i < image.length; i++) {
            favourite beanClassForRecyclerView_contacts = new favourite(image[i],title[i],price[i]);
            favouriteModelClasses.add(beanClassForRecyclerView_contacts);
        }
        bAdapter = new FavouriteAdapter(DashboardActivity.this,favouriteModelClasses);
        recyclerView.setAdapter(bAdapter);

         /*Smartphones items code is here*/

        recyclerView1 = findViewById(R.id.smartphone_recyclerview);
        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(DashboardActivity.this);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView1.setItemAnimator(new DefaultItemAnimator());

        favouriteModelClasses1 = new ArrayList<>();

        for (int i = 0; i < image1.length; i++) {
            favourite beanClassForRecyclerView_contacts = new favourite(image1[i],title1[i],price1[i]);
            favouriteModelClasses1.add(beanClassForRecyclerView_contacts);
        }
        bAdapter1 = new SmartPhoneAdapter(DashboardActivity.this,favouriteModelClasses1);
        recyclerView1.setAdapter(bAdapter1);
    }
}
