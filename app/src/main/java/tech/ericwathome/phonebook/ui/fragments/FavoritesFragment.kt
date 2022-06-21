package tech.ericwathome.phonebook.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import tech.ericwathome.phonebook.R
import tech.ericwathome.phonebook.databinding.FragmentFavoritesBinding

class FavoritesFragment : Fragment() {
    private val TAG = this::class.simpleName
    private lateinit var binding: FragmentFavoritesBinding

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
        Log.d(TAG, "initializeViews: ")
        binding.button.setOnClickListener {
            Snackbar.make(activity!!.findViewById(R.id.main_activity), "clicked", Snackbar.LENGTH_LONG).show()
        }
    }

}