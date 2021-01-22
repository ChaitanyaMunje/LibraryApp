package com.gtappdevelopers.instagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //creating variables for our requestqueue, array list, progressbar, edittext, image button and our recycler view. 
    private RequestQueue mRequestQueue;
    private ArrayList<InstaModal> instaModalArrayList;
    private ArrayList<FacebookFeedModal> facebookFeedModalArrayList;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initializing our views. 
        progressBar = findViewById(R.id.idLoadingPB);
        //calling method to load data in recycler view.
        getFacebookFeeds();
    }

    private void getFacebookFeeds() {
        facebookFeedModalArrayList = new ArrayList<>();
        //below line is use to initialze the variable for our request queue.
        mRequestQueue = Volley.newRequestQueue(MainActivity.this);
        //below line is use to clear cache this will be use when our data is being updated.
        mRequestQueue.getCache().clear();
        //below is the url stored in string for our sample data
        String url = "https://jsonkeeper.com/b/OB3B";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                progressBar.setVisibility(View.GONE);
                try {
                    //in below line we are extracting the data from json object.
                    String authorName = response.getString("authorName");
                    String authorImage = response.getString("authorImage");
                    //below line is to get json array from our json object.
                    JSONArray feedsArray = response.getJSONArray("feeds");
                    //running a for loop to add data to our array list
                    for (int i = 0; i < feedsArray.length(); i++) {
                        //getting json objet of our json array.
                        JSONObject feedsObj = feedsArray.getJSONObject(i);
                        //extracting data from our json object.
                        String postDate = feedsObj.getString("postDate");
                        String postDescription = feedsObj.getString("postDescription");
                        String postIV = feedsObj.getString("postIV");
                        String postLikes = feedsObj.getString("postLikes");
                        String postComments = feedsObj.getString("postComments");
                        //adding data to our modal class.
                        FacebookFeedModal feedModal = new FacebookFeedModal(authorImage, authorName, postDate, postDescription, postIV, postLikes, postComments);
                        facebookFeedModalArrayList.add(feedModal);
                        //below line we are creating an adapter class and adding our array list in it.
                        FacebookFeedRVAdapter adapter = new FacebookFeedRVAdapter(facebookFeedModalArrayList, MainActivity.this);
                        RecyclerView instRV = findViewById(R.id.idRVInstaFeeds);
                        ///below line is for setting linear layout manager to our recycler view.
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false);
                        //below line is to set layout manager to our recycler view.
                        instRV.setLayoutManager(linearLayoutManager);
                        //below line is to set adapter to our recycler view.
                        instRV.setAdapter(adapter);

                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Fail to get data with error " + error, Toast.LENGTH_SHORT).show();
            }
        });
        mRequestQueue.add(jsonObjectRequest);
    }

}