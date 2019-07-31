package com.android.priyanka.jsonexample.volley.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.android.priyanka.jsonexample.R;
import com.android.priyanka.jsonexample.volley.adapter.DataAdapter;
import com.android.priyanka.jsonexample.volley.model.DataModel;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ShowDataVActivity extends AppCompatActivity {

    List<DataModel> dataModelList;

    private String HTTP_JSON_URL = "https://www.androidbegin.com/tutorial/jsonparsetutorial.txt";

    String country,rank,population,flagurl;

    View view;

    int RecyclerViewItemPosition;

    RecyclerView.LayoutManager layoutManagerOfrecyclerView;

    RecyclerView.Adapter recyclerViewadapter;

    ArrayList<String> ImageTitleNameArrayListForClick;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data_r);
        ButterKnife.bind(this);

        dataModelList = new ArrayList<>();
        recyclerView.setHasFixedSize(true);

        layoutManagerOfrecyclerView = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManagerOfrecyclerView);

        downloadData();
    }

    public void downloadData(){
       /* JsonArrayRequest  RequestOfJSonArray = new JsonArrayRequest(HTTP_JSON_URL,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        System.out.println("hhhhhhh"+response.toString());

                        ParseJSonResponse(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println("faillll"+error.getMessage());

                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(ShowDataVActivity.this);

        requestQueue.add(RequestOfJSonArray);

*/

             // Initialize a new RequestQueue instance
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,HTTP_JSON_URL,
                null,new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                System.out.println("hhhhhhh"+response.toString());
                try {
                    JSONArray array = response.getJSONArray("worldpopulation");

                    // Loop through the array elements
                    for(int i=0;i<array.length();i++){

                        DataModel dataModel = new DataModel();

                        JSONObject json = null;
                        try {

                            json = array.getJSONObject(i);
                            System.out.println(json.getString("country")+"\n"+json.getString("flag")+"\n"+json.getString("population")+"\n"+json.getString("rank"));
                            dataModel.setCountry(json.getString("country"));
                            dataModel.setFlag_url(json.getString("flag"));
                            dataModel.setPopulation(json.getString("population"));
                            dataModel.setRank(json.getString("rank"));


                        } catch (JSONException e) {

                            e.printStackTrace();
                        }
                        dataModelList.add(dataModel);
                    }

                    recyclerViewadapter = new DataAdapter(dataModelList,getApplicationContext());

                    recyclerView.setAdapter(recyclerViewadapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("faillll"+error.getMessage());
            }
        });

        // Add JsonObjectRequest to the RequestQueue
        requestQueue.add(jsonObjectRequest);
    }

    public void ParseJSonResponse(JSONArray array){

        for(int i = 0; i<array.length(); i++) {

            DataModel dataModel = new DataModel();

            JSONObject json = null;
            try {

                json = array.getJSONObject(i);
                System.out.println(json.getString("country")+"\n"+json.getString("flag")+"\n"+json.getString("population")+"\n"+json.getString("rank"));
                  dataModel.setCountry(json.getString("country"));
                  dataModel.setFlag_url(json.getString("flag"));
                  dataModel.setPopulation(json.getString("population"));
                  dataModel.setRank(json.getString("rank"));


            } catch (JSONException e) {

                e.printStackTrace();
            }
              dataModelList.add(dataModel);
        }

        recyclerViewadapter = new DataAdapter(dataModelList,getApplicationContext());

        recyclerView.setAdapter(recyclerViewadapter);
    }
}
