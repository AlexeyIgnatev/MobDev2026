package com.example.myapplication.ui.theme

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!
    private val TAG = "SettingsFragment"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return try {
            _binding = FragmentSettingsBinding.inflate(inflater, container, false)
            Log.d(TAG, "onCreateView - success")
            setupThemeSwitch()
            binding.root
        } catch (e: Exception) {
            Log.e(TAG, "Error inflating layout", e)
            // Fallback layout
            createFallbackView(inflater, container)
        }
    }

    private fun setupThemeSwitch() {
        try {
            val switch = binding.switchTheme
            val currentNightMode = resources.configuration.uiMode and android.content.res.Configuration.UI_MODE_NIGHT_MASK
            switch.isChecked = currentNightMode == android.content.res.Configuration.UI_MODE_NIGHT_YES

            switch.setOnCheckedChangeListener { _, isChecked ->
                val mode = if (isChecked) {
                    AppCompatDelegate.MODE_NIGHT_YES
                } else {
                    AppCompatDelegate.MODE_NIGHT_NO
                }
                AppCompatDelegate.setDefaultNightMode(mode)
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error setting up theme switch", e)
        }
    }

    private fun createFallbackView(inflater: LayoutInflater, container: ViewGroup?): View {
        val view = inflater.inflate(android.R.layout.simple_list_item_1, container, false)
        view.findViewById<android.widget.TextView>(android.R.id.text1).text = "Settings (Fallback)"
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}