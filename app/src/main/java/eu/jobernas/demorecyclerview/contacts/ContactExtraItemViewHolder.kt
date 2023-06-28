package eu.jobernas.demorecyclerview.contacts

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import eu.jobernas.androidextensions.layoutInflater
import eu.jobernas.demorecyclerview.R
import eu.jobernas.demorecyclerview.databinding.RecyclerViewExtraContactItemBinding

class ContactExtraItemViewHolder(
    private val binding: RecyclerViewExtraContactItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    companion object {

        private val TAG = ContactExtraItemViewHolder::class.java.simpleName
        val LAYOUT_ID = R.layout.recycler_view_extra_contact_item

        fun create(viewGroup: ViewGroup): ContactExtraItemViewHolder =
            ContactExtraItemViewHolder(
                RecyclerViewExtraContactItemBinding.inflate(
                    viewGroup.context.layoutInflater, viewGroup, false))
    }

    fun bind(contactExtraItemViewModel: ContactExtraItemViewModel) {
        binding.apply {
            val context = root.context
            itemExtraNumberTextView.text = contactExtraItemViewModel.contactNumber.toString()
        }
    }
}