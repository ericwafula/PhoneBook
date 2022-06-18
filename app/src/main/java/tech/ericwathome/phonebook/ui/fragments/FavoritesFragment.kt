package tech.ericwathome.phonebook.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
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
        initializeViews(view)
        return view
    }

    private fun initializeViews(view: ConstraintLayout) {
        Log.d(TAG, "initializeViews: ")
    }

}