package tech.ericwathome.phonebook.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar
import tech.ericwathome.phonebook.R
import tech.ericwathome.phonebook.adapter.AllContactsAdapter
import tech.ericwathome.phonebook.data.Contact
import tech.ericwathome.phonebook.data.ContactData
import tech.ericwathome.phonebook.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private val TAG = this::class.simpleName
    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: AllContactsAdapter

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
        adapter = AllContactsAdapter(context, ContactData.contacts)
        binding.allContactsRecyclerview.adapter = adapter
        binding.allContactsRecyclerview.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = RecyclerView.VERTICAL
        binding.allContactsRecyclerview.layoutManager = layoutManager

        itemTouchHelper.attachToRecyclerView(binding.allContactsRecyclerview)
    }

    private val itemTouchHelper = ItemTouchHelper(object: ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            return false
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            val position = viewHolder.adapterPosition
            val deletedContact = ContactData.contacts[position]
            val bottomNav: BottomNavigationView = activity?.findViewById(R.id.bottom_nav_view)!!
            deleteContact(deletedContact, position)

            Snackbar.make(binding.root, "Deleted", Snackbar.LENGTH_LONG)
                .setAction("undo") {
                    undoDelete(deletedContact, position)
                }
                .apply { anchorView = bottomNav }
                .show()
        }
    })

    private fun undoDelete(deletedContact: Contact, position: Int) {
        ContactData.contacts.add(position, deletedContact)
        adapter.notifyItemRangeChanged(position, ContactData.contacts.size)
        adapter.notifyItemInserted(position)
    }

    private fun deleteContact(
        deletedContact: Contact,
        position: Int
    ) {
        ContactData.contacts.remove(deletedContact)
        adapter.notifyItemRemoved(position)
        adapter.notifyItemRangeChanged(position, ContactData.contacts.size)
    }
}