package eu.jobernas.demorecyclerview.contacts

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import eu.jobernas.androidextensions.layoutInflater
import eu.jobernas.demorecyclerview.R
import eu.jobernas.demorecyclerview.databinding.RecyclerViewContactItemBinding

class ContactItemViewHolder(
    private val binding: RecyclerViewContactItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    companion object {

        private val TAG = ContactItemViewHolder::class.java.simpleName
        val LAYOUT_ID = R.layout.recycler_view_contact_item

        fun create(viewGroup: ViewGroup): ContactItemViewHolder =
            ContactItemViewHolder(
                RecyclerViewContactItemBinding.inflate(
                    viewGroup.context.layoutInflater, viewGroup, false))
    }

    fun bind(contactItemViewModel: ContactItemViewModel) {
        binding.apply {
            val context = root.context
            contactItemViewModel.apply {
                itemTitleTextView.text = name
                itemSubTitleTextView.text = contactNumber.toString()
            }
        }
    }
}