package com.example.esiea3a.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.esiea3a.R
import com.example.esiea3a.presentation.list.api.HarryApi
import com.example.esiea3a.presentation.list.api.HarrypotterResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


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


        val retrofit = Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/kavitha9412/Esiea3A/master/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val harryApi: HarryApi = retrofit.create(HarryApi::class.java)

        harryApi.getHarrypotterList().enqueue(object: Callback<HarrypotterResponse>{
            override fun onFailure(call: Call<HarrypotterResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<HarrypotterResponse>, response: Response<HarrypotterResponse>) {
                if(response.isSuccessful && response.body() !=null){
                    val harrypotterResponse = response.body()!!
                    adapter.updateList(harrypotterResponse.result)
                }

            }
        })
         //adapter.updateList(harryList)

    }
}