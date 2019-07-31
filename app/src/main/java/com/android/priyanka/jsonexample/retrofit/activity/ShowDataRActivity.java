package com.android.priyanka.jsonexample.retrofit.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.android.priyanka.jsonexample.R;
import com.android.priyanka.jsonexample.retrofit.adapter.DataAdapterRetrofit;
import com.android.priyanka.jsonexample.retrofit.model.DataModelRetrofit;
import com.android.priyanka.jsonexample.retrofit.model.DataModelRetrofit2;
import com.android.priyanka.jsonexample.retrofit.rest.APIClient;
import com.android.priyanka.jsonexample.retrofit.rest.DataEndPoint;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowDataRActivity extends AppCompatActivity {

    List<DataModelRetrofit.Worldpopulation> dataModelList;
    List<DataModelRetrofit2> dataModelList2;
    String country, rank, population, flagurl;
    View view;
    int RecyclerViewItemPosition;
    RecyclerView.LayoutManager layoutManager;
    DataAdapterRetrofit recyclerViewadapter;
    ArrayList<String> ImageTitleNameArrayListForClick;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    APIClient apiClient;
    DataEndPoint dataEndPoint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data_r);
        ButterKnife.bind(this);

        Context context;
        dataModelList = new ArrayList<>();
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        dataEndPoint = APIClient.getClient().create(DataEndPoint.class);
        /*Call<List<DataModelRetrofit>> call= dataEndPoint.getData();

        call.enqueue(new Callback<List<DataModelRetrofit>>() {
            @Override
            public void onResponse(Call<List<DataModelRetrofit>> call, Response<List<DataModelRetrofit>> response) {
                dataModelList = response.body();
                recyclerViewadapter = new DataAdapterRetrofit(dataModelList,getApplicationContext());
                recyclerView.setAdapter(recyclerViewadapter);
            }

            @Override
            public void onFailure(Call<List<DataModelRetrofit>> call, Throwable t) {
                System.out.println("fail..."+t.getMessage());
            }
        });
*/
        Call<DataModelRetrofit> call = dataEndPoint.getDataList();

        call.enqueue(new Callback<DataModelRetrofit>() {
            @Override
            public void onResponse(Call<DataModelRetrofit> call, Response<DataModelRetrofit> response) {
                //dataModelList = response.body();
               // recyclerViewadapter = new DataAdapterRetrofit(dataModelList,getApplicationContext());
               // recyclerView.setAdapter(recyclerViewadapter);
            if(response.isSuccessful()){
                  /*  DataModelRetrofit dataModelRetrofit =  response.body();
                    //dataModelList.add(dataModelRetrofit);
                    //recyclerViewadapter = new DataAdapterRetrofit(dataModelList,getApplicationContext());
                   // recyclerView.setAdapter(recyclerViewadapter);
                    System.out.println("response successfull..");
                    System.out.println("response.."+response.body().toString());

                JSONObject obj = null;
                try {
                    obj = new JSONObject(response.body().toString());
                  //  System.out.println("response obj.."+obj);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                System.out.println("response obj.."+obj);

                try {
                    JSONArray dataArray  = obj.getJSONArray("worldpopulation");

                    for (int i = 0; i < dataArray.length(); i++) {

                        DataModelRetrofit retroModel = new DataModelRetrofit();
                        JSONObject dataobj = dataArray.getJSONObject(i);

                        retroModel.setCountry(dataobj.getString("country"));
                        retroModel.setFlag_url(dataobj.getString("flag"));
                        retroModel.setPopulation(dataobj.getString("population"));
                        retroModel.setRank(Integer.valueOf(dataobj.getString("rank")));

                        dataModelList.add(retroModel);

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

*/
                ArrayList<DataModelRetrofit.Worldpopulation> arrayList = (ArrayList<DataModelRetrofit.Worldpopulation>) response.body().getWorldpopulation();
                if (arrayList != null) {
                    //System.out.println("response.."+arrayList.get(0).getCountry());

                    System.out.println("json response.."+new Gson().toJson(response.body()));
                    for(int i=0;i<arrayList.size();i++){
                        System.out.println("response.."+arrayList.get(i).getCountry());

                        DataModelRetrofit.Worldpopulation dataModel = new DataModelRetrofit.Worldpopulation();

                        dataModel.setCountry(arrayList.get(i).getCountry());
                        dataModel.setFlag_url(arrayList.get(i).getFlag_url());
                        dataModel.setPopulation(arrayList.get(i).getPopulation());
                        dataModel.setRank(Integer.valueOf(arrayList.get(i).getRank()));

                        dataModelList.add(dataModel);
                        System.out.println("data attached");

                    }

                    recyclerViewadapter = new DataAdapterRetrofit(dataModelList,getApplicationContext());

                    recyclerView.setAdapter(recyclerViewadapter);
                }



            }
                else {
                    System.out.println("response not successfull");
                }
       }

            @Override
            public void onFailure(Call<DataModelRetrofit> call, Throwable t) {
                System.out.println("fail..."+t.getMessage());
            }
        });

    }
}
