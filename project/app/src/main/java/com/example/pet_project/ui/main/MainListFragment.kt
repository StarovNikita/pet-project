package com.example.pet_project.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.pet_project.adapters.HeroAdapter
import com.example.pet_project.databinding.FragmentMainListBinding
import com.example.pet_project.model.hero.HeroResponse
import com.example.pet_project.model.hero.Result
import com.example.pet_project.utils.navigate

class MainListFragment : MvpAppCompatFragment(), MainViewInterface {

    private lateinit var binding: FragmentMainListBinding
    private lateinit var adapter: HeroAdapter

    @InjectPresenter
    lateinit var mainPresenter: MainPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainListBinding.inflate(inflater, container, false)
        initAllFields()
        return binding.root
    }

    override fun showHeroList(heroResponse: HeroResponse) {
        Log.e("tag", "show $heroResponse")
        adapter.update(heroResponse.results)
        adapter.notifyDataSetChanged()
    }

    override fun openFragment(selectedHero: Result) {
        val action = MainListFragmentDirections.actionMainListFragmentToHeroFragment(selectedHero)
        navigate(action)
    }

    private fun initAllFields() {
        mainPresenter.getHeroList()
        mainPresenter.getHeroListBasedOnName(binding.searchView)
        binding.heroList.setHasFixedSize(true)
        binding.heroList.layoutManager = LinearLayoutManager(context)
        adapter = HeroAdapter(mainPresenter)
        binding.heroList.adapter = adapter
    }
}