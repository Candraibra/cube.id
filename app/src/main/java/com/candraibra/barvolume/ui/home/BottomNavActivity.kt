package com.candraibra.barvolume.ui.home

import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.candraibra.barvolume.R
import com.google.android.material.bottomnavigation.BottomNavigationView


class BottomNavActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView
    private var doubleBackToExitPressedOnce = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_nav)

        setupBottomNav()
    }

    private fun setupBottomNav() {
        bottomNavigationView = findViewById(R.id.bottom_navigation)
        val navigationController = Navigation.findNavController(this, R.id.nav_host_home)

        //kalo let itu ibaratnya kaya dia memasasukan dirinya ke function dan bisa dipanggil dengan "it"
        //bottomNavigationView.let { NavigationUI.setupWithNavController(it, navigationController) }

        //atau bisa custom kek gini
        //bottomNavigationView.let {navvvv -> NavigationUI.setupWithNavController(navvvv,navigationController) }

        //but, menurutku paling simple gini, tapi yang atas harus tetep inget yack tergantung case juga
        NavigationUI.setupWithNavController(bottomNavigationView, navigationController)
    }

    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()
            return
        }

        this.doubleBackToExitPressedOnce = true
        Toast.makeText(this, resources.getString(R.string.double_exit), Toast.LENGTH_SHORT).show()

        Handler().postDelayed({ doubleBackToExitPressedOnce = false }, 2000)

    }

}

