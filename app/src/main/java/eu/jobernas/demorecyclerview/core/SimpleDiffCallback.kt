package eu.jobernas.demorecyclerview.core

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil

class SimpleDiffCallback<T: Any>: DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean =
        oldItem::class == newItem::class

    // NOTE: USE Only with Data Class otherwise you need to override equals inside object
    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean =
        oldItem == newItem

}