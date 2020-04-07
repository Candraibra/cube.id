package com.candraibra.barvolume.ui.home

import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.candraibra.barvolume.R
import kotlinx.android.synthetic.main.activity_bottom_nav.*


class BottomNavActivity : AppCompatActivity() {
    private var doubleBackToExitPressedOnce = false
    private lateinit var navController:NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_nav)
         navController= Navigation.findNavController(this, R.id.nav_host_home)

        setupWithNavController(bottom_navigation, navController)
    }

//    private fun setupBottomNav() {
//        bottomNavigationView = findViewById(R.id.bottom_navigation)
//        val navigationController = Navigation.findNavController(this, R.id.nav_host_home)
//
//        //kalo let itu ibaratnya kaya dia memasasukan dirinya ke function dan bisa dipanggil dengan "it"
//        //bottomNavigationView.let { NavigationUI.setupWithNavController(it, navigationController) }
//
//        //atau bisa custom kek gini
//        //bottomNavigationView.let {navvvv -> NavigationUI.setupWithNavController(navvvv,navigationController) }
//
//        //but, menurutku paling simple gini, tapi yang atas harus tetep inget yack tergantung case juga
//        NavigationUI.setupWithNavController(bottomNavigationView, navigationController)
//    }

    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            finish()
            return
        }

        this.doubleBackToExitPressedOnce = true
        Toast.makeText(this, resources.getString(R.string.double_exit), Toast.LENGTH_SHORT).show()

        Handler().postDelayed({ doubleBackToExitPressedOnce = false }, 2000)

    }

}

