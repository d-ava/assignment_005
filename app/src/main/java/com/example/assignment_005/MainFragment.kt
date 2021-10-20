package com.example.assignment_005

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.children
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
        //Log.d("---", "$data")

        val testList = mutableListOf<String>()

        for (item in binding.recyclerView.children){
            testList.add(item.toString())
        }



        binding.btnRegister.setOnClickListener {


        }

        viewModel.parsedJSON.observe(viewLifecycleOwner) {
            adapter.setData(it)
        }

    }

    override fun getViewModel(): Class<MainViewModel> = MainViewModel::class.java


}