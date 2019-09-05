package com.appsnipp.modernlogin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.appsnipp.modernlogin.Adapter.RecycleAdapteProductList;
import com.appsnipp.modernlogin.Model.ProductListModellClass;

import java.util.ArrayList;


public class ProductListActivity extends AppCompatActivity {


    private ArrayList<ProductListModellClass> productListModellClasses;
    private RecyclerView recyclerview;
    private RecycleAdapteProductList mAdapter2;
    private Integer image1[]={R.drawable.samsung_galaxy_m10,R.drawable.iphone_x,R.drawable.vivov15,R.drawable.pixel,R.drawable.s7,R.drawable.iphone_7};
    private String title1[] ={"Samsung Galaxy M10","I Phone X","Vivo V15","Google Pixel 3","Samsung S7","I Phone 7"};
    private Integer like[] = {R.drawable.ic_heart_light,R.drawable.ic_dark_like,R.drawable.ic_dark_like,R.drawable.ic_heart_light,R.drawable.ic_dark_like,R.drawable.ic_heart_light};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);



        //      Product List  Recyclerview Code is here

        recyclerview = (RecyclerView)findViewById(R.id.recyclerview);

        productListModellClasses = new ArrayList<>();



        for (int i = 0; i < image1.length; i++) {
            ProductListModellClass beanClassForRecyclerView_contacts = new ProductListModellClass(image1[i],title1[i],like[i]);

            productListModellClasses.add(beanClassForRecyclerView_contacts);
        }



        mAdapter2 = new RecycleAdapteProductList(ProductListActivity.this,productListModellClasses);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(ProductListActivity.this);
        recyclerview.setLayoutManager(mLayoutManager);
        recyclerview.setItemAnimator(new DefaultItemAnimator());
        recyclerview.setAdapter(mAdapter2);



    }
}
