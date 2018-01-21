package com.dev.codehouse.krixi;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.dev.codehouse.data.DataOffline;

import java.util.List;

/**
 * Created by wachirapan on 21/1/2018 AD.
 */

public class SubMainDataOffline extends BaseAdapter {
    Context mcontext ;
    List<DataOffline> mlist ;
    public  SubMainDataOffline(Context context, List<DataOffline> list){
        this.mcontext = context ;
        this.mlist = list ;
    }
    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public Object getItem(int i) {
        return mlist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = View.inflate(mcontext,R.layout.activity_sub_data,null);
        ImageView mimage = (ImageView)v.findViewById(R.id.imageView);
        TextView mtext = (TextView)v.findViewById(R.id.textView);
        TextView mdetail = (TextView)v.findViewById(R.id.detailtxt);
        Button btnlook = (Button)v.findViewById(R.id.btnlookdata);
        Button btnshare = (Button)v.findViewById(R.id.buttonshare);
        Button btndell = (Button)v.findViewById(R.id.btndell);



        v.getTag(Integer.parseInt(mlist.get(i).getId()));
        return v;
    }
}
