package com.example.databindingexample

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.databindingexample.databinding.FragmentFirstBinding
import com.example.databindingexample.pojo.User

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        var user = User("pavel" , "john" , true)
        binding.user = user

        return binding.root

    }

    fun showText(view:View){
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