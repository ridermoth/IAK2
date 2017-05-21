package com.example.saputra.application2.interactor;

import com.example.saputra.application2.model.QuotesEntity;
import com.example.saputra.application2.util.BasePresenter;
import com.example.saputra.application2.util.BaseView;

import java.util.List;

/**
 * Created by Verdiyanto Saputra on 21/05/2017.
 */

public interface QuotesContract {

    interface View extends BaseView<Presenter> {

        void updateQuotes(List<QuotesEntity> quotesEntities);

        void showProgress();

        void hideProgress();
    }

    interface Presenter extends BasePresenter<View> {

        void getQuotesHistory();
    }
}
