package com.alfilippov.jetpackcompose.viewmodel

import androidx.compose.Model
import androidx.lifecycle.ViewModel
import com.alfilippov.jetpackcompose.R
import com.alfilippov.jetpackcompose.data.MainDataModel
@Model
class MainViewModel : ViewModel() {
private val data = ArrayList<MainDataModel>()
    fun getData():ArrayList<MainDataModel>{
        return data
    }
    fun fetchData(){
        data.add(MainDataModel(sports = "Football",image = R.drawable.football,desription = "England"))
        data.add(MainDataModel(sports = "Hockey",image = R.drawable.hockey,desription = "Canada"))
        data.add(MainDataModel(sports = "Basketball",image = R.drawable.basketball,desription = "USA"))
        data.add(MainDataModel(sports = "Rugby",image = R.drawable.hockey,desription = "New Zealand"))
        data.add(MainDataModel(sports = "Tennis",image = R.drawable.tennis,desription = "England"))
        data.add(MainDataModel(sports = "Poker",image = R.drawable.poker,desription = "USA"))
    }
    fun fetchMoreData(){
        data.add(MainDataModel(sports = "Rugby",image = R.drawable.hockey,desription = "New Zealand"))
        data.add(MainDataModel(sports = "Tennis",image = R.drawable.tennis,desription = "England"))
        data.add(MainDataModel(sports = "Poker",image = R.drawable.poker,desription = "USA"))
    }
}