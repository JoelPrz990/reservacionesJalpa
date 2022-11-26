package com.jo.ArduinoInfoSuite.Models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jo.ArduinoInfoSuite.Repo.database

class BoardsViewModel : ViewModel() {

    private val dataB : database
    private val _allBoards = MutableLiveData<List<Boards>>()
    val allUsers : LiveData<List<Boards>> = _allBoards


    init {

        dataB = database().getInstance()
        dataB.loadBoards(_allBoards)

    }

}