package com.jo.ArduinoInfoSuite.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.codingstuff.loginandsignup.R

class fragmentinicio : Fragment(R.layout.fragment_fragmentinicio) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_fragmentinicio, container, false)
        val btn1 : Button = view.findViewById(R.id.button2)
        btn1.setOnClickListener{

            findNavController().navigate(R.id.action_fragmentinicio_to_fragmentRecyclers)
        }
        // Inflate the layout for this fragment
        return view
    }
}