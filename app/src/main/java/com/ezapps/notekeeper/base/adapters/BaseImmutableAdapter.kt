package com.ezapps.notekeeper.base.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseImmutableAdapter<T, VH : BaseViewHolder<T>>: RecyclerView.Adapter<VH>() {

    var items: List<T> = emptyList()
        set(values) {
            field = emptyList<T>() + values
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
}