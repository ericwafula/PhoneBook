package tech.ericwathome.phonebook.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import tech.ericwathome.phonebook.R
import tech.ericwathome.phonebook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val TAG = this::class.simpleName
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_frag) as NavHostFragment
        navController = navHostFragment.navController

        val fragments = setOf(R.id.home, R.id.favorites)
        val appbarConfiguration = AppBarConfiguration(fragments)
        binding.toolbar.setupWithNavController(navController, appbarConfiguration)
        binding.bottomNavView.setupWithNavController(navController)
    }


}