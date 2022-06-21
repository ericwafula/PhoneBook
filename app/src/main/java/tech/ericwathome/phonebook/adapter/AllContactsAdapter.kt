package tech.ericwathome.phonebook.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import tech.ericwathome.phonebook.R
import tech.ericwathome.phonebook.data.Contact
import tech.ericwathome.phonebook.data.ContactData
import tech.ericwathome.phonebook.databinding.ContactListItemBinding

class AllContactsAdapter (private val context: Context, private val contacts: ArrayList<Contact>) : RecyclerView.Adapter<AllContactsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ContactListItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact = contacts[position]
        holder.setData(contact, position)
        holder.setListeners()
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    inner class ViewHolder(private val binding: ContactListItemBinding) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        private var currentPosition = -1
        private lateinit var currentContact: Contact
        private val starFilled = ResourcesCompat.getDrawable(context.resources, R.drawable.ic_favorite_filled, null)
        private val starOutlined = ResourcesCompat.getDrawable(context.resources, R.drawable.ic_favorites_outline, null)

        fun setData(contact: Contact, position: Int) {
            currentPosition = position
            currentContact = contact

            binding.txvUserInitial.text = contact.firstName[0].toString()
            binding.txvUserName.text = "${contact.firstName} ${contact.lastName}"
            binding.txvPhone.text = contact.phoneNumber

            if (contact.isFavorite) {
                binding.imvFavorite.setImageDrawable(starFilled)
            } else {
                binding.imvFavorite.setImageDrawable(starOutlined)
            }
        }

        fun setListeners() {
            binding.imvFavorite.setOnClickListener(this@ViewHolder)
        }

        override fun onClick(v: View?) {
            when (v?.id) {
                R.id.imv_favorite -> addToFavorites()
            }
        }

        private fun addToFavorites() {
            currentContact.isFavorite = !currentContact.isFavorite
            if (currentContact.isFavorite) {
                binding.imvFavorite.setImageDrawable(starFilled)
            } else {
                binding.imvFavorite.setImageDrawable(starOutlined)
            }
        }
    }
}