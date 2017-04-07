package com.mirakiphi.moztrip;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import static com.mirakiphi.moztrip.utils.Contract.DETAILS;
import static com.mirakiphi.moztrip.utils.Contract.DETAILS_2;

public class HotelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);
        Toast.makeText(this, getIntent().getStringExtra("place_id"), Toast.LENGTH_SHORT).show();


        StringRequest stringRequest = new StringRequest(Request.Method.GET, DETAILS + getIntent().getStringExtra("place_id") + DETAILS_2,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.i("Volley", "onResponse(Details): " + response);
//                        try {
//                            JSONObject parentObject = new JSONObject(response);
//                            JSONArray parentArray = parentObject.getJSONArray("results");
//                            for (int i = 0; i < parentArray.length(); i++) {
//                                JSONObject finalObject = parentArray.getJSONObject(i);
//                                Model model = new Model();
//                                model.setTpName(finalObject.getString("name"));
//                                model.setTpPlaceID(finalObject.getString("place_id"));
//                                try {
//                                    JSONArray photoArray = finalObject.getJSONArray("photos");
//                                    JSONObject photoObject = photoArray.getJSONObject(0);
//                                    model.setTpReference(PLACE_IMAGE + photoObject.getString("photo_reference") + "&key=" + WEB_API_KEY);
//                                } catch (JSONException e) {
//                                    Log.i("PhotoError", "onResponse: ");
//                                }
//                                touristPlacesList.add(model);
//
//                            }
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Some Error Occurred", Toast.LENGTH_SHORT).show();
            }
        });
        // Add the request to the RequestQueue.
        VolleySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);

    }
}
