package com.example.pet_project.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pet_project.R
import com.example.pet_project.adapters.MovieAdapter
import com.example.pet_project.model.MovieResponse

class MainActivity : AppCompatActivity(), MainViewInterface {

    private lateinit var rvMovies: RecyclerView
    private lateinit var adapter: MovieAdapter
    private lateinit var mainPresenter: MainPresenter

    private val myTag: String = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initAllFields()
        getMovieList()
    }

    override fun displayMovies(movieResponse: MovieResponse) {
        if (movieResponse.results != null) {
            Log.d(myTag, movieResponse.results[1].title)
            adapter = MovieAdapter(movieResponse.results, this)
            rvMovies.adapter = adapter
        } else {
            Log.d(myTag, "Movies response null")
        }
    }

    override fun displayError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }

    private fun initAllFields() {
        mainPresenter = MainPresenter(this)
        rvMovies = findViewById(R.id.movies_list)
        rvMovies.setHasFixedSize(true)
        rvMovies.layoutManager = LinearLayoutManager(this)
    }

    private fun getMovieList() {
        mainPresenter.getMovies()
    }
}