/*
package com.jo.ArduinoInfoSuite.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codingstuff.loginandsignup.R
import com.jo.ArduinoInfoSuite.Adapters.MyAdapter
import com.jo.ArduinoInfoSuite.Models.BoardsViewModel

private lateinit var viewModel : BoardsViewModel
private lateinit var boardsRecyclerView : RecyclerView
lateinit var adapter: MyAdapter

class fragmentRecyclers : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        boardsRecyclerView = view.findViewById(R.id.recyclerView)
        boardsRecyclerView.layoutManager = LinearLayoutManager(context)
        boardsRecyclerView.setHasFixedSize(true)
        adapter = MyAdapter()
        boardsRecyclerView.adapter = adapter

        viewModel = ViewModelProvider(this).get(BoardsViewModel::class.java)
        viewModel.allUsers.observe(viewLifecycleOwner, adapter::updateBoardsList)
    }
}*/
