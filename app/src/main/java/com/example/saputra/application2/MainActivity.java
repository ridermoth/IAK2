package com.example.saputra.application2;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.saputra.application2.adapter.AdapterMain;
import com.example.saputra.application2.databinding.ActivityMainBinding;
import com.example.saputra.application2.interactor.QuotesContract;
import com.example.saputra.application2.model.QuotesEntity;
import com.example.saputra.application2.presenter.MainPresenter;
import com.example.saputra.application2.services.CoreInteractorImpl;

import java.util.List;

public class MainActivity extends AppCompatActivity implements QuotesContract.View {

    private ActivityMainBinding mBinding;

    private AdapterMain mAdapterMain;

    private RecyclerView mRecyclerView;

    private List<QuotesEntity> mQuotesEntity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        initRecyclerView();
        QuotesContract.Presenter mPresenter = initPresenter();
        mPresenter.bind(this);

        showProgress();
        mPresenter.getQuotesHistory();
    }

    private void initRecyclerView() {
        mRecyclerView = mBinding.listItem;
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public QuotesContract.Presenter initPresenter() {
        return new MainPresenter(new CoreInteractorImpl(getApplicationContext()));
    }

    @Override
    public void updateQuotes(List<QuotesEntity> quotesEntities) {
        mQuotesEntity = quotesEntities;
        if(mAdapterMain == null){
            mAdapterMain = new AdapterMain(quotesEntities, this);
        }
        if(mRecyclerView.getAdapter() == null) {
            mRecyclerView.setAdapter(mAdapterMain);
        } else {
            Toast.makeText(this, "+ not added", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }
}
