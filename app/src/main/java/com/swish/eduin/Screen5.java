<<<<<<< HEAD
package com.swish.eduin;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.util.Linkify;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.ScaleAnimation;
import android.webkit.GeolocationPermissions;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Screen5 extends AppCompatActivity {

    Toolbar toolbar;
    TextView txt;
    Button directions;
    ArrayList<ModuleClass> arrList;
    TextView tv2, courseOffered;
    DBHelper dbHelper;
    ArrayList<ModuleClass> arrayList;
    ListView list;
    DBHelper db;
    int favData;
    ToggleButton toggleButton;
    Image fav_image;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen5);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tv2 = (TextView) findViewById(R.id.textView);
        courseOffered = (TextView) findViewById(R.id.textView3);

        toggleButton = (ToggleButton) findViewById(R.id.favourite);


        arrList = new ArrayList<>();
        dbHelper = new DBHelper(this);

        try {
            String data = getIntent().getStringExtra("value");
            Log.e("Data#####", data + "");
            //arrList = dbHelper.retriveData1(1);
            int newPosition = Integer.parseInt(data) + 1;
            this.favData = newPosition;
            arrList = dbHelper.retriveData1(newPosition);

            tv2.setText(arrList.get(0).location);
            courseOffered.setText(arrList.get(0).syllabus);

            String address = arrList.get(0).location;
            //String address="No 22, St Marks Rd, Shanthala Nagar, Ashok Nagar, Bengaluru, Karnataka 560001";

            Geocoder coder = new Geocoder(this);
            List<Address> addresses;

            addresses = coder.getFromLocationName(address, 5);
            if (addresses == null) {
            }
            Address location = addresses.get(0);
            double lat = location.getLatitude();
            double lng = location.getLongitude();
            Log.i("Lat", "" + lat);
            Log.i("Lng", "" + lng);


            if (location != null) {
                final double latitude = lat;
                final double longitude = lng;
                directions = (Button) findViewById(R.id.directions);
                directions.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String uri = String.format(Locale.ENGLISH, "geo:%f,%f", latitude, longitude);
                        Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                        startActivity(mapIntent);

                    }
                });
                Log.e("Latitude", latitude + " " + longitude);
            }


            txt = (TextView) findViewById(R.id.textView2);
            Linkify.addLinks(txt, Linkify.PHONE_NUMBERS);

            getSupportActionBar().hide();
     setSupportActionBar(toolbar);
       getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void website(View web) {
        Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.swishsoftwaresolutions.com"));
        startActivity(webIntent);
    }


    public LatLng getLocationFromAddress(Context context, String strAddress) {
        Geocoder coder = new Geocoder(context);
        List<Address> address;
        LatLng p1 = null;

        try {
            address = coder.getFromLocationName(strAddress, 5);
            if (address == null) {
                return null;
            }
            Address location = address.get(0);
            p1 = new LatLng(location.getLatitude(), location.getLongitude());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return p1;
    }

    public void favourite(View fav) {
        arrayList = new ArrayList<>();
      //  list = (ListView) findViewById(R.id.list_item);
       // db = new DBHelper(this);
       // arrayList = db.favretriveData(this.favData);
     // toggleButton = (ToggleButton) findViewById(R.id.favourite);
      //  toggleButton.setChecked(true);
     //toggleButton.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_border));
     //   toggleButton = (ToggleButton) findViewById(R.id.favourite);
      //  toggleButton.setChecked(true);
      // toggleButton.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_fav));
      //  toggleButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
          //  if (isChecked)
         //       toggleButton.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.ic_fav));
        //    else
        //        toggleButton.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_border));

      //  });
    }


}

=======
package com.swish.eduin;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.util.Linkify;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.webkit.GeolocationPermissions;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Screen5 extends AppCompatActivity {


    Toolbar toolbar;
    TextView txt;
    Button directions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen5);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        String address="No 22, St Marks Rd, Shanthala Nagar, Ashok Nagar, Bengaluru, Karnataka 560001";
        LatLng latlng=getLocationFromAddress(this,address);
        final double latitude=  latlng.latitude;
        final double longitude=  latlng.longitude;
        directions=(Button)findViewById(R.id.directions);
        directions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uri = String.format(Locale.ENGLISH, "geo:%f,%f", latitude, longitude);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(mapIntent);
            }
        });

        txt = (TextView) findViewById(R.id.textView2);
        Linkify.addLinks(txt,Linkify.PHONE_NUMBERS);


        getSupportActionBar().hide();
        //Log.e("Latitude",latituude+" "+longitude);
//        setSupportActionBar(toolbar);
       /* getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/

    }

    public void website(View web) {
        Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.swishsoftwaresolutions.com"));
        startActivity(webIntent);
    }

    public void directions(View directions) {

    }

    public LatLng getLocationFromAddress(Context context, String strAddress) {

        Geocoder coder = new Geocoder(context);
        List<Address> address;
        LatLng p1 = null;

        try {
            address = coder.getFromLocationName(strAddress, 5);
            if (address == null) {
                return null;
            }
            Address location = address.get(0);
            p1 = new LatLng(location.getLatitude(), location.getLongitude());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return p1;
    }

}
>>>>>>> origin/master
