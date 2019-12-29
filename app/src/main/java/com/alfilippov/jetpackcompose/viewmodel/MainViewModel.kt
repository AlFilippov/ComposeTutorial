package com.alfilippov.jetpackcompose.viewmodel

import androidx.lifecycle.ViewModel
import com.alfilippov.jetpackcompose.R
import com.alfilippov.jetpackcompose.data.MainDataModel

class MainViewModel : ViewModel() {
private val data = ArrayList<MainDataModel>()
    fun getData():ArrayList<MainDataModel>{
        return data
    }
    fun fetchData(){
        data.add(MainDataModel(sports = "Footbal",image = R.drawable.ic_background))
        data.add(MainDataModel(sports = "Hockey",image = R.drawable.ic_background))
        data.add(MainDataModel(sports = "Basketball",image = R.drawable.ic_background))
        data.add(MainDataModel(sports = "Rugby",image = R.drawable.ic_background))
        data.add(MainDataModel(sports = "Tennis",image = R.drawable.ic_background))
        data.add(MainDataModel(sports = "Poker",image = R.drawable.ic_background))
    }
}