package tech.ericwathome.phonebook.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import tech.ericwathome.phonebook.adapter.AllContactsAdapter
import tech.ericwathome.phonebook.data.ContactData
import tech.ericwathome.phonebook.databinding.FragmentHomeBinding
import tech.ericwathome.phonebook.ui.activities.MainActivity

class HomeFragment : Fragment() {
    private val TAG = this::class.simpleName
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        initializeViews()
        return view
    }

    private fun initializeViews() {
        val context = requireContext()
        val adapter = AllContactsAdapter(context, ContactData.contacts)
        binding.allContactsRecyclerview.adapter = adapter
        binding.allContactsRecyclerview.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = RecyclerView.VERTICAL
        binding.allContactsRecyclerview.layoutManager = layoutManager


    }
}