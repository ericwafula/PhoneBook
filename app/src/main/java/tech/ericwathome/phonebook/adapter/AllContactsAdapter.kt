package tech.ericwathome.phonebook.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.recyclerview.widget.RecyclerView
import tech.ericwathome.phonebook.R
import tech.ericwathome.phonebook.data.Contact

class AllContactsAdapter (private val context: Context, val contacts: ArrayList<Contact>) : RecyclerView.Adapter<AllContactsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.contact_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact = contacts[position]
        holder.setData(contact, position)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var currentPosition = -1
        private lateinit var currentContact: Contact

        private val txvUserInitial: TextView = itemView.findViewById(R.id.txv_user_initial)
        private val txvUserName: TextView = itemView.findViewById(R.id.txv_user_name)
        private val txvPhone: TextView = itemView.findViewById(R.id.txv_phone)
        private val imvFavorite: ImageView = itemView.findViewById(R.id.imv_favorite)

        fun setData(contact: Contact, position: Int) {
            currentPosition = position
            currentContact = contact

            txvUserInitial.text = contact.firstName[0].toString()
            txvUserName.text = "${contact.firstName} ${contact.lastName}"
            txvPhone.text = contact.phoneNumber

            if (contact.isFavorite) {
                imvFavorite.setImageDrawable(ResourcesCompat.getDrawable(context.resources, R.drawable.ic_favorite_filled, null))
            } else {
                imvFavorite.setImageDrawable(ResourcesCompat.getDrawable(context.resources, R.drawable.ic_favorites_outline, null))
            }
        }

    }
}