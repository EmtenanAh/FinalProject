package com.example.finalproject.View.Fragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.finalproject.View.Fragment.Favorite.FavoriteFragment
import com.example.finalproject.View.Fragment.Kindergarten.KindergartenFragment
import com.example.finalproject.View.Fragment.Profile.ProfileFragment

class FragmentAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return KindergartenFragment()
            1 -> return FavoriteFragment()
            2 -> return ProfileFragment()
        }

        return KindergartenFragment()
    }
}