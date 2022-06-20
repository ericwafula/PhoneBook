package tech.ericwathome.phonebook.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import tech.ericwathome.phonebook.R
import tech.ericwathome.phonebook.data.Contact
import tech.ericwathome.phonebook.databinding.ContactListItemBinding

class AllContactsAdapter (private val context: Context, private val contacts: ArrayList<Contact>) : RecyclerView.Adapter<AllContactsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ContactListItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact = contacts[position]
        holder.setData(contact, position)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    inner class ViewHolder(private val binding: ContactListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        private var currentPosition = -1
        private lateinit var currentContact: Contact

        fun setData(contact: Contact, position: Int) {
            currentPosition = position
            currentContact = contact

            binding.txvUserInitial.text = contact.firstName[0].toString()
            binding.txvUserName.text = "${contact.firstName} ${contact.lastName}"
            binding.txvPhone.text = contact.phoneNumber

            if (contact.isFavorite) {
                binding.imvFavorite.setImageDrawable(ResourcesCompat.getDrawable(context.resources, R.drawable.ic_favorite_filled, null))
            } else {
                binding.imvFavorite.setImageDrawable(ResourcesCompat.getDrawable(context.resources, R.drawable.ic_favorites_outline, null))
            }
        }

    }
}