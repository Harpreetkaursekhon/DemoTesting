package com.myapp.reecetest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.myapp.reecetest.adapter.BreedAdapter
import com.myapp.reecetest.databinding.ActivityMainBinding
import com.myapp.reecetest.model.BreedResponseItem
import com.myapp.reecetest.repository.BreedRepo
import com.myapp.reecetest.viewmodel.BreedViewModel
import com.myapp.reecetest.viewmodel.BreedViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: BreedViewModel
    private lateinit var breedRepo: BreedRepo
    private lateinit var breedAdapter: BreedAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var breedViewModelFactory: BreedViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        initRecyclerView()
        breedRepo = BreedRepo()
        breedViewModelFactory= BreedViewModelFactory(breedRepo)
        viewModel= ViewModelProvider(this,breedViewModelFactory)[BreedViewModel::class.java]
        viewModel.getBreedData()

        viewModel.response.observe(this) {
            breedAdapter.setPostData(it as ArrayList<BreedResponseItem>)
        }
    }

    private fun initRecyclerView() {
        breedAdapter= BreedAdapter(this, ArrayList())
        binding.recyclerview.apply {
            setHasFixedSize(true)
            layoutManager= LinearLayoutManager(this@MainActivity)
            adapter=breedAdapter
        }
        breedAdapter.onItemClick = {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("breed", it)
            startActivity(intent)
        }
    }

}