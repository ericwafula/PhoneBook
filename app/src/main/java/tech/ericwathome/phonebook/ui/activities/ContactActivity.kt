package tech.ericwathome.phonebook.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import tech.ericwathome.phonebook.data.Contact
import tech.ericwathome.phonebook.data.ContactData
import tech.ericwathome.phonebook.databinding.ActivityContactBinding
import tech.ericwathome.phonebook.model.ContactActivityViewModel

class ContactActivity : AppCompatActivity() {
    private lateinit var binding: ActivityContactBinding

    private val viewModel by lazy {
        ViewModelProvider(this)[ContactActivityViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener { saveContact() }
    }

    override fun onPause() {
        super.onPause()
        saveContact()
    }

    private fun saveContact() {
        val firstName = binding.txvFirstName.text.toString().trim()
        val lastName = binding.txvLastName.text.toString().trim()
        val phoneNumber = binding.txvPhoneNumber.text.toString().trim()

        if (firstName.isNotEmpty() && lastName.isNotEmpty() && phoneNumber.isNotEmpty()) {
            val contact = Contact(firstName, lastName, phoneNumber)
            if (!ContactData.contacts.contains(contact)) {
                viewModel.saveContact(contact)
            } else {
                Snackbar.make(binding.root, "contact already exists", Snackbar.LENGTH_LONG)
                    .show()
            }
        } else {
            Snackbar.make(binding.root, "all fields must contain a value", Snackbar.LENGTH_LONG)
                .show()
        }
    }

}