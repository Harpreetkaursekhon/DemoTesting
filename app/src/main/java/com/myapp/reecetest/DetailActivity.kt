package com.myapp.reecetest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.myapp.reecetest.databinding.ActivityDetailBinding
import com.myapp.reecetest.model.BreedResponseItem

class DetailActivity : AppCompatActivity() {
private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val breed = intent.getParcelableExtra<BreedResponseItem>("breed")
        if (breed!=null){

            binding.tvNameDetail.text = breed.name
            binding.tvLife.text = breed.lifeSpan
            binding.tvBred.text = breed.bredFor
            Glide.with(this).load(breed.image?.url).into(binding.ivImg)
        }
    }
}