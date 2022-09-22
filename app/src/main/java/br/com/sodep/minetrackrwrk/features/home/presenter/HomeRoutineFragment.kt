package br.com.sodep.minetrackrwrk.features.home.presenter

import  android.os.Bundle
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.sodep.minetrackrwrk.R

class HomeRoutineFragment : Fragment(R.layout.fragment_routine) {
    private val adapter = RoutineAdapter()
    private lateinit var toggle: ActionBarDrawerToggle
    private val homeViewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        setupAdapter()
    }

    private fun setupView() {
        toggle = ActionBarDrawerToggle(
            requireActivity(),
            requireActivity().findViewById<DrawerLayout>(R.id.drawerLayout),
            requireActivity().findViewById(R.id.toolbar_home),
            R.string.app_name,
            R.string.app_name
        )
        toggle.syncState()
    }

    private fun setupAdapter() {
        with(requireActivity().findViewById<RecyclerView>(R.id.recycler_list_occupation)) {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = this@HomeRoutineFragment.adapter
        }
    }
}