package com.dev.codehouse.krixi;


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.dev.codehouse.data.DataOffline;
import com.dev.codehouse.sqlite.DeleteSQlite;

import org.w3c.dom.Text;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wachirapan on 21/1/2018 AD.
 */

public class SubMainDataOffline extends BaseAdapter {
    Context mcontext ;
    List<DataOffline> mlist ;
    String URL = "http://192.168.2.206/krixiapp/UploadImage.php";
    String imgurl, headurl, detailurl ;
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
        Button btndell = (Button)v.findViewById(R.id.btndell);
        btndell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DeleteSQlite mdell = new DeleteSQlite(mcontext);
                mdell.deletedata(mlist.get(i).getId().toString());

            }
        });
        Button buttonshare = (Button)v.findViewById(R.id.buttonshare);
        buttonshare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uploadimage();
            }
        });

        mhead.setText(mlist.get(i).getHeadtxt());
        mdetail.setText(mlist.get(i).getDetail());

        byte[] img = mlist.get(i).getImgname();
        Bitmap bitmap = BitmapFactory.decodeByteArray(img, 0 ,img.length);
        imageView.setImageBitmap(bitmap);

        imgurl = Base64.encodeToString(img,Base64.DEFAULT);
        headurl = mlist.get(i).getHeadtxt().toString();
        detailurl = mlist.get(i).getDetail().toString();
        v.setTag(mlist.get(i).getId());
        return v;
    }

    private void Uploadimage()
    {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> param = new HashMap<String, String>();
                param.put("TEN",imgurl);
                param.put("HINH",headurl);
                param.put("detail",detailurl);
                return param;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(mcontext);
        requestQueue.add(stringRequest);
    }
}
