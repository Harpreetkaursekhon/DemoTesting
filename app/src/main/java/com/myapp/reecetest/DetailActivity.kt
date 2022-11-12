package com.myapp.reecetest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.myapp.reecetest.model.BreedResponseItem

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val breed = intent.getParcelableExtra<BreedResponseItem>("breed")
        if (breed!=null){
            val tvName: TextView = findViewById(R.id.tv_name_detail)
            val tvCountry: TextView = findViewById(R.id.tv_life)
            val tvBreed: TextView = findViewById(R.id.tv_bred)
            val ivImg: ImageView = findViewById(R.id.iv_img)

            tvName.text = breed.name
            tvCountry.text = breed.lifeSpan
            tvBreed.text = breed.bredFor
            Glide.with(this).load(breed.image?.url).into(ivImg)
        }
    }
}