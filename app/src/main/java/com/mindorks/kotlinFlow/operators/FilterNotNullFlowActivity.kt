package com.mindorks.kotlinFlow.operators

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mindorks.kotlinFlow.R
import kotlinx.android.synthetic.main.activity_example.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class FilterNotNullFlowActivity : AppCompatActivity() {

    lateinit var flowOne: Flow<Any?>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example)
        setupFlow()
        setupClick()
    }

    private fun setupClick() {
        btn.setOnClickListener {
            doSomeWork()
        }
    }

    private fun doSomeWork() {
        CoroutineScope(Dispatchers.Main).launch {
            val output = flowOne.filterNotNull().toList()
            textView.text = output.toString()
        }
    }

    private fun setupFlow() {
        flowOne = flowOf("Himanshu", "Amit", "Janishar", null, 5, 10).flowOn(Dispatchers.Default)

    }
}