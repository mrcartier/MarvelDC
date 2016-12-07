package com.example.cartier.marveldc.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cartier.marveldc.data.model.CardItem;
import com.example.cartier.marveldc.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Cartier on 12/6/2016.
 */
public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {
    private ArrayList<CardItem> cards;
    private Context context;

    public CardAdapter(Context context,ArrayList<CardItem> cards) {
        this.context = context;
        this.cards = cards;

    }

    @Override
    public CardAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_card_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        viewHolder.tv_hero.setText(cards.get(i).getHero_name());
        Picasso.with(context).load(cards.get(i).getHero_image_url()).resize(480, 240).into(viewHolder.img_hero);
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_hero;
        ImageView img_hero;
        public ViewHolder(View view) {
            super(view);

            tv_hero = (TextView)view.findViewById(R.id.tv_hero);
            img_hero = (ImageView)view.findViewById(R.id.img_hero);
        }
    }
}
