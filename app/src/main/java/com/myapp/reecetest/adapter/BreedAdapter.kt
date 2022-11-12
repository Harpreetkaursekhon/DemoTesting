package com.myapp.reecetest.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.myapp.reecetest.R
import com.myapp.reecetest.model.BreedResponseItem

class BreedAdapter(private val context: Context, var breedList : ArrayList<BreedResponseItem>):
    RecyclerView.Adapter<BreedAdapter.BreedViewHolder>() {

    var onItemClick: ((BreedResponseItem) -> Unit)? = null

    class BreedViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val name: TextView =itemView.findViewById(R.id.tv_name)
        val breedFor: TextView =itemView.findViewById(R.id.tv_breed_for)
        val country: TextView =itemView.findViewById(R.id.tv_life)
        val dogImg : ImageView = itemView.findViewById(R.id.iv_dog_img)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int): BreedViewHolder =
        BreedViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false))

    override fun onBindViewHolder(holder: BreedViewHolder, position: Int) {
        val breed = breedList.get(position)
        holder.name.text=breed.name
        holder.country.text="Life:" + breed.lifeSpan
        holder.breedFor.text=breed.bredFor
        Glide.with(context).load(breed.image?.url).into(holder.dogImg)

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(breed)
        }
    }

    override fun getItemCount(): Int = breedList.size

    fun setPostData(breedList : ArrayList<BreedResponseItem>)
    {
        this.breedList=breedList
        notifyDataSetChanged()
    }
}