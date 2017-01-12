package com.example.queenabergen.a11117exam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "THIS IS MY TAG LINE";

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


                } else {
                    Log.d(TAG, "ERROR: Something Happened" + response.body());
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });

      
    }
}
