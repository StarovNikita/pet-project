package com.example.pet_project.ui.main

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.pet_project.BaseApp
import com.example.pet_project.R
import com.example.pet_project.adapters.HeroAdapter
import com.example.pet_project.databinding.FragmentMainListBinding
import com.example.pet_project.model.hero.HeroResponse

class MainActivity : MvpAppCompatActivity(), MainViewInterface {

    private lateinit var binding: FragmentMainListBinding
    private lateinit var adapter: HeroAdapter
    @InjectPresenter
    lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initAllFields()
    }

    override fun showHeroList(heroResponse: HeroResponse) {
        Log.e("tag", "show $heroResponse")
        adapter.update(heroResponse.results)
        adapter.notifyDataSetChanged()
    }

    override fun openFragment() {
        Toast.makeText(this, "ItemClicked", Toast.LENGTH_LONG).show()
    }

    private fun initAllFields() {
        mainPresenter.getHeroList()
        binding = FragmentMainListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mainPresenter.getHeroListBasedOnName(binding.searchView)
        binding.heroList.setHasFixedSize(true)
        binding.heroList.layoutManager = LinearLayoutManager(applicationContext)
        adapter = HeroAdapter(mainPresenter)
        binding.heroList.adapter = adapter
    }
}