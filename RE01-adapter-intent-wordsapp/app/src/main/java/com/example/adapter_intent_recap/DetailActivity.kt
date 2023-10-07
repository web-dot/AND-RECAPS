package com.example.adapter_intent_recap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.adapter_intent_recap.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    // a companion object is accessible across multiple classes
    companion object{
        const val LETTER = "letter"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /**
         * retrieving a binding object that allows to refer to view by id name
         * Names are converted from snake case to camel case
         * For example a view with the id word_one is referenced as binding.wordOne
         * */
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // `intent` is not a property of DetailActivity, it is a property of any activity
        // It keeps a reference to the intent used to launch the activity
        val letterId = intent?.extras?.getString(LETTER).toString()

        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = WordAdapter(letterId, this)

        recyclerView.addItemDecoration(
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        )

        title = "Words That Start With" + " " + letterId
    }
}