package com.example.kotlin_rv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_layout.view.*

class MainAdapter(val homeFeed: HomeFeed): RecyclerView.Adapter<CustomViewHolder>() {

    //number of item
    override fun getItemCount(): Int {
        return homeFeed.videos.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        //how do we even create a view
        val layoutInflater = LayoutInflater.from(parent?.context)
        val itemRow = layoutInflater.inflate(R.layout.item_layout,parent,false)
        return CustomViewHolder(itemRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val videos = homeFeed.videos.get(position)
        holder.itemView.text_name.text = videos.name
        holder.itemView.text_channel_name.text = videos.channel.name

        val thumbnailIV = holder.itemView.image_item
        Picasso.get().load(videos.imageUrl).into(thumbnailIV)

        val channelIV = holder.itemView.image_channel
        Picasso.get().load(videos.channel.profileImageUrl).into(channelIV)
    }
}

class CustomViewHolder(val v: View): RecyclerView.ViewHolder(v){

}