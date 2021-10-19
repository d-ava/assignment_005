package com.example.assignment_005

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignment_005.databinding.FragmentMainBinding


//class MainFragment : Fragment() {

class MainFragment : BaseFragment<FragmentMainBinding, MainViewModel>(FragmentMainBinding::inflate) {



    private val adapter = BigItemsAdapter()


    private val layoutManager = LinearLayoutManager(context)



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = layoutManager


        viewModel.parsedJSON()


        val data = viewModel.parsedJSON.value
        Log.d("---", "$data")
        // binding.tv01.text = data.toString()


        viewModel.parsedJSON.observe(viewLifecycleOwner) {
            adapter.setData(it)
        }

    }

    override fun getViewModel(): Class<MainViewModel> = MainViewModel::class.java


}