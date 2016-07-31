package com.example.abi.nosql;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class Monitor extends AppCompatActivity {
    ProgressDialog dialog;
    LinearLayout monitor;
    Bitmap bitmap;
    ImageView img;

    String url = "http://192.168.166.1/img/getImages.php";

    List<String> path;
    List<String> name;
    RequestQueue queue;
    StringRequest request;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor);
        queue = Volley.newRequestQueue(this);

        Button btnFetch = (Button) findViewById(R.id.btnFetch);



        dialog = new ProgressDialog(this);
        monitor = (LinearLayout)findViewById(R.id.monitor);

        name = new ArrayList<>();
        path = new ArrayList<>();

        btnFetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //Toast.makeText(getApplicationContext(),response, Toast.LENGTH_SHORT).show();
                        try {
                            JSONObject object = new JSONObject(response);
                            JSONArray array = object.getJSONArray("table_gallery");
                            for(int i=0; i<array.length(); i++){
                                JSONObject temp = array.getJSONObject(i);
                                name.add(temp.getString("name"));
                                path.add(temp.getString("path"));
                                new SetImage().execute(temp.getString("path"));
                            }
                        } catch (JSONException e) {
                            Log.e("JSON ERROR", e.toString());
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Log.e("VOLLEY",error.toString());
                    }
                });
                queue.add(request);
            }
        });

    }

    private class SetImage extends AsyncTask<String, String, String>{
        @Override
        protected String doInBackground(String... params) {
            return params[0];
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            new LoadImage().execute(s);
            Toast.makeText(getApplicationContext(), "Downloaded", Toast.LENGTH_SHORT).show();
        }
    }

    private class LoadImage extends AsyncTask<String, String, Bitmap>{
        @Override
        protected Bitmap doInBackground(String... params) {
            try {
                bitmap = BitmapFactory.decodeStream((InputStream) new URL(params[0]).getContent());
            }catch(IOException e){
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(getApplicationContext(),"Loading Image", Toast.LENGTH_SHORT).show();
            dialog.setIndeterminate(true);
            dialog.show();
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            if(bitmap != null){
               LinearLayout.LayoutParams imgLayout = new LinearLayout.LayoutParams(300,400);
                img = new ImageView(Monitor.this);
                img.setImageBitmap(bitmap);
                img.setLayoutParams(imgLayout);
                monitor.addView(img);
                dialog.dismiss();
            }else{
                dialog.dismiss();
                Toast.makeText(getApplicationContext(), "Loading Image Error", Toast.LENGTH_SHORT).show();
            }

        }
    }


}

