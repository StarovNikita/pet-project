package com.example.pet_project.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.pet_project.R
import com.example.pet_project.adapters.HeroAdapter
import com.example.pet_project.databinding.FragmentMainListBinding
import com.example.pet_project.di.component.DaggerActivityComponent
import com.example.pet_project.di.module.ActivityModule
import com.example.pet_project.model.hero.HeroResponse
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainViewInterface {

    private lateinit var binding: FragmentMainListBinding
    private lateinit var adapter: HeroAdapter
    @Inject
    @InjectPresenter
    lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        injectDependency()
        initAllFields()
    }

    override fun showHeroList(heroResponse: HeroResponse) {
        adapter.update(heroResponse.results)
        adapter.notifyDataSetChanged()
    }

    private fun initAllFields() {
        mainPresenter.getHeroList()
        binding = FragmentMainListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mainPresenter.getHeroListBasedOnName(binding.searchView)
        binding.heroList.setHasFixedSize(true)
        binding.heroList.layoutManager = LinearLayoutManager(applicationContext)
        adapter = HeroAdapter(emptyList(), applicationContext, mainPresenter,this)
        binding.heroList.adapter = adapter
    }

    private fun injectDependency() {
        val activityComponent = DaggerActivityComponent.builder().activityModule(ActivityModule(this)).build()
        activityComponent.inject(this)
    }
}