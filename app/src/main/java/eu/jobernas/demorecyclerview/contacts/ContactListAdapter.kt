package eu.jobernas.demorecyclerview.contacts

import android.util.Log
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import eu.jobernas.demorecyclerview.core.SimpleDiffCallback

class ContactListAdapter() :
    ListAdapter<ItemViewModel, RecyclerView.ViewHolder>(SimpleDiffCallback<ItemViewModel>()) {

    companion object {
        private val TAG = ContactListAdapter::class.simpleName
    }
    override fun getItemViewType(position: Int): Int = getItem(position).viewType
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            ContactItemViewHolder.LAYOUT_ID -> ContactItemViewHolder.create(parent)
            ContactExtraItemViewHolder.LAYOUT_ID -> ContactExtraItemViewHolder.create(parent)
            else -> throw IllegalArgumentException("ViewType not coded")
        }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position) ?: return
        when {
            holder is ContactItemViewHolder && item is ContactItemViewModel -> holder.bind(item) { itemPosition ->
                Log.d(TAG, "Position: $position")
//                remove(itemPosition)
            }
            holder is ContactExtraItemViewHolder && item is ContactExtraItemViewModel -> holder.bind(
                item)
            else -> Log.w(TAG, "View Holder not Coded")
        }
    }

}