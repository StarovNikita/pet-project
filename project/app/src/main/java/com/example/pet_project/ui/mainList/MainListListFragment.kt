package com.example.pet_project.ui.mainList

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

class MainListListFragment : MvpAppCompatFragment(), MainListViewInterface {

    private lateinit var binding: FragmentMainListBinding
    private lateinit var adapter: HeroAdapter

    @InjectPresenter
    lateinit var mainListPresenter: MainListPresenter

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
        val action = MainListListFragmentDirections.actionMainListFragmentToHeroFragment(selectedHero)
        navigate(action)
    }

    private fun initAllFields() {
        mainListPresenter.getHeroList()
        mainListPresenter.getHeroListBasedOnName(binding.searchView)
        binding.heroList.setHasFixedSize(true)
        binding.heroList.layoutManager = LinearLayoutManager(context)
        adapter = HeroAdapter(mainListPresenter)
        binding.heroList.adapter = adapter
    }
}