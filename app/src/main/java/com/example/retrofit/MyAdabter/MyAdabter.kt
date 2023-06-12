package com.example.retrofit.MyAdabter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.retrofit.databinding.RvItemBinding
import com.example.retrofit.models.TodoGetResponseItem

class MyAdapter(var list: List<TodoGetResponseItem>) : RecyclerView.Adapter<MyAdapter.Vh>() {

    inner class Vh(var rvItemBinding: RvItemBinding) : RecyclerView.ViewHolder(rvItemBinding.root) {


        fun onBind(user: TodoGetResponseItem, position: Int) {
            rvItemBinding.t1.text = user.sarlavha.toString()
            rvItemBinding.tt2.text = user.batafsil
            rvItemBinding.ttt3.text = user.oxirgi_muddat.toString()
            rvItemBinding.tttt4.text = user.sana


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(RvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int = list.size

}
