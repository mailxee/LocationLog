package com.blogspot.xeeshan.locationlog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.zip.Inflater;

/**
 * Created by Zeeshan on 10/02/2015.
 */
public class MyArrayAdapter extends ArrayAdapter
{
    Context mContext;
    int mLayoutResourceID;
    public MyArrayAdapter(Context context, int resource)
    {
        super(context, resource);
        mContext=context;
        mLayoutResourceID=resource;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        String[] curString=(String[])getItem(position);
        LayoutInflater mInflate= (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View mView;
        if (convertView==null) mView=mInflate.inflate(mLayoutResourceID,parent);
        else mView=convertView;
        TextView mLatLong=(TextView) mView.findViewById(R.id.textViewLatLong);
        TextView mAddress=(TextView) mView.findViewById(R.id.textViewAddress);
        mLatLong.setText(curString[0]);
        mAddress.setText(curString[1]);
        return mView;
    }
}
