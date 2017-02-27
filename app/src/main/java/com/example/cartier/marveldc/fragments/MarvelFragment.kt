package com.example.cartier.marveldc.fragments

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.cartier.marveldc.adapters.CardAdapter
import com.example.cartier.marveldc.data.model.CardItem
import com.example.cartier.marveldc.R

import java.util.ArrayList

/**
 * Created by Cartier on 12/6/2016.
 */
class MarvelFragment : Fragment() {

    internal var cards = ArrayList<CardItem>()
    private var adapter: CardAdapter? = null
    private var recyclerView: RecyclerView? = null

    private val hero_names = arrayOf("Black Widow", "Captain America", "Hawkeye", "The Hulk", "Iron Man", "Thor")

    private val hero_image_urls = arrayOf("https://res.cloudinary.com/dv2fyyrmo/image/upload/v1480111869/blackwidow_m8lut5.jpg", "https://res.cloudinary.com/dv2fyyrmo/image/upload/v1480111898/captain-america-3_ejiazp.jpg", "https://res.cloudinary.com/dv2fyyrmo/image/upload/v1480111883/Hawkeye-marvel-comics-4514338-440-348_w4r8o3.jpg", "https://res.cloudinary.com/dv2fyyrmo/image/upload/v1481074202/Hulk_u9vmzs.jpg", "https://res.cloudinary.com/dv2fyyrmo/image/upload/v1481074210/Iron_Man_comics_sbl1jq.jpg", "https://res.cloudinary.com/dv2fyyrmo/image/upload/v1480111947/Thor_Odinson__Earth-8096__003_ltbtoz.png")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater!!.inflate(R.layout.fragment_marvel, container, false)

        recyclerView = rootView.findViewById(R.id.marvel_recycler_view) as RecyclerView
        recyclerView!!.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(activity.applicationContext)
        recyclerView!!.layoutManager = layoutManager

        val cards = data
        adapter = CardAdapter(activity.applicationContext, cards)
        recyclerView!!.adapter = adapter

        // Inflate the layout for this fragment
        return rootView
    }

    private val data: ArrayList<CardItem>
        get() {

            for (i in hero_names.indices) {
                val cardItem = CardItem()
                cardItem.hero_name = hero_names[i]
                cardItem.hero_image_url = hero_image_urls[i]
                cards.add(cardItem)
            }
            return cards
        }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
    }

    override fun onDetach() {
        super.onDetach()
    }
}

