package eu.jobernas.demorecyclerview.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import eu.jobernas.demorecyclerview.contacts.ContactExtraItemViewModel
import eu.jobernas.demorecyclerview.contacts.ContactItemViewModel
import eu.jobernas.demorecyclerview.contacts.ContactListAdapter
import eu.jobernas.demorecyclerview.contacts.ContactsAdapter
import eu.jobernas.demorecyclerview.databinding.FragmentRecyclerViewBinding

class RecyclerViewFragment : Fragment() {

    private val viewModel by viewModels<RecycleViewModel>()
    private var _binding: FragmentRecyclerViewBinding? = null
//    private val adapter: ContactsAdapter by lazy {
//        ContactsAdapter(mutableListOf())
//    }
    private val adapter: ContactListAdapter by lazy {
        ContactListAdapter()
    }
    private val binding
        get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
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
                addItemDecoration(DividerItemDecoration(context, RecyclerView.VERTICAL))
//                layoutManager = GridLayoutManager(context, 2)
                //
                // Grid Example
//                layoutManager = GridLayoutManager(context, 2).apply {
//                    orientation = RecyclerView.HORIZONTAL
//                }
                //addItemDecoration()
            }
            recyclerFabButton.setOnClickListener(viewModel)
        }
        viewModel.apply {
            onDataChanged.observe(viewLifecycleOwner) { data ->
//                adapter.load(data)
                adapter.submitList(data)
            }
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}