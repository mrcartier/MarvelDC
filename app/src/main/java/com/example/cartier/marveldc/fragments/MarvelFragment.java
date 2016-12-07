package com.example.cartier.marveldc.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cartier.marveldc.adapters.CardAdapter;
import com.example.cartier.marveldc.data.model.CardItem;
import com.example.cartier.marveldc.R;

import java.util.ArrayList;

/**
 * Created by Cartier on 12/6/2016.
 */
public class MarvelFragment extends Fragment {

    ArrayList<CardItem> cards = new ArrayList<>();
    private CardAdapter adapter;
    private RecyclerView recyclerView;

    private final String hero_names[] = {
            "Black Widow",
            "Captain America",
            "Hawkeye",
            "The Hulk",
            "Iron Man",
            "Thor",
    };

    private final String hero_image_urls[] = {
            "https://res.cloudinary.com/dv2fyyrmo/image/upload/v1480111869/blackwidow_m8lut5.jpg",
            "https://res.cloudinary.com/dv2fyyrmo/image/upload/v1480111898/captain-america-3_ejiazp.jpg",
            "https://res.cloudinary.com/dv2fyyrmo/image/upload/v1480111883/Hawkeye-marvel-comics-4514338-440-348_w4r8o3.jpg",
            "https://res.cloudinary.com/dv2fyyrmo/image/upload/v1481074202/Hulk_u9vmzs.jpg",
            "https://res.cloudinary.com/dv2fyyrmo/image/upload/v1481074210/Iron_Man_comics_sbl1jq.jpg",
            "https://res.cloudinary.com/dv2fyyrmo/image/upload/v1480111947/Thor_Odinson__Earth-8096__003_ltbtoz.png"
    };

    public MarvelFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_marvel, container, false);

        recyclerView = (RecyclerView)rootView.findViewById(R.id.marvel_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<CardItem> cards = getData();
        adapter = new CardAdapter(getActivity().getApplicationContext(),cards);
        recyclerView.setAdapter(adapter);

        // Inflate the layout for this fragment
        return rootView;
    }

    private ArrayList<CardItem> getData(){

        for(int i=0;i<hero_names.length;i++){
            CardItem cardItem = new CardItem();
            cardItem.setHero_name(hero_names[i]);
            cardItem.setHero_image_url(hero_image_urls[i]);
            cards.add(cardItem);
        }
        return cards;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}

