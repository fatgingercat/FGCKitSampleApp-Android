package com.example.fgckitsample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import cat.fatginger.fgckit.FGCKit
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    private lateinit var loadStories: Button
    private lateinit var progressBar: ProgressBar
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadStories = this.activity_main_load_stories
        progressBar = this.activity_main_progress_bar
        recyclerView = this.activity_main_recycler_view

        loadStories.setOnClickListener { loadStories() }

    }

    private fun loadStories() {

        loadStories.visibility = View.GONE
        progressBar.visibility = View.VISIBLE

        FGCKit.stories { stories, error ->

            if (stories != null && error == null) {

                progressBar.visibility = View.GONE
                val storiesAdapter = StoriesAdapter(stories, object : StoriesAdapter.StoryClickListenner {
                    override fun onStoryClicked(pos: Int) {

                        if (pos < 0 || pos >= stories.size) {

                            Toast.makeText(this@MainActivity, R.string.could_not_load_story, Toast.LENGTH_LONG).show()
                        }

                        supportFragmentManager
                                .beginTransaction()
                                .add(R.id.activity_main_root_layout, FGCKit.readerFragment(stories[pos]))
                                .addToBackStack(null)
                                .commit()
                    }

                })

                recyclerView.apply {
                    setHasFixedSize(true)
                    layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                    adapter = storiesAdapter
                    visibility = View.VISIBLE
                }
            }

            else if (error != null) {

                Log.e("MainActivity" , error.name)


            }
        }
    }
}
