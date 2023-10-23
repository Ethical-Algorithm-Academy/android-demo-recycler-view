package eu.jobernas.demorecyclerview.contacts

import android.net.Uri
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.request.RequestOptions
import eu.jobernas.androidextensions.layoutInflater
import eu.jobernas.demorecyclerview.R
import eu.jobernas.demorecyclerview.core.setImageAsync
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

    fun bind(contactItemViewModel: ContactItemViewModel,
             deleteAction: (position: Int) -> Unit) {
        binding.apply {
            val context = root.context
            contactItemViewModel.apply {
                itemImageView.setImageAsync(
                    Uri.parse("https://img.freepik.com/free-photo/portrait-young-beautiful-woman-with-smoky-eyes-makeup-pretty-young-adult-girl-posing-studio-closeup-attractive-female-face_186202-4439.jpg?size=626&ext=jpg&ga=GA1.1.867424154.1697932800&semt=ais"),
                    R.drawable.ic_placeholder_person_96,
                    RequestOptions
                    .circleCropTransform())
                itemTitleTextView.text = name
                itemSubTitleTextView.text = contactNumber.toString()
            }
            itemRemoveButton.setOnClickListener {
                deleteAction.invoke(adapterPosition)
            }
        }
    }
}