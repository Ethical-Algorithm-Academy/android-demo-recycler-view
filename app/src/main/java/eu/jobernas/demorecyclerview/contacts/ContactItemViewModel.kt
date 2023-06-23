package eu.jobernas.demorecyclerview.contacts

class ContactItemViewModel(
    val name: String,
    val contactNumber: Int): ItemViewModel {

    override val identifier: String = name
    override val layoutId: Int = ContactItemViewHolder.LAYOUT_ID
}