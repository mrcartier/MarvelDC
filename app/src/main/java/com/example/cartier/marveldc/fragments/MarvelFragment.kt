package com.example.cartier.marveldc.fragments

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.cartier.marveldc.R
import com.example.cartier.marveldc.adapters.CardAdapter
import com.example.cartier.marveldc.data.model.CardItem

import java.util.ArrayList

/**
 * Created by Cartier on 4/28/2017.
 */

class MarvelFragment : Fragment() {

    internal var cards = ArrayList<CardItem>()
    private val hero_names = ArrayList<String>()
    private val hero_image_urls = ArrayList<String>()
    private var adapter: CardAdapter? = null
    private var recyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getMarvelNames()
        getMarvelUrls()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater!!.inflate(R.layout.fragment_marvel, container, false)

        recyclerView = rootView.findViewById(R.id.marvel_recycler_view) as RecyclerView
        recyclerView!!.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(activity?.applicationContext)
        recyclerView!!.layoutManager = layoutManager

        val cards = data
        adapter = CardAdapter(activity?.applicationContext!!, cards)
        recyclerView!!.adapter = adapter

        // Inflate the layout for this fragment
        return rootView
    }

    fun getMarvelNames() {
        val image_names = arrayOf(resources.getString(R.string.BlackWidow).toString(), resources.getString(R.string.CaptainAmerica).toString(), resources.getString(R.string.Hawkeye).toString(), resources.getString(R.string.TheHulk).toString(), resources.getString(R.string.IronMan), resources.getString(R.string.Thor))

        for (i in image_names.indices) {
            val name = image_names[i]
            hero_names.add(name)
        }

    }

    fun getMarvelUrls() {
        val image_urls = arrayOf(resources.getString(R.string.BlackWidowPic).toString(), resources.getString(R.string.CaptainAmericaPic).toString(), resources.getString(R.string.HawkeyePic).toString(), resources.getString(R.string.TheHulkPic).toString(), resources.getString(R.string.IronManPic), resources.getString(R.string.ThorPic))

        for (i in image_urls.indices) {
            val url = image_urls[i]
            hero_image_urls.add(url)
        }
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
