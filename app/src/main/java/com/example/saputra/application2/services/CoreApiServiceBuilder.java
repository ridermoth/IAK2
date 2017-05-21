package com.example.saputra.application2.services;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.R.id.message;

/**
 * Created by Verdiyanto Saputra on 21/05/2017.
 */

public class CoreApiServiceBuilder {

    private static final String HTTP_TAG = "";
    private static final String CACHE_CONTROL = "";
    private static final String HTTP_CACHE = "";

    private static final int CACHE_SIZE = 10 * 1024 * 1024;

    private static final String BASE_URL = "https://private-4e4159-qurrata.apiary-mock.com/";

    public static CoreApiService provideCoreApiService() {
        return provideRetrofit().create(CoreApiService.class);
    }

    private static Retrofit provideRetrofit() {
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder()
                .addInterceptor(provideHttpLoggingInterceptor())
                .readTimeout(20, TimeUnit.SECONDS)
                .connectTimeout(20, TimeUnit.SECONDS);

        Gson gson = new GsonBuilder().setLenient().serializeNulls().create();
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(clientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    private static HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor =
                new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger(){

                    @Override
                    public void log(String message) {
                        Log.d(HTTP_TAG, message);
                    }
                });
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);
        return httpLoggingInterceptor;
    }


}
