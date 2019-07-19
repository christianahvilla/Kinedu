package com.werden.kinedu.ui.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.werden.kinedu.ui.activity.ActivityFragment
import com.werden.kinedu.ui.article.ArticleFragment
import android.R



class HomeViewPager(fm: FragmentManager): FragmentPagerAdapter(fm) {


    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                ActivityFragment()
            }
            1 -> {
                ArticleFragment()
            }
            else -> {
                ActivityFragment()
            }
        }
    }

    override fun getCount(): Int {
        return  2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> {
                "Activities"
            }
            1 -> {
                "Articles"
            }
            else -> {
                ""
            }
        }
    }
}