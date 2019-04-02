package com.ezapps.notekeeper.base.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T, VH : BaseViewHolder<T>>: RecyclerView.Adapter<VH>() {

    var items: ArrayList<T> = ArrayList()
        set(value) {
            items.clear()
            items.addAll(value)
            notifyDataSetChanged()
        }

    abstract override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun getItem(index: Int) : T? {
        return if (index < items.size) items[index] else null
    }

    fun addItem(item: T) {
        items.add(item)
        notifyItemInserted(items.size - 1)
    }

    fun addItem(index: Int, item: T) {
        items.add(index, item)
        notifyItemInserted(index)
    }

    fun removeItem(item: T) : Boolean {
        val index = items.indexOf(item)
        if (index == -1) {
            return false
        }
        items.remove(item)
        notifyItemRemoved(index)
        return true

    }

    fun removeItem(index: Int) : T {
        val removedItem = items.removeAt(index)
        notifyItemRemoved(index)
        return removedItem
    }
}