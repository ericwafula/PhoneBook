package tech.ericwathome.phonebook.model

import androidx.lifecycle.ViewModel
import tech.ericwathome.phonebook.data.Contact
import tech.ericwathome.phonebook.data.ContactData

class ContactActivityViewModel : ViewModel() {
    private val tag = ContactActivityViewModel::class.simpleName
    private lateinit var currentContact: Contact

    fun saveContact(contact: Contact) {
        currentContact = contact

        ContactData.contacts.add(contact)
    }
}