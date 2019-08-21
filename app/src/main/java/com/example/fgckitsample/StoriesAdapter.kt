package com.example.fgckitsample

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import cat.fatginger.fgckit.model.Story
import cat.fatginger.fgckit.utils.DisplayUtils
import com.squareup.picasso.Picasso
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

        stories[position].coverURL?.let {

            val ctx = holder.itemView.context
            val storyThumbSizeDp = ctx.resources.getDimension(R.dimen.story_thumb_size).toInt()
            val storyThumbSizePx = DisplayUtils.dpToPx(storyThumbSizeDp, ctx)
            Picasso.get()
                    .load(stories[position].coverURL)
                    .placeholder(R.drawable.red_rectangle)
                    .resize(storyThumbSizePx, storyThumbSizePx)
                    .centerCrop()
                    .into(holder.coverImage)
        }

        stories[position].storyOwners[0]?.let {

            holder.storyAuthor.text = it.firstName
        }

        holder.storyName.text = stories[position].name
        holder.pos = position

    }

    override fun getItemCount() = stories.size

    class ViewHolder(v: View, var listenner: StoryClickListenner) : RecyclerView.ViewHolder(v), View.OnClickListener {

        var coverImage : ImageView = v.story_list_item_cover_image
        var storyName : TextView = v.story_list_item_name
        var storyAuthor: TextView = v.story_list_item_author

        var pos: Int = -1

        init {
            v.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            listenner.onStoryClicked(pos)
        }
    }
}