package com.example.notes_app_viewmodel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation

class welcomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_welcome, container, false)
        view.findViewById<TextView>(R.id.tvNext).setOnClickListener {
            //Navigation.findNavController(view).navigate(R.id.action_welcomeFragment_to_mainActivity)
            view.visibility = View.GONE
        }
        return view
    }
}