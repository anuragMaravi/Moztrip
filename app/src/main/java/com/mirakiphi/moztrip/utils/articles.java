package com.mirakiphi.moztrip.utils;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.mirakiphi.moztrip.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class articles extends AppCompatActivity {
    private String url="http://information.16mb.com/mozo/articles.JSON";

    private RecyclerView mArticleList;
    private articles_adapter mAdapter;
    private RequestQueue requestQueue;
    private ProgressDialog pdLoading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articles);
        pdLoading = new ProgressDialog(articles.this);
        pdLoading.setMessage("Please wait Loading....");
        articlelist();
    }
    private void articlelist()

    {  pdLoading.show();
        final List<article_elements> somedata=new ArrayList<>();
        requestQueue= Volley.newRequestQueue(this);
        StringRequest arrayRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    String result=response.toString();
                    JSONArray finalarray= new JSONArray(result);
                    for(int a=0;a<finalarray.length();a++)
                    {   article_elements xyz=new article_elements();
                        JSONObject finalobject=finalarray.getJSONObject(a);
                        xyz.image_url=finalobject.getString("imageurl");
                        xyz.title=finalobject.getString("articletitle");
                        xyz.description=finalobject.getString("articledescription");
                        somedata.add(xyz);
                    }
                    mArticleList = (RecyclerView)findViewById(R.id.articles_rec);
                    mAdapter = new articles_adapter(articles.this,somedata);
                    mArticleList.setAdapter(mAdapter);
                    mArticleList.setLayoutManager(new LinearLayoutManager(articles.this));
                    pdLoading.dismiss();
                }
                catch (Exception e)
                {
                    pdLoading.dismiss();
                    Toast.makeText(articles.this, "No response "+e, Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                pdLoading.dismiss();
                AlertDialog.Builder dialogbox = new AlertDialog.Builder(articles.this);
                dialogbox.setMessage("Can't fetch the articles...");
                dialogbox.setCancelable(false);
                dialogbox.setPositiveButton("RETRY", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        articlelist();
                    }
                });
                dialogbox.show();
            }
        });
        requestQueue.add(arrayRequest);
    }
}
