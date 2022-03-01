package com.rief

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rief.adapter.Adapter
import com.rief.data.Buku
import com.rief.data.ListData
import com.rief.view.AboutActivity

class MainActivity : AppCompatActivity() {

    private lateinit var rvBuku : RecyclerView
    private var list : ArrayList<Buku> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvBuku = findViewById(R.id.rvList)
        rvBuku.setHasFixedSize(true)

        list.addAll(ListData.mappingData)
        showRecyclerList()

        val detail = getResources().getString(R.string.aplikasi)

        val actionBar = supportActionBar
        actionBar!!.title = detail
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.btnAbout -> {
                Intent(this, AboutActivity::class.java).also {
                startActivity(it)
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showRecyclerList() {
        rvBuku.layoutManager = LinearLayoutManager(this)
        val adapterRV = Adapter(list)
        rvBuku.adapter = adapterRV
    }
}