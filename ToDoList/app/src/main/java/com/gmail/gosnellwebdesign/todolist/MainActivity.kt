package com.gmail.gosnellwebdesign.todolist

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import java.util.stream.Collectors.toList

class MainActivity : AppCompatActivity() {

    lateinit var layoutManager : LinearLayoutManager
    lateinit var adapter : ToDoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        // Start intent when fab is selected
        fab.setOnClickListener { view ->
            val intent = Intent(this,CreateToDoActivity::class.java)
            startActivity(intent)
        }
    }

    // update recyclerView every time activity changes
    override fun onResume() {
        super.onResume()
        updateRecycler()
    }

    fun updateRecycler() {
        // Get existing shared preferences and restrict sharing them with other apps
        var prefs = getSharedPreferences(getString(R.string.SHARED_PREF_NAME), Context.MODE_PRIVATE)
        // Grab to do list from "todostrings" and allow ability to add to list later
        var todos = prefs.getStringSet(getString(R.string.TODO_STRINGS),setOf())?.toMutableSet()

        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        if (todos != null) {
            adapter = ToDoAdapter(todos.toList())
        }
        recyclerView.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.action_delete_all) {
            val dialogBuilder = AlertDialog.Builder(this)

            dialogBuilder.setMessage("Do you really want to delete all?")
                // if the dialog is cancelable
                .setCancelable(false)
                // positive button text and action
                // Deletes all list items when user selects "yes"
                .setPositiveButton("Yes", DialogInterface.OnClickListener {
                        dialog, di ->
                    // Get existing shared preferences and restrict sharing them with other apps
                    var prefs = getSharedPreferences(getString(R.string.SHARED_PREF_NAME), Context.MODE_PRIVATE)
                    // Grab to do list from "todostrings" and allow ability to add to list later
                    prefs.edit().putStringSet(getString(R.string.TODO_STRINGS), null).apply()
                    //update recyclerView
                    updateRecycler()
                })
                // negative button text and action
                // Cancels "delete all"
                .setNegativeButton("No", DialogInterface.OnClickListener {
                        dialog, id -> dialog.cancel()
                })

            // create dialog box
            val alert = dialogBuilder.create()
            // set title for alert dialog box
            alert.setTitle("AlertDialogExample")
            // show alert dialog
            alert.show()

            return true
        }

        return super.onOptionsItemSelected(item)
    }
}
