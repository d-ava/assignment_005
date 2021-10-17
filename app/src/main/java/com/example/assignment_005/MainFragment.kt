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


class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private val adapter = BigItemsAdapter()
    //private val layoutManager=GridLayoutManager(context,1)
    private val layoutManager=LinearLayoutManager(context)

    private val list= mutableListOf(1,2,3,4,5,6,7,8,9,1,2,3,4)

    private val viewModel: MainViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)



        adapter.setData(list)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = layoutManager


        viewModel.parsedJSON()
        val data = viewModel.parsedJSON.value
        Log.d("---", "$data")
        binding.tv01.text = data.toString()











        viewModel.parsedJSON.observe(viewLifecycleOwner, {})



        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


/*


*/


    }


    override fun onDestroy() {
        super.onDestroy()


        _binding = null
    }

}