package com.rief.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rief.R
import com.rief.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tentang =  getResources().getString(R.string.tentang);

        val actionBar = supportActionBar
        actionBar!!.title = tentang
        actionBar.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}