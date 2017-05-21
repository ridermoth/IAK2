package com.example.saputra.application2.services;

import com.example.saputra.application2.model.QuotesEntity;

import java.util.List;
import retrofit2.http.GET;


/**
 * Created by Verdiyanto Saputra on 21/05/2017.
 */

public interface CoreApiService {

    String END_POINT = "questions";

    @GET(END_POINT)
    rx.Observable<List<QuotesEntity>> getQuotes();
}
