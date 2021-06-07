package com.example.sobremim2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.MenuInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.sobremim2.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        binding.appBarMain.fab.setOnClickListener { //view ->
            val email = Intent(Intent.ACTION_SENDTO)
            email.data = Uri.parse("mailto:david.mrcs@gmail.com")
            email.putExtra(Intent.EXTRA_SUBJECT, "[Currículo APP] - ")
            email.putExtra(Intent.EXTRA_TEXT, "Olá, David.")
            startActivity(email)
            /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()*/
        }
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_experiencia, R.id.nav_formacao
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.getItemId()) {
            R.id.item1 -> {
                Toast.makeText(this, "Item 1 selecionado", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_sobremim -> {
                Toast.makeText(this, "Item 2 selecionado", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_experiencia -> {
                Toast.makeText(this, "Item 3 selecionado", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_formacao -> {
                Toast.makeText(this, "Item 3 selecionado", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun enviaEmail(view: View) {
        /*val email = Intent(Intent.ACTION_SENDTO)
        email.data = Uri.parse("mailto:your.eamil@gmail.com")
        email.putExtra(Intent.EXTRA_SUBJECT, "Subject")
        email.putExtra(Intent.EXTRA_TEXT, "My Email message")
        startActivity(email)*/
    }
}