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
public class DCFragment extends Fragment {

    ArrayList<CardItem> cards = new ArrayList<>();
    private CardAdapter adapter;
    private RecyclerView recyclerView;

    private final String hero_names[] = {
            "Aquaman",
            "Batman",
            "Cyborg",
            "The Flash",
            "Superman",
            "Wonder Woman",
    };

    private final String hero_image_urls[] = {
            "https://res.cloudinary.com/dv2fyyrmo/image/upload/v1481065798/aquaman-111kjskldjklsd-1900x700_c_rzddcm.jpg",
            "https://res.cloudinary.com/dv2fyyrmo/image/upload/v1481073577/batman_a2rvqt.jpg",
            "https://res.cloudinary.com/dv2fyyrmo/image/upload/v1481058336/cyborg_gifjiv.jpg",
            "https://res.cloudinary.com/dv2fyyrmo/image/upload/v1481058317/theflash_b8tvxx.jpg",
            "https://res.cloudinary.com/dv2fyyrmo/image/upload/v1481058310/new-52-superman-630x420_iukuac.jpg",
            "https://res.cloudinary.com/dv2fyyrmo/image/upload/v1481058327/Wonder-Woman-DC-Comics-750x400_jqgzyx.jpg"
    };

    public DCFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_dc, container, false);

        recyclerView = (RecyclerView)rootView.findViewById(R.id.dc_recycler_view);
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
