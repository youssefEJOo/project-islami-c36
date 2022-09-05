package com.route.islami_progect_c36

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
   lateinit var bottomnavigationitem : BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        bottomnavigationitem = findViewById(R.id.bottom_navigation_bar)
        supportFragmentManager.beginTransaction().replace(
            R.id.frame_container,
            FragmentQuran()
        ).commit()

        bottomnavigationitem.setOnItemSelectedListener { item ->
            if (item.itemId == R.id.ic_quran) {
                supportFragmentManager.beginTransaction().replace(
                    R.id.frame_container,
                    FragmentQuran()
                ).commit()
            } else if (item.itemId == R.id.ic_ahadeth) {
                supportFragmentManager.beginTransaction().replace(
                    R.id.frame_container,
                    FragmentAhadeth()
                ).commit()
            }else if (item.itemId == R.id.ic_sebha) {
                supportFragmentManager.beginTransaction().replace(
                    R.id.frame_container,
                    FragmentSebha()
                ).commit()
            }else if (item.itemId == R.id.ic_radio) {
                supportFragmentManager.beginTransaction().replace(
                    R.id.frame_container,
                    FragmentRadio()
                ).commit()
            }

            return@setOnItemSelectedListener true

        }
    }
}