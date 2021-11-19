package com.juan.examplemvvm.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import com.juan.examplemvvm.databinding.ActivityMainBinding
import com.juan.examplemvvm.ui.viewmodel.QuoteViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val quoteViewModel : QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //databinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Viewmodel
        quoteViewModel.onCreate()

        quoteViewModel.quoteModel.observe(this, { currentQuote ->
            binding.tvQuote.text = currentQuote.quote
            binding.tvAuthor.text = currentQuote.author
        })

        quoteViewModel.isLoading.observe(this, {
            binding.progress.isVisible = it
        })

        //Listenner
        binding.viewContainer.setOnClickListener {
            quoteViewModel.randomQuote()
        }
    }

}