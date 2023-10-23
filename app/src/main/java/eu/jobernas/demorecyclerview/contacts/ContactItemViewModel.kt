package eu.jobernas.demorecyclerview.contacts

import android.graphics.Bitmap

data class ContactItemViewModel(
    val name: String,
    val contactNumber: Int): ItemViewModel {

    override val identifier: String = contactNumber.toString()
    override val layoutId: Int = ContactItemViewHolder.LAYOUT_ID

}