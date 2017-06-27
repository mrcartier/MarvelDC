package com.example.cartier.marveldc.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.example.cartier.marveldc.data.model.CardItem
import com.example.cartier.marveldc.R
import com.squareup.picasso.Picasso

import java.util.ArrayList

/**
 * Created by cartier on 12/6/2016.
 */
class CardAdapter(private val context: Context, private val cards: ArrayList<CardItem>) : RecyclerView.Adapter<CardAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): CardAdapter.ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.recycler_card_item, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {

        viewHolder.tv_hero.text = cards[i].hero_name
        Picasso.with(context).load(cards[i].hero_image_url).resize(480, 240).into(viewHolder.img_hero)
    }

    override fun getItemCount(): Int {
        return cards.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        internal var tv_hero: TextView
        internal var img_hero: ImageView

        init {

            tv_hero = view.findViewById(R.id.tv_hero) as TextView
            img_hero = view.findViewById(R.id.img_hero) as ImageView
        }
    }
}
