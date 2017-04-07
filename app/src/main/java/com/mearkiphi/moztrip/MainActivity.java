package com.mearkiphi.moztrip;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;
import com.mirakiphi.moztrip.R;

public class MainActivity extends AppCompatActivity {

    //New UI
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
public void findPlace(View view) {
        try {
        Intent intent = new PlaceAutocomplete.IntentBuilder(PlaceAutocomplete.MODE_FULLSCREEN).build(this);
        startActivityForResult(intent, 1);
        } catch (GooglePlayServicesRepairableException e) {
        } catch (GooglePlayServicesNotAvailableException e) {

        }
        }

// A place has been received; use requestCode to track the request.
@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
        if (resultCode == RESULT_OK) {
// retrive the data by using getPlace() method.
        Place place = PlaceAutocomplete.getPlace(this, data);
        Log.e("Tag", "Place: " + place.getAddress() + place.getPhoneNumber()+place.getLatLng());

        ((TextView) findViewById(R.id.searched_address))
        .setText(place.getName()+",\n"+
        place.getAddress() +"\n" + place.getPhoneNumber());

        } else if (resultCode == PlaceAutocomplete.RESULT_ERROR) {
        Status status = PlaceAutocomplete.getStatus(this, data);
// TODO: Handle the error.
        Log.e("Tag", status.getStatusMessage());

        } else if (resultCode == RESULT_CANCELED) {
// The user canceled the operation.
        }
        }
        }
        }