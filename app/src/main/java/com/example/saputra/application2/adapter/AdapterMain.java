package com.example.saputra.application2.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.saputra.application2.R;
import com.example.saputra.application2.model.QuotesEntity;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Verdiyanto Saputra on 21/05/2017.
 */

public class AdapterMain extends RecyclerView.Adapter<AdapterMain.ViewHolder> {

    private List<QuotesEntity> mQuotesEntity;
    private Context mContext;

    public AdapterMain(List<QuotesEntity> mQuotesEntity, Context context) {
        this.mQuotesEntity = mQuotesEntity;
        this.mContext = context;
    }

    @Override
    public AdapterMain.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_home_view, parent, false);
        return new AdapterMain.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AdapterMain.ViewHolder holder, int position) {

        QuotesEntity quotesEntity = mQuotesEntity.get(position);

        holder.textView1.setText(quotesEntity.getJudul());
        holder.textView2.setText(quotesEntity.getTentang());
        holder.textView3.setText(quotesEntity.getIsi());

        //Picasso.with(mContext).load(quotesEntity.getIsi()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mQuotesEntity.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView1, textView2, textView3;
        CardView cardView;
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);

            textView1 = (TextView) itemView.findViewById(R.id.tv_judul);
            textView2 = (TextView) itemView.findViewById(R.id.tv_tentang);
            textView3 = (TextView) itemView.findViewById(R.id.tv_isi);

            cardView = (CardView) itemView.findViewById(R.id.card_view);
            //cardView.setOnClickListener(this);
        }

//        @Override
//        public void onClick(View v) {
//
//            if(v.getId() == R.id.card_view){
//                Intent intent = new Intent(mContext.getApplicationContext(), RetroActivity.class);
//                intent.putExtra("judul", ((TextView) v.findViewById(R.id.tv_judul)).getText());
//                intent.putExtra("tentang", ((TextView) v.findViewById(R.id.tv_tentang)).getText());
//                intent.putExtra("isi", ((TextView) v.findViewById(R.id.tv_isi)).getText());
//                mContext.startActivity(intent);
//            }
//        }
    }
}
