package eu.jobernas.demorecyclerview.contacts

data class ContactExtraItemViewModel(
    val contactNumber: Int): ItemViewModel {

    override val identifier: String = contactNumber.toString()
    override val layoutId: Int = ContactExtraItemViewHolder.LAYOUT_ID
}