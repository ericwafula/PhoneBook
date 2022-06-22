package tech.ericwathome.phonebook.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import tech.ericwathome.phonebook.R

class ContactActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)
    }
}