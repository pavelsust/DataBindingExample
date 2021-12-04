package com.example.databindingexample.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.util.*

object FakeRepository{

    private val fruitNames : List<String> = listOf("Apple"  , "Banana" , "Orange" , "Pear")

    private val _currentRandomFruitName = MutableLiveData<String>()

    val currentRandomFruitName :LiveData<String> get() = _currentRandomFruitName

    init {
        _currentRandomFruitName.value = fruitNames.first()
    }

    fun getRandomFruitName(): String{
        val random = Random()
        return fruitNames[random.nextInt(2)]
    }

    fun changeCurrentRandomFruitName(){
        _currentRandomFruitName.value = getRandomFruitName()
        Log.d("SHOW" , getRandomFruitName())
    }

}