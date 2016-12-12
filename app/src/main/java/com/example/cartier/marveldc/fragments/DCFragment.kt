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
class DCFragment : Fragment() {

    internal var cards = ArrayList<CardItem>()
    private var adapter: CardAdapter? = null
    private var recyclerView: RecyclerView? = null

    private val hero_names = arrayOf("Aquaman", "Batman", "Cyborg", "The Flash", "Superman", "Wonder Woman")

    private val hero_image_urls = arrayOf("https://res.cloudinary.com/dv2fyyrmo/image/upload/v1481065798/aquaman-111kjskldjklsd-1900x700_c_rzddcm.jpg", "https://res.cloudinary.com/dv2fyyrmo/image/upload/v1481073577/batman_a2rvqt.jpg", "https://res.cloudinary.com/dv2fyyrmo/image/upload/v1481058336/cyborg_gifjiv.jpg", "https://res.cloudinary.com/dv2fyyrmo/image/upload/v1481058317/theflash_b8tvxx.jpg", "https://res.cloudinary.com/dv2fyyrmo/image/upload/v1481058310/new-52-superman-630x420_iukuac.jpg", "https://res.cloudinary.com/dv2fyyrmo/image/upload/v1481058327/Wonder-Woman-DC-Comics-750x400_jqgzyx.jpg")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
}// Required empty public constructor
