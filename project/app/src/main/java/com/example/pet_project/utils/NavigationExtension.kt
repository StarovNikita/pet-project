package com.example.pet_project.utils

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.example.pet_project.R

fun Fragment.navigate(id: Int) {

    val navHostFragment =
        requireActivity().supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
    navHostFragment.navController.navigate(id)
}