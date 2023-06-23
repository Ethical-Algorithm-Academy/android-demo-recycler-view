package eu.jobernas.demorecyclerview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import eu.jobernas.demorecyclerview.contacts.ContactItemViewModel
import eu.jobernas.demorecyclerview.contacts.ContactsAdapter
import eu.jobernas.demorecyclerview.databinding.FragmentRecyclerViewBinding

class RecyclerViewFragment:
    Fragment() {

    private var _binding: FragmentRecyclerViewBinding? = null
    private var adapter: ContactsAdapter = ContactsAdapter(mutableListOf(
        ContactItemViewModel("John Doe", 961234196),
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
        ContactItemViewModel("Benjamin Walker", 962345678)
    ))

    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        _binding = FragmentRecyclerViewBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            recyclerView.apply {
                adapter = this@RecyclerViewFragment.adapter
                layoutManager = LinearLayoutManager(context)
                // Grid Example
//                    GridLayoutManager(context, 2).apply {
//                    orientation = RecyclerView.HORIZONTAL
//                }
                //addItemDecoration()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}