package tech.ericwathome.phonebook.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.snackbar.Snackbar
import tech.ericwathome.phonebook.R
import tech.ericwathome.phonebook.adapter.FavoriteContactsAdapter
import tech.ericwathome.phonebook.data.ContactData
import tech.ericwathome.phonebook.databinding.FragmentFavoritesBinding

class FavoritesFragment : Fragment() {
    private val TAG = this::class.simpleName
    private lateinit var binding: FragmentFavoritesBinding
    private lateinit var adapter: FavoriteContactsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        val view = binding.root
        initializeViews()
        return view
    }

    private fun initializeViews() {
        val context = requireContext()
        adapter = FavoriteContactsAdapter(context, ContactData.favoriteContacts)
        val layoutManager = GridLayoutManager(context, 2)
        binding.recyclerview.adapter = adapter
        binding.recyclerview.layoutManager = layoutManager
    }

}