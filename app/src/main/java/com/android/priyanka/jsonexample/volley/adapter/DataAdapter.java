package com.android.priyanka.jsonexample.volley.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.priyanka.jsonexample.R;
import com.android.priyanka.jsonexample.volley.model.DataModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder> {
    private List<DataModel> dataModelList;
    com.android.volley.toolbox.ImageLoader imageLoader;
    Context context;

    public DataAdapter(List<DataModel> dataModelList,Context context) {
        this.dataModelList = dataModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.data_layout, viewGroup, false);

        return new DataViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder dataViewHolder, int i) {
        DataModel dataModel = dataModelList.get(i);
        dataViewHolder.textCountry.setText(dataModel.getCountry());
        dataViewHolder.textPopulation.setText(dataModel.getPopulation());
        dataViewHolder.textRank.setText(dataModel.getRank());

        Picasso.with(context).load(dataModel.getFlag_url()).fit().centerInside().into(dataViewHolder.dataImage);
        System.out.println("image loaded");
    }

    @Override
    public int getItemCount() {
        return dataModelList.size();
    }

   public class DataViewHolder extends RecyclerView.ViewHolder{
         TextView textCountry,textRank,textPopulation;
         ImageView dataImage;

        public DataViewHolder(@NonNull View itemView) {
            super(itemView);

            textCountry = itemView.findViewById(R.id.textCountry);
            textRank = itemView.findViewById(R.id.textRank);
            textPopulation = itemView.findViewById(R.id.textPopulation);
            dataImage = itemView.findViewById(R.id.imageData);
        }
    }
}
