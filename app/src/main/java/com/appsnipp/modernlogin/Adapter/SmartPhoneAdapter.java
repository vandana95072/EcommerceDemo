package com.appsnipp.modernlogin.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.appsnipp.modernlogin.Model.favourite;
import com.appsnipp.modernlogin.ProductDetailActivity;
import com.appsnipp.modernlogin.R;



import java.util.List;

/**
 * Created by trending design on 15/3/19.
 */
public class SmartPhoneAdapter extends RecyclerView.Adapter<SmartPhoneAdapter.MyViewHolder> {

    Context context;
    private List<favourite> OfferList;
    boolean showingfirst = true;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView image,like;
        TextView title,price;

        public MyViewHolder(View view) {
            super(view);

            image = (ImageView)view.findViewById(R.id.image);
            like = (ImageView)view.findViewById(R.id.like);
            title = (TextView) view.findViewById(R.id.title);
            price = (TextView) view.findViewById(R.id.price);
        }
    }

    public SmartPhoneAdapter(Context context, List<favourite> offerList) {
        this.OfferList = offerList;
        this.context = context;
    }

    @Override
    public SmartPhoneAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_smartphone_list, parent, false);
        return new SmartPhoneAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        final favourite lists = OfferList.get(position);
        holder.image.setImageResource(lists.getImage());
        holder.title.setText(lists.getTitle());
        holder.price.setText(lists.getPrice());

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                if (lists.isSelected() == true){
//                    lists.setSelected(false);
//                    holder.like.setImageResource(R.drawable.heart_fill);
//                }else {
//                    lists.setSelected(true);
//                    holder.like.setImageResource(R.drawable.heart);
//                }
//            }
//        });
        holder.image.setOnClickListener( new OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProductDetailActivity.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return OfferList.size();
    }
}


