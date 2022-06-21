package tech.ericwathome.phonebook.data

data class Contact (var firstName: String, var lastName: String, var phoneNumber: String, var isFavorite: Boolean = false)

object ContactData {
    var contacts = ArrayList<Contact>()
    var favoriteContacts = ArrayList<Contact>()

    init {
        initializeContacts()
    }

    private fun initializeContacts() {
        var contact = Contact("Eric", "Wathome", "0722261627")
        contacts.add(contact)
        contact = Contact("Daniel", "Eric", "0705189393")
        contacts.add(contact)
        contact = Contact("Eric", "Wafula", "0712250082")
        contacts.add(contact)
        contact = Contact("Leon", "Salinski", "0722261627")
        contacts.add(contact)
    }
}