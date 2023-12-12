package com.example.authorization

import LoginFragment
import WelcomeFragment
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginFragment = LoginFragment()
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, loginFragment).commit()
    }

    fun showWelcomeFragment(username: String) {
        val welcomeFragment = WelcomeFragment()
        val bundle = Bundle()
        bundle.putString("username", username)
        welcomeFragment.arguments = bundle
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, welcomeFragment)
            .addToBackStack(null)
            .commit()
    }

    fun showLoginFragment() {
        val loginFragment = LoginFragment()
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, loginFragment)
            .addToBackStack(null)
            .commit()
    }

}