package com.dev.codehouse.krixi;


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.dev.codehouse.data.DataOffline;

import org.w3c.dom.Text;

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
    public View getView(final int i, View view, ViewGroup viewGroup) {
        View v = View.inflate(mcontext,R.layout.activity_sub_data,null);
        TextView mhead = (TextView)v.findViewById(R.id.textView);
        TextView mdetail = (TextView)v.findViewById(R.id.detailtxt);
        ImageView imageView = (ImageView)v.findViewById(R.id.imageView);
        Button btndetail = (Button)v.findViewById(R.id.btnlookdata) ;
        btndetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mintentdetail = new Intent(mcontext,MainDetail.class);
                mintentdetail.putExtra("ID", mlist.get(i).getId());
                mcontext.startActivity(mintentdetail);

            }
        });

        mhead.setText(mlist.get(i).getHeadtxt());
        mdetail.setText(mlist.get(i).getDetail());

        byte[] img = mlist.get(i).getImgname();
        Bitmap bitmap = BitmapFactory.decodeByteArray(img, 0 ,img.length);
        imageView.setImageBitmap(bitmap);

        v.setTag(mlist.get(i).getId());
        return v;
    }
}
