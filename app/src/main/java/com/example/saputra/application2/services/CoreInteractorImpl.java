package com.example.saputra.application2.services;

import android.content.Context;

import com.example.saputra.application2.interactor.CoreInteractor;
import com.example.saputra.application2.model.QuotesEntity;

import java.util.List;

import rx.Observable;

/**
 * Created by Verdiyanto Saputra on 21/05/2017.
 */

public class CoreInteractorImpl implements CoreInteractor {

    private CoreApiService mCoreApi;
    private Context mContext;

    public CoreInteractorImpl(Context context){
        mCoreApi = CoreApiServiceBuilder.provideCoreApiService();
        mContext = context;
    }

    @Override
    public Observable<List<QuotesEntity>> getQuotesHistoryTransaction() {
        return mCoreApi.getQuotes();
    }
}
