package com.blogspot.xeeshan.locationlog;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class AddViewLocationActivity extends ActionBarActivity
        implements View.OnClickListener, LocationListener
{

    LocationManager mLocationManager;
    MyArrayAdapter myArrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_view_location);
        myArrayAdapter=new MyArrayAdapter(this,R.layout.listview_gps_locations);
        ((ListView)findViewById(R.id.listView)).setAdapter(myArrayAdapter);
        ((Button)findViewById(R.id.button)).setOnClickListener(this);
    }

    @Override
    public void onClick(View mView)
    {
        try
        {
            mLocationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2000, 10, this);
        }
        catch (Exception e)
        {
            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG);

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_view_location, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onLocationChanged(Location location)
    {
        Toast.makeText(this,"First message from location changed",Toast.LENGTH_LONG);
        String[] curString = new String[2];
        Location mLocation = mLocationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        mLocationManager.removeUpdates(this);
        curString[0] = "Lat:" + mLocation.getLatitude() + " Long: " + mLocation.getLongitude();
        curString[1] = String.valueOf(((EditText) findViewById(R.id.editText)).getText());
        Toast.makeText(this,curString[0],Toast.LENGTH_LONG);
        myArrayAdapter.add(curString);
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras)
    {

    }

    @Override
    public void onProviderEnabled(String provider)
    {

    }

    @Override
    public void onProviderDisabled(String provider)
    {

    }
}
