package com.example.koinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.koinapp.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModel: MainViewModel by viewModel()
    private val adapter: FactsAdapter = FactsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel.getDogFacts()

        binding.rv.layoutManager = LinearLayoutManager(this)
        binding.rv.adapter = adapter

        observe()
    }

    private fun observe() {
        viewModel.loadingLiveData.observe(this) {
            binding.progressBar.isVisible = it
        }

        viewModel.exceptionLiveData.observe(this) {e ->
            e?.let {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }
        }

        viewModel.factsData.observe(this) {
            adapter.submitList(it.facts)
        }
    }

}