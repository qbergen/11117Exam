package com.example.queenabergen.a11117exam;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "THIS IS MY TAG LINE";
    List<AvailableKeys> snatchKeys;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://jsjrobotics.nyc/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CollectorServer service = retrofit.create(CollectorServer.class);
        Call<Response> callToServer = service.getServerResponse();
        callToServer.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> mCall, retrofit2.Response<Response> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "Success: " + response.body());
                    List<AvailableKeys> keys = response.body().getMajorKey();
                    TextView mTextView = (TextView) findViewById(R.id.textView);
                    ImageView mImageView = (ImageView) findViewById(R.id.imageView);

                    for (int i = 0; i < keys.size() - 1; i++) {
                        AvailableKeys mKey = keys.get(i);
                        String mName = mKey.getmName().toString();
                        String mTextColor = mKey.getmTextColor().toString();
                        String mURL = mKey.getmUrl().toString();
                        mTextView.setText(mName);
                        mTextView.setTextColor(Color.parseColor(mTextColor));
                        Picasso.with(getApplicationContext()).load(mURL).into(mImageView);

                    }


                } else {
                    Log.d(TAG, "ERROR: Something Happened" + response.body());
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                Log.d("Error", t.getMessage().toString());
            }
        });

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.activity_main, new UserFragment(), TAG);
        fragmentTransaction.commit();
    }

}

