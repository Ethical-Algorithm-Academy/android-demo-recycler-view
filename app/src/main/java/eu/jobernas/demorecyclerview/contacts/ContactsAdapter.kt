package eu.jobernas.demorecyclerview.contacts

import android.util.Log
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ContactsAdapter(
    private var items: MutableList<ContactItemViewModel>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private val TAG = ContactsAdapter::class.java.simpleName
    }

    init {
        setHasStableIds(true)
    }

    fun load(items: List<ContactItemViewModel>) {
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun remove(position: Int) {
        items.removeAt(position)
        notifyItemRemoved(position)
    }

    fun remove(item: ContactItemViewModel) {
        val position = items.indexOf(item)
        items.removeAt(position)
        notifyItemRemoved(position)
    }

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int =
        items[position].viewType

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            ContactItemViewHolder.LAYOUT_ID -> ContactItemViewHolder.create(parent)
            else -> throw IllegalArgumentException("ViewType not coded")
        }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val itemViewModel = items[position]
        when {
            holder is ContactItemViewHolder -> holder.bind(itemViewModel)
            else -> Log.w(TAG, "View Holder not Coded")
        }
    }
}