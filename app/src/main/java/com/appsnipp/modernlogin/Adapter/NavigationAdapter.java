package com.appsnipp.modernlogin.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.appsnipp.modernlogin.Model.shopping;
import com.appsnipp.modernlogin.R;


import java.util.List;

/**
 * Created by trending design on 15/3/19.
 */
public class NavigationAdapter extends RecyclerView.Adapter<NavigationAdapter.MyViewHolder> {

    Context context;
    private List<shopping> OfferList;
    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title;

        public MyViewHolder(View view) {
            super(view);

            title = (TextView) view.findViewById(R.id.title);
        }
    }

    public NavigationAdapter(Context context, List<shopping> offerList) {
        this.OfferList = offerList;
        this.context = context;
    }

    @Override
    public NavigationAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_navigation_list, parent, false);
        return new NavigationAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        shopping lists = OfferList.get(position);
        holder.title.setText(lists.getTitle());

    }

    @Override
    public int getItemCount() {
        return OfferList.size();
    }

}


