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
 * Created by gerry on 4/28/2017.
 */

class DCFragment : Fragment() {

    internal var cards = ArrayList<CardItem>()
    private val hero_names = ArrayList<String>()
    private val hero_image_urls = ArrayList<String>()
    private var adapter: CardAdapter? = null
    private var recyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getDCNames()
        getDCUrls()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater!!.inflate(R.layout.fragment_dc, container, false)

        recyclerView = rootView.findViewById(R.id.dc_recycler_view) as RecyclerView
        recyclerView!!.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(activity.applicationContext)
        recyclerView!!.layoutManager = layoutManager

        val cards = data
        adapter = CardAdapter(activity.applicationContext, cards)
        recyclerView!!.adapter = adapter

        // Inflate the layout for this fragment
        return rootView
    }

    fun getDCNames() {
        val image_names = arrayOf(resources.getString(R.string.Aquaman).toString(), resources.getString(R.string.Batman).toString(), resources.getString(R.string.Cyborg).toString(), resources.getString(R.string.TheFlash).toString(), resources.getString(R.string.Superman), resources.getString(R.string.WonderWoman))

        for (i in image_names.indices) {
            val name = image_names[i]
            hero_names.add(name)
        }

    }

    fun getDCUrls() {
        val image_urls = arrayOf(resources.getString(R.string.AquamanPic).toString(), resources.getString(R.string.BatmanPic).toString(), resources.getString(R.string.CyborgPic).toString(), resources.getString(R.string.TheFlashPic).toString(), resources.getString(R.string.SupermanPic), resources.getString(R.string.WonderWomanPic))

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
