package com.mvvm.xpaybackmeshinetest

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mvvm.xpaybackmeshinetest.databinding.AdapterMovieBinding


class MoviePagerAdapter: PagingDataAdapter<users, MoviePagerAdapter.MovieViewHolder>(MovieComparator) {

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = getItem(position)!!
        holder.view.name.text = movie.firstName
        Glide.with(holder.itemView.context).load(movie.image).into(holder.view.imageview)

         holder.itemView.setOnClickListener {
             val intent= Intent(holder.itemView.context, DetailActivity::class.java);
             intent.putExtra("name",movie.firstName+" "+movie.lastName);
             intent.putExtra("image",movie.image);
             intent.putExtra("address",movie.address?.address);
             intent.putExtra("place",movie.address?.city);
             intent.putExtra("age",movie.age);
             intent.putExtra("phone",movie.phone);
             intent.putExtra("gmail",movie.email);
             intent.putExtra("dob",movie.birthDate);
             intent.putExtra("blood",movie.bloodGroup);
             intent.putExtra("prof",movie.company?.department);
             startActivity(holder.itemView.context,intent,null);

         }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterMovieBinding.inflate(inflater, parent, false)

        ///val holder = MovieViewHolder(binding)
//        holder.itemView.setOnClickListener {
//                val intent= Intent(holder.itemView.context, DetailActivity::class.java);
//                intent.putExtra("key",holder.itemView.);
//               startActivity(holder.itemView.context,intent,null);
//
//        }
        return MovieViewHolder(binding)
    }

    class MovieViewHolder(val view: AdapterMovieBinding): RecyclerView.ViewHolder(view.root) {

    }

    object MovieComparator: DiffUtil.ItemCallback<users>() {
        override fun areItemsTheSame(oldItem: users, newItem: users): Boolean {
            // Id is unique.
            return oldItem.firstName == newItem.firstName
        }

        override fun areContentsTheSame(oldItem: users, newItem: users): Boolean {
            return oldItem == newItem
        }
    }
}

