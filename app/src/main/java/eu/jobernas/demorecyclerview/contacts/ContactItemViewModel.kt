package eu.jobernas.demorecyclerview.contacts

data class ContactItemViewModel(
    val name: String,
    val contactNumber: Int): ItemViewModel {

    override val identifier: String = name
    override val layoutId: Int = ContactItemViewHolder.LAYOUT_ID
}