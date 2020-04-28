package com.gmail.gosnellwebdesign.todolist

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_create_to_do.*

class CreateToDoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_to_do)

        buttonSave.setOnClickListener {
            var title = ""

            //Put a "!" next to list item if "IMPORTANT" is checked
            if (checkBoxImportant.isChecked){
                title = "! " + editTextTitle.text.toString()
            } else {
                title = editTextTitle.text.toString()
            }

            //Changes made
            // Get existing shared preferences and restrict sharing them with other apps
            var prefs = getSharedPreferences(getString(R.string.SHARED_PREF_NAME), Context.MODE_PRIVATE)
            // Grab to do list from "todostrings" and allow ability to add to list later
            var todos = prefs.getStringSet(getString(R.string.TODO_STRINGS), setOf())?.toMutableSet()
            if (todos != null) {
                todos.add(title)
            }

            // Edit shared preferences and update with latest "todostrings" value
            prefs.edit().putStringSet("todostrings", todos).apply()

            //Return to main screen
            finish()
        }
    }
}
