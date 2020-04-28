package com.gmail.gosnellwebdesign.todolist

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_complete_to_do.*

class CompleteToDoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_complete_to_do)

        // Get the title of item user selects
        val todo = intent.extras?.getString("title")

        // Set textview to title
        textViewTitleCompleteToDo.text = todo

        buttonComplete.setOnClickListener {
            // Get existing shared preferences and restrict sharing them with other apps
            var prefs = getSharedPreferences(getString(R.string.SHARED_PREF_NAME), Context.MODE_PRIVATE)
            // Grab to do list from "todostrings" and allow ability to add to list later
            var todos = prefs.getStringSet(getString(R.string.TODO_STRINGS), setOf())?.toMutableSet()

            // Remove item from "todostrings"
            if (todos != null) {
                todos.remove(todo)
            }

            // Apply removal to shared preferences
            prefs.edit().putStringSet("todostrings", todos).apply()

            finish()
        }


    }
}
