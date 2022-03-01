package com.rief.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.rief.R
import com.rief.data.Buku
import com.rief.view.DetailActivity

class Adapter(private val listBuku : ArrayList<Buku>) : RecyclerView.Adapter<Adapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view : View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.rv_list, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (img, judul, penulis, deskripsi) = listBuku[position]

        Glide.with(holder.itemView.context)
            .load(img)
            .apply(RequestOptions())
            .into(holder.imgGambar)

        holder.tvJudul.text = judul.toString()
        holder.tvPenulis.text = penulis.toString()

        val mContext = holder.itemView.context

        holder.itemView.setOnClickListener {
            Intent(mContext, DetailActivity::class.java).also {
                it.putExtra(DetailActivity.EXTRA_GAMBAR, img)
                it.putExtra(DetailActivity.EXTRA_JUDUL, judul)
                it.putExtra(DetailActivity.EXTRA_PENULIS, penulis)
                it.putExtra(DetailActivity.EXTRA_DEKSRIPSI, deskripsi)
                mContext.startActivity(it)
            }
        }
    }

    override fun getItemCount(): Int {
        return listBuku.size
    }


    inner class ListViewHolder(item : View) : RecyclerView.ViewHolder(item){
        var imgGambar : ImageView = itemView.findViewById(R.id.image)
        var tvJudul : TextView = itemView.findViewById(R.id.tvJudul)
        var tvPenulis : TextView = itemView.findViewById(R.id.tvPenulis)
    }
}