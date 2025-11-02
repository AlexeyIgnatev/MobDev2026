package com.example.myapplication.ui.theme

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentFeedBinding


class FeedFragment : Fragment() {


    private var _binding: FragmentFeedBinding? = null
    private val binding get() = _binding!!
    private val TAG = "FeedFragment"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d(TAG, "onCreateView")
        _binding = FragmentFeedBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }


    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }


    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }


    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }


    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "onDestroyView")
        _binding = null
    }


    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }
}