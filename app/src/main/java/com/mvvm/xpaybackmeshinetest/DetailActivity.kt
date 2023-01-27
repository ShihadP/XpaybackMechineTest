package com.mvvm.xpaybackmeshinetest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.mvvm.xpaybackmeshinetest.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {


     lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val extras = intent.extras

        binding.name.text=extras?.get("name").toString()
        binding.address.text="Address :"+extras?.get("address").toString()
        binding.phone.text="Phone :"+extras?.get("phone").toString()
        binding.place.text="Place :"+extras?.get("place").toString()
        binding.age.text="Age :"+extras?.get("age").toString()
        binding.email.text="Gmail :"+extras?.get("gmail").toString()

        binding.prof.text="Profesion :"+extras?.get("prof").toString()

        binding.dob.text="Dob :"+extras?.get("dob").toString()
        binding.blood.text="Blood Group :"+extras?.get("blood").toString()

        Glide.with(this).load(extras?.get("image")).into(  binding.imageview)

    }
}