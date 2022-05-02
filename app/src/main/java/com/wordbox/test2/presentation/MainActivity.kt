package com.wordbox.test2.presentation

import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.wordbox.test2.R
import com.wordbox.test2.base.BaseActivity
import com.wordbox.test2.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val navController by lazy { findNavController(R.id.nav_fragment) }

    override fun getActivityBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(binding.activityMTb)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        setupActionBarWithNavController(navController)
    }


    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }
}