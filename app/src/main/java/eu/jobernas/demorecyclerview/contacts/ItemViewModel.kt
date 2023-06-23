package eu.jobernas.demorecyclerview.contacts

interface ItemViewModel {
    val identifier: String
    val layoutId: Int
    val viewType: Int
        get() = layoutId
}