package com.example.databindingexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.databindingexample.databinding.TestFragmentBinding

class TestFragment: Fragment() {


    private var testFragmentBinding: TestFragmentBinding?=null
    private val binding get() = testFragmentBinding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        testFragmentBinding = TestFragmentBinding.inflate(inflater, container , false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.simpleText.text = "Nothing"
    }

}