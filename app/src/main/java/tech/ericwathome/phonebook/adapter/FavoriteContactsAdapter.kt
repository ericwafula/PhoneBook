package tech.ericwathome.phonebook.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import tech.ericwathome.phonebook.data.Contact
import tech.ericwathome.phonebook.databinding.FavoriteListItemBinding

class FavoriteContactsAdapter(
    private val context: Context,
    private val contacts: ArrayList<Contact>
) : RecyclerView.Adapter<FavoriteContactsAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: FavoriteListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private var currentPosition = -1
        private lateinit var currentContact: Contact

        fun setData(contact: Contact, position: Int) {
            currentContact = contact
            currentPosition = position

            binding.txvUserName.text = "${contact.firstName} ${contact.lastName}"
            binding.txvUserInitial.text = contact.firstName[0].toString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = FavoriteListItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact = contacts[position]
        holder.setData(contact, position)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

}