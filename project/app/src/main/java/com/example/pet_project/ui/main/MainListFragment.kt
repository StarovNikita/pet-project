package com.example.pet_project.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pet_project.R
import com.example.pet_project.adapters.HeroAdapter
import com.example.pet_project.databinding.FragmentMainListBinding
import com.example.pet_project.model.hero.HeroResponse
import com.example.pet_project.network.Service
import javax.inject.Inject


class MainListFragment : Fragment(R.layout.fragment_main_list), MainViewInterface {

    private lateinit var binding: FragmentMainListBinding
    private lateinit var adapter: HeroAdapter
    private lateinit var mainPresenter: MainPresenter
    @Inject
    lateinit var service: Service
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentMainListBinding.inflate(inflater, container, false).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAllFields()
    }

    private fun initAllFields() {
        mainPresenter = MainPresenter(service, this)
        mainPresenter.getHeroList()
        binding = FragmentMainListBinding.inflate(layoutInflater)
        mainPresenter.getHeroListBasedOnName(binding.searchView)
        binding.heroList.setHasFixedSize(true)
        binding.heroList.layoutManager = LinearLayoutManager(context)
    }

    override fun showHeroList(heroResponse: HeroResponse) {
        adapter = HeroAdapter(heroResponse.results, context)
        binding.heroList.adapter = adapter
    }
}