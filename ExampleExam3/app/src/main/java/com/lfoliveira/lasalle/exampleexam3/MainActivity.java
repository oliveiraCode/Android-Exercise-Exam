package com.lfoliveira.lasalle.exampleexam3;

import android.location.Address;
import android.location.Geocoder;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btnSearch = findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findAddress();
            }
        });
    }

    private void findAddress(){

        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        try {

            EditText editTextLocation = findViewById(R.id.editTextLocation);

            List<Address> addresses = geocoder.getFromLocationName(editTextLocation.getText().toString(), 1);
            System.out.println(addresses.size());
            if (addresses.size() > 0) {

                TextView textViewAddress = findViewById(R.id.textViewAddress);
                textViewAddress.setText(addresses.get(0).getAddressLine(0));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
