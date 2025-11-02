package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.ui.theme.ChatsFragment
import com.example.myapplication.ui.theme.ContactsFragment
import com.example.myapplication.ui.theme.ProfileFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Показываем чаты при запуске
        if (savedInstanceState == null) {
            showChatsFragment()
        }

        // Обработка кликов по кнопкам навигации
        binding.bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.chatsFragment -> {
                    showChatsFragment()
                    true
                }
                R.id.contactsFragment -> {
                    showContactsFragment()
                    true
                }
                R.id.profileFragment -> {
                    showProfileFragment()
                    true
                }
                else -> false
            }
        }
    }

    private fun showChatsFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, ChatsFragment())
            .commit()
    }

    private fun showContactsFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, ContactsFragment())
            .commit()
    }

    private fun showProfileFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, ProfileFragment())
            .commit()
    }
}