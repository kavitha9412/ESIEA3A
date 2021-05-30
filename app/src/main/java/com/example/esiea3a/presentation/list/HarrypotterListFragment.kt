package com.example.esiea3a.presentation.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.esiea3a.R
import kotlinx.android.synthetic.main.fragment_harrypotter_list.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class HarrypotterListFragment : Fragment() {
    private lateinit var recyclerView:RecyclerView

    private val adapter = HarrypotterAdapter(listOf())
    private val layoutManager = LinearLayoutManager(context)

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_harrypotter_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.harrypotter_recyclerview)
        recyclerView.apply {
            layoutManager = this@HarrypotterListFragment.layoutManager
            adapter = this@HarrypotterListFragment.adapter
        }

        val harryList = arrayListOf<Harrypotter>().apply {
            add(Harrypotter("Harry Potter"))
            add(Harrypotter("Ron Weasley"))
            add(Harrypotter("Harmione Granger"))
            add(Harrypotter("Draco Malfoy"))

        }
         adapter.updateList(harryList)

    }
}