package com.example.myapplication.ui.theme

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupThemeSwitch()
        setupNotificationsSwitch()
    }

    private fun setupThemeSwitch() {
        // Устанавливаем начальное состояние переключателя
        val currentNightMode = resources.configuration.uiMode and android.content.res.Configuration.UI_MODE_NIGHT_MASK
        binding.switchTheme?.isChecked = currentNightMode == android.content.res.Configuration.UI_MODE_NIGHT_YES

        // Обработка переключения темы
        binding.switchTheme?.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                // Включить темную тему
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                // Включить светлую тему
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
    }

    private fun setupNotificationsSwitch() {
        // Обработка уведомлений (просто для вида)
        binding.switchNotifications?.setOnCheckedChangeListener { _, isChecked ->
            // Здесь можно добавить логику для уведомлений
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}