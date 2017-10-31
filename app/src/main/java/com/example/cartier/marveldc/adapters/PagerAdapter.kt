package com.example.cartier.marveldc.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

import com.example.cartier.marveldc.fragments.DCFragment
import com.example.cartier.marveldc.fragments.MarvelFragment


class PagerAdapter(fm: FragmentManager, internal var mNumOfTabs: Int) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment? {

        when (position) {
            0 -> {
                val tab1 = MarvelFragment()
                return tab1
            }
            1 -> {
                val tab2 = DCFragment()
                return tab2
            }
            else -> return null
        }
    }

    override fun getCount(): Int {
        return mNumOfTabs
    }
}
