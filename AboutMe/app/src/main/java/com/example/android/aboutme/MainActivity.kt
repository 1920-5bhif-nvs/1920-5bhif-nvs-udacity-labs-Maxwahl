package com.example.android.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.android.aboutme.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Maximilian Wahl")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.buttonDone.setOnClickListener { addNickname(it) }
        binding.myName = myName
    }

    private fun addNickname(it: View?) {

        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(it?.windowToken, 0)

        binding.editNickname.visibility=View.GONE
        binding.buttonDone.visibility = View.GONE

        binding.textNickname.visibility = View.VISIBLE
        binding.apply {
            myName?.nickname = edit_nickname.text.toString()
// Invalidate all binding expressions and request a new rebind to refresh UI
            invalidateAll()
        }


    }
}
