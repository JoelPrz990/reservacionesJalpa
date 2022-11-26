package com.jo.ArduinoInfoSuite.Repo

import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.*
import com.jo.ArduinoInfoSuite.Models.Boards
import java.lang.Exception

class database {
    private val databaseReference : DatabaseReference = FirebaseDatabase.getInstance().getReference("Boards")

    @Volatile private var INSTANCE : database ?= null

    fun getInstance() : database{
        return INSTANCE ?: synchronized(this){
            val instance = database()
            INSTANCE = instance
            instance
        }
    }
    fun loadBoards(boardsList: MutableLiveData<List<Boards>>){
        databaseReference.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                try {
                    val _boardsList : List<Boards> = snapshot.children.map { dataSnapshot ->
                        dataSnapshot.getValue(Boards::class.java)!!
                    }
                    boardsList.postValue(_boardsList)
                }catch (e : Exception){}
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
}