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
import com.myapp.reecetest.databinding.ItemViewBinding
import com.myapp.reecetest.model.BreedResponseItem

class BreedAdapter(private val context: Context, var breedList : ArrayList<BreedResponseItem>):
    RecyclerView.Adapter<BreedAdapter.BreedViewHolder>() {

    var onItemClick: ((BreedResponseItem) -> Unit)? = null

    class BreedViewHolder(val binding: ItemViewBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int): BreedViewHolder {
        val binding = ItemViewBinding.
            inflate(LayoutInflater.from(parent.context),parent,false)
        return BreedViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BreedViewHolder, position: Int) {
        val breed = breedList.get(position)
        holder.binding.tvName.text=breed.name
        holder.binding.tvLife.text="Life:" + breed.lifeSpan
        holder.binding.tvBreedFor.text=breed.bredFor
        Glide.with(context).load(breed.image?.url).into(holder.binding.ivDogImg)

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