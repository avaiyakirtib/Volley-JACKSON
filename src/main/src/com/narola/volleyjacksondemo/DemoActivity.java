package com.narola.volleyjacksondemo;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.app.DownloadManager.Request;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.example.jksonlib.JacksonNetwork;
import com.example.jksonlib.JacksonRequest;
import com.example.jksonlib.JacksonRequestListener;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.SimpleType;
     
public class DemoActivity extends Activity {

	private RequestQueue mRequestQueue;
	private ProgressBar mProgressBar;
	private TextView mTvDateData;
	private TextView mTvHeaderData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

		mProgressBar = (ProgressBar)findViewById(R.id.progress);
		mTvDateData = (TextView)findViewById(R.id.tv_date_data);
		mTvHeaderData = (TextView)findViewById(R.id.tv_header_data);
		mRequestQueue = JacksonNetwork.newRequestQueue(getApplicationContext());
		
    }

	@Override
	protected void onStart() {
		super.onStart();
		
        Map<String, String>  params = new HashMap<String, String>();  
        params.put("cur_lat", "40.397451");
        params.put("cur_long", "-3.642079");
        params.put("radius", "2");
        
	/*	mRequestQueue.add(new JacksonRequest<DateReturnType>(Method.POST,
				"http://192.168.1.202/GuiaDeSkate/admin_API/api/skateparkbyRadius.php",
				new JacksonRequestListener<DateReturnType>() {
					@Override
					public void onResponse(DateReturnType response, int statusCode, VolleyError error) {
						if (response != null) {
							//mTvDateData.setText("Time: " + response.time + "\nDate: " + response.date + "\nMS since epoch: " + response.milliseconds_since_epoch);
						} else {
							//mTvDateData.setTextColor(Color.RED);
							//mTvDateData.setText("Error parsing data! Check logcat for details");
							error.printStackTrace();
						}
						mProgressBar.setVisibility(View.GONE);
					}

					@Override
					public JavaType getReturnType() {
						return SimpleType.construct(DateReturnType.class);
					}
				}
		)
 		); */
        
        mRequestQueue.add(
         		new JacksonRequest<SkateParkDetails>(Method.POST,
        		"http://narolademo.no-ip.org/GuiaDeSkate/admin_API/api/skateparkbyRadius.php",
				params,  
				new JacksonRequestListener<SkateParkDetails>() {
					@Override
					public void onResponse(SkateParkDetails response, int statusCode, VolleyError error) {
						if (response != null) {
							
							Log.i("This is response", "res" + response.skateParkDetails.get(0).id);
//							mTvDateData.setText("id: " + response.id);
							
						} else {
							mTvDateData.setTextColor(Color.RED);
							mTvDateData.setText(error.getMessage().toString());
							error.printStackTrace();
						}
						mProgressBar.setVisibility(View.GONE);
					}

					@Override
					public JavaType getReturnType() {
						return SimpleType.construct(SkateParkDetails.class);
					}
				})
				
	);
        
		mRequestQueue.add(new JacksonRequest<HeadersReturnType>(Method.GET,
				"http://headers.jsontest.com",
				new JacksonRequestListener<HeadersReturnType>() {
					@Override
					public void onResponse(HeadersReturnType response, int statusCode, VolleyError error) {
						if (response != null) {
							mTvHeaderData.setText("Host: " + response.host + "\nAccept Language: " + response.acceptLanguage + "\nReferrer: " + response.referrer + "\nUser Agent: " + response.userAgent + "\nAccept: " + response.accept);
						} else {
							mTvHeaderData.setTextColor(Color.RED);
							mTvHeaderData.setText("Error parsing data! Check logcat for details");
							error.printStackTrace();
						}
						mProgressBar.setVisibility(View.GONE);
					}

					@Override
					public JavaType getReturnType() {
						return SimpleType.construct(HeadersReturnType.class);
					}
				})
		);
		
	}
}
