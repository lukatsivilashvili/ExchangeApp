package com.example.exchange.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exchange.databinding.RecyclerItemBinding
import com.example.exchange.models.Currency

class RecyclerAdapter :
    RecyclerView.Adapter<RecyclerAdapter.ItemViewHolder>() {
    val currencies = mutableListOf<Currency>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView =
            RecyclerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val holder = ItemViewHolder(itemView)
        return holder
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount() = currencies.size

    inner class ItemViewHolder(private val binding: RecyclerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private lateinit var model: Currency

        fun bind() {
            model = currencies[adapterPosition]

            binding.txtname.text = model.name.toString()
            binding.txtCode.text = model.code.toString()
        }
    }

    fun setData(currency:MutableList<Currency>){
        this.currencies.addAll(currency)
        notifyDataSetChanged()
    }

}
