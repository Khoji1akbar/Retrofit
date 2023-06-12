package com.example.retrofit
import com.example.retrofit.models.TodoGetResponseItem
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {

    @GET("plan")
    fun getAllTodo():Call<List<TodoGetResponseItem>>
    
}