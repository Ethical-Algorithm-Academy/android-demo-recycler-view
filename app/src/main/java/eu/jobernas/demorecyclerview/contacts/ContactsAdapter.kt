package eu.jobernas.demorecyclerview.contacts

import android.util.Log
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ContactsAdapter(
    private var items: MutableList<ItemViewModel>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private val TAG = ContactsAdapter::class.java.simpleName
    }

    init {
        setHasStableIds(true)
    }

    fun load(items: List<ContactItemViewModel>) {
        this.items.apply {
            clear()
            addAll(items)
        }
        notifyDataSetChanged()
    }

    fun remove(position: Int) {
        items.removeAt(position)
        notifyItemRemoved(position)
    }

    fun remove(item: ContactItemViewModel) {
        val position = items.indexOf(item).takeIf { it != -1 } ?: return
        Log.d(TAG, "position:$position")
        items.removeAt(position)
        notifyItemRemoved(position)
    }

    override fun getItemCount(): Int = items.size

    override fun getItemId(position: Int): Long =
        items[position].identifier.hashCode().toLong()

    override fun getItemViewType(position: Int): Int =
        items[position].viewType

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            ContactItemViewHolder.LAYOUT_ID -> ContactItemViewHolder.create(parent)
            ContactExtraItemViewHolder.LAYOUT_ID -> ContactExtraItemViewHolder.create(parent)
            else -> throw IllegalArgumentException("ViewType not coded")
        }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val itemViewModel = items[position]
        when {
            holder is ContactItemViewHolder && itemViewModel is ContactItemViewModel -> holder.bind(itemViewModel) { itemPosition ->
                Log.d(TAG, "Position: $position")
                remove(itemPosition)
            }
            holder is ContactExtraItemViewHolder && itemViewModel is ContactExtraItemViewModel -> holder.bind(itemViewModel)
            else -> Log.w(TAG, "View Holder not Coded")
        }
    }
}