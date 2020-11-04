package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val favouriteFragment = FavouriteFragment()
        val settingFragment = SettingFragment()

        makeCurrentFragment(homeFragment)

        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> makeCurrentFragment(homeFragment)
                R.id.nav_favourites -> makeCurrentFragment(favouriteFragment)
                R.id.nav_settings -> makeCurrentFragment(settingFragment)
            }

            true

        }
    }

    private fun makeCurrentFragment(fragment: Fragment)= supportFragmentManager.beginTransaction().apply {

        replace(R.id.layout,fragment)
         commit()
    }

}
