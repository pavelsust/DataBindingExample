package com.example.databindingexample

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.Bindable
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.databindingexample.databinding.FragmentFirstBinding
import com.example.databindingexample.pojo.User
import com.example.databindingexample.viewmodel.MainViewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    var name:String?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)


        val mainViewModel = ViewModelProviders.of(requireActivity()).get(MainViewModel::class.java)
        //binding.viewmodel  = mainViewModel


        mainViewModel.currentRandomFruitName.observe(requireActivity() , {
            binding.viewmodel = mainViewModel
        })

        return binding.root
    }


    fun showText(){
        Toast.makeText(requireActivity()  ,"${binding.editText}" , Toast.LENGTH_SHORT).show()
        Log.d("CLICK" , "click working")
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        binding.buttonFirst.setOnClickListener {
//            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
//        }
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}