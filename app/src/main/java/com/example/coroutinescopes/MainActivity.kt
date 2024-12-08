package com.example.coroutinescopes

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.coroutinescopes.di.DaggerFetchingComponent
import com.example.coroutinescopes.di.FetchingComponent
import com.example.coroutinescopes.di.FetchingModule
import com.example.coroutinescopes.model.repository.FetchRepository
import com.example.coroutinescopes.viewModel.FetchingDataViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private lateinit var fetchingComponent: FetchingComponent
    @Inject
    lateinit var viewModel: FetchingDataViewModel
    lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = this.findViewById(R.id.textviewChange)
        textView.setText("Initial Text")

        fetchingComponent = DaggerFetchingComponent.builder()
            .fetchingModule(FetchingModule())
            .build()

        fetchingComponent.inject(this)
        viewModel.fetchedData.observe(this, Observer{
            data ->
            textView.setText(data)
        })

        viewModel.fetchData()
    }
}