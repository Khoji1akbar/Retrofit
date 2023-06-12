package com.example.retrofit

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.retrofit.Client.ApiCilent
import com.example.retrofit.MyAdabter.MyAdapter
import com.example.retrofit.databinding.ActivityMainBinding
import com.example.retrofit.models.TodoGetResponseItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
  val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        ApiCilent.getRetrofitService().getAllTodo()
            .enqueue(object : Callback<List<TodoGetResponseItem>> {
                override fun onResponse(
                    call: Call<List<TodoGetResponseItem>>,
                    response: Response<List<TodoGetResponseItem>>
                ) {
                    if (response.isSuccessful && response.body()!=null){
                        Log.d(ContentValues.TAG, "onResponse: ${response.body()}")
                        Toast.makeText(this@MainActivity, "${response.body()}", Toast.LENGTH_SHORT).show()
                        binding.apply {
                            val dataList = response.body()
                            val adapter = MyAdapter(dataList!!)
                            rv.adapter = adapter
                        }

                    }
                }

                override fun onFailure(call: Call<List<TodoGetResponseItem>>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "Internet ulanmagan", Toast.LENGTH_SHORT).show()
                }

            })
    }

}