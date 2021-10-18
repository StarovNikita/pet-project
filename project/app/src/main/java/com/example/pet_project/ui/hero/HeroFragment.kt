package com.example.pet_project.ui.hero

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.arellomobile.mvp.MvpAppCompatFragment
import com.example.pet_project.databinding.FragmentHeroBinding
import com.example.pet_project.model.hero.Result
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class HeroFragment : MvpAppCompatFragment() {

    private lateinit var binding: FragmentHeroBinding
    private lateinit var selectedHero: Result
    private lateinit var auth: FirebaseAuth
    private val args: HeroFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHeroBinding.inflate(inflater, container, false)
        setViewContent()
        auth = Firebase.auth
        val database = Firebase.database
        val myRef =
            database.getReference("favorite").child(auth.currentUser?.displayName.toString())
        binding.addButton.setOnClickListener {
            myRef.child(myRef.push().key ?: "Error").setValue(selectedHero)
        }
        return binding.root
    }

    private fun setViewContent() {
        selectedHero = args.selectedHero
        with(selectedHero) {
            context?.let { Glide.with(it).load(image?.url).into(binding.imageView) }
            "Name: $name".also { binding.selectedHeroName.text = it }
            "Combat: ${powerstats?.combat}".also { binding.selectedHeroCombat.text = it }
            "Durability: ${powerstats?.durability}".also {
                binding.selectedHeroDurability.text = it
            }
            "Intelligence: ${powerstats?.intelligence}".also {
                binding.selectedHeroIntelligence.text = it
            }
            "Power: ${powerstats?.power}".also { binding.selectedHeroPower.text = it }
            "Speed: ${powerstats?.speed}".also { binding.selectedHeroSpeed.text = it }
            "Strength: ${powerstats?.strength}".also { binding.selectedHeroStrength.text = it }
            "Gender: ${appearance?.gender}".also { binding.selectedHeroGender.text = it }
            "Race: ${appearance?.race}".also { binding.selectedHeroRace.text = it }
        }
    }
}