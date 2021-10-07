package com.example.pet_project.ui.main

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pet_project.BaseApp
import com.example.pet_project.R
import com.example.pet_project.adapters.HeroAdapter
import com.example.pet_project.databinding.FragmentMainListBinding
import com.example.pet_project.model.hero.HeroResponse
import com.example.pet_project.network.Service
import javax.inject.Inject


class MainActivity : BaseApp(), MainViewInterface {

    private lateinit var binding: FragmentMainListBinding
    private lateinit var adapter: HeroAdapter
    private lateinit var mainPresenter: MainPresenter
    @Inject
    lateinit var service: Service

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        appComponent.inject(this)
        initAllFields()
    }

    private fun initAllFields() {
        mainPresenter = MainPresenter(service, this)
        mainPresenter.getHeroList()
        binding = FragmentMainListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mainPresenter.getHeroListBasedOnName(binding.searchView)
        binding.heroList.setHasFixedSize(true)
        binding.heroList.layoutManager = LinearLayoutManager(applicationContext)
    }

    override fun showHeroList(heroResponse: HeroResponse) {
        adapter = HeroAdapter(heroResponse.results, applicationContext)
        binding.heroList.adapter = adapter
    }
}