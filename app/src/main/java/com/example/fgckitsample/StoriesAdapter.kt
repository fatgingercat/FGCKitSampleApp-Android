package com.example.fgckitsample

import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import cat.fatginger.fgckit.model.Story
import com.facebook.drawee.view.SimpleDraweeView
import kotlinx.android.synthetic.main.story_list_item.view.*


class StoriesAdapter(private val stories : ArrayList<Story>, private val listenner: StoryClickListenner) :
        RecyclerView.Adapter<StoriesAdapter.ViewHolder>() {

    interface StoryClickListenner {

        fun onStoryClicked(pos: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.story_list_item, parent, false)
        return ViewHolder(v, listenner)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        stories[position].coverUrl?.let {

            val uri = Uri.parse(stories[position].coverUrl)
            holder.coverImage.setImageURI(uri, null)
        }

        holder.storyName.text = stories[position].name
        holder.pos = position

    }

    override fun getItemCount() = stories.size

    class ViewHolder(v: View, var listenner: StoryClickListenner) : RecyclerView.ViewHolder(v), View.OnClickListener {

        var coverImage : SimpleDraweeView = v.story_list_item_cover_image
        var storyName : TextView = v.story_list_item_name

        var pos: Int = -1

        init {
            v.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            listenner.onStoryClicked(pos)
        }
    }
}