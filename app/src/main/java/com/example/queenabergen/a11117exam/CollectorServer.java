package com.example.queenabergen.a11117exam;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by queenabergen on 1/11/17.
 */

public interface CollectorServer {

    @GET("cgi-bin/1_11_2017_exam.pl")
    Call<Response>getServerResponse();

}
