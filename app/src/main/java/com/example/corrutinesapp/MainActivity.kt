package com.example.corrutinesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import com.example.corrutinesapp.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnWork.setOnClickListener{doTask()}
    }

    private fun doTask(){
        //Por defecto el lifecycle scope usa el main dispatcher, el io se usa para tareas paralizantes y el default para algoritmos pesados, mientras que en el main corre la vista
        lifecycleScope.launch()
        {
            binding.txtResult.text="Trabajando..."
            val result = withContext(Dispatchers.IO){
                MockDataProvider.instance.doHeavyTask()
            }
            binding.txtResult.text=result.toString()
        }
    }

}