package com.rief.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.rief.R

class DetailActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val imgGambar : ImageView = findViewById(R.id.imageDetail)
        val tvJudul : TextView = findViewById(R.id.tvJudul)
        val tvPenulis : TextView = findViewById(R.id.tvPenulis)
        val tvDeskripsi : TextView = findViewById(R.id.tvDeskripsi)

        val tImage = intent.getIntExtra(EXTRA_GAMBAR, 0)
        val tJudul = intent.getStringExtra(EXTRA_JUDUL)
        val tPenulis = intent.getStringExtra(EXTRA_PENULIS)
        val tDeskripsi = intent.getStringExtra(EXTRA_DEKSRIPSI)

        Glide.with(this)
            .load(tImage)
            .apply(RequestOptions())
            .into(imgGambar)
        tvJudul.text = tJudul.toString()
        tvPenulis.text = tPenulis.toString()
        tvDeskripsi.text = tDeskripsi.toString()

        val detail = getResources().getString(R.string.detail)

        val actionBar = supportActionBar
        actionBar!!.title = detail
        actionBar.setDisplayHomeAsUpEnabled(true)

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    companion object {
        const val EXTRA_GAMBAR = "extra_gambar"
        const val EXTRA_JUDUL = "extra_judul"
        const val  EXTRA_PENULIS = "extra_penulis"
        const val EXTRA_DEKSRIPSI = "extra_deksripsi"
    }
}