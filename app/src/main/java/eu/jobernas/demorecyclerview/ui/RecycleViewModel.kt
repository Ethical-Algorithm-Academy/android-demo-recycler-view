package eu.jobernas.demorecyclerview.ui

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import eu.jobernas.demorecyclerview.R
import eu.jobernas.demorecyclerview.contacts.ContactExtraItemViewModel
import eu.jobernas.demorecyclerview.contacts.ContactItemViewModel
import eu.jobernas.demorecyclerview.contacts.ItemViewModel

class RecycleViewModel: ViewModel(),
    View.OnClickListener {

    private val data: List<ItemViewModel> = mutableListOf(ContactItemViewModel("John Doe", 961234196),
                                                  ContactExtraItemViewModel(961234199),
                                                  ContactExtraItemViewModel(961234193),
                                                  ContactExtraItemViewModel(961234191),
                                                  ContactExtraItemViewModel(961234192),
                                                  ContactItemViewModel("Jessica Alda", 962434111),
                                                  ContactItemViewModel("Michael Smith", 964567890),
                                                  ContactItemViewModel("Emily Johnson", 965432109),
                                                  ContactItemViewModel("David Wilson", 963210987),
                                                  ContactItemViewModel("Sarah Davis", 968765432),
                                                  ContactItemViewModel("Daniel Brown", 967654321),
                                                  ContactItemViewModel("Olivia Taylor", 966789012),
                                                  ContactItemViewModel("Matthew Anderson", 961234567),
                                                  ContactItemViewModel("Sophia Martinez", 963456789),
                                                  ContactItemViewModel("Christopher Lee", 968765432),
                                                  ContactItemViewModel("Isabella Thomas", 962345678),
                                                  ContactItemViewModel("Andrew Rodriguez", 966789012),
                                                  ContactItemViewModel("Mia Hernandez", 961098765),
                                                  ContactItemViewModel("Joseph Johnson", 962134567),
                                                  ContactItemViewModel("Ava Garcia", 965432109),
                                                  ContactItemViewModel("David Clark", 967890123),
                                                  ContactItemViewModel("Sophia Thompson", 964567890),
                                                  ContactItemViewModel("James Davis", 963401234),
                                                  ContactItemViewModel("Emily Wilson", 961234509),
                                                  ContactItemViewModel("Jacob Moore", 962345678),
                                                  ContactItemViewModel("Emma Mitchell", 967890123),
                                                  ContactItemViewModel("Daniel Turner", 964567890),
                                                  ContactItemViewModel("Olivia Baker", 963210987),
                                                  ContactItemViewModel("Alexander Scott", 961230987),
                                                  ContactItemViewModel("Abigail Young", 968765432),
                                                  ContactItemViewModel("Ryan Phillips", 961234567),
                                                  ContactItemViewModel("Charlotte Allen", 965432109),
                                                  ContactItemViewModel("William King", 962349876),
                                                  ContactItemViewModel("Grace Lewis", 961239876),
                                                  ContactItemViewModel("Benjamin Walker", 962345678))

    val onDataChanged: LiveData<List<ItemViewModel>>
        get() = _onDataChanged
    private val _onDataChanged: MutableLiveData<List<ItemViewModel>> = MutableLiveData(emptyList())

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.recycler_fab_button -> {
                _onDataChanged.postValue(data)
            }
        }
    }

}