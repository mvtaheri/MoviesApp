package com.mohammad.moviesapp.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mohammad.moviesapp.R
import com.mohammad.moviesapp.data.model.Movie
import com.mohammad.moviesapp.databinding.ListItemBinding

class MovieAdapter():RecyclerView.Adapter<MovieAdapter.MyViewHolder>() {

    private var movieList=ArrayList<Movie>()

    fun setList(movies :List<Movie>){
        movieList.clear()
        movieList.addAll(movies)
    }

    class MyViewHolder(val binding:ListItemBinding):RecyclerView.ViewHolder(binding.root){
          fun bind(movie:Movie){
              binding.titleTextView.text=movie.title
              binding.descTextView.text=movie.overview

              val poster_url="https://image.tmdb.org/t/p/w500/"+movie.poster_path

              Glide.with(binding.imageView.context)
                  .load(poster_url)
                  .into(binding.imageView)
          }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater=LayoutInflater.from(parent.context)
        val binding:ListItemBinding=DataBindingUtil.inflate(layoutInflater,R.layout.list_item,parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return movieList.count()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
         holder.bind(movieList[position])
    }
}