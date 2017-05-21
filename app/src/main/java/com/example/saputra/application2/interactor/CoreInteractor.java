package com.example.saputra.application2.interactor;

import com.example.saputra.application2.model.QuotesEntity;

import java.util.List;

import rx.Observable;

/**
 * Created by Verdiyanto Saputra on 21/05/2017.
 */

public interface CoreInteractor {

    // activity 1
    Observable<List<QuotesEntity>> getQuotesHistoryTransaction();

    // activity 2
    // Observable blablabla
}
