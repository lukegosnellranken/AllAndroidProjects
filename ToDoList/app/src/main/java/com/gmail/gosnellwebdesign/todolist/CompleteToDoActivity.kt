package com.gmail.gosnellwebdesign.todolist

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_complete_to_do.*

class CompleteToDoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_complete_to_do)

        val todo = intent.extras?.getString("title")

        textViewTitleCompleteToDo.text = todo

        buttonComplete.setOnClickListener {
            var prefs = getSharedPreferences(getString(R.string.SHARED_PREF_NAME), Context.MODE_PRIVATE)
            var todos = prefs.getStringSet(getString(R.string.TODO_STRINGS), setOf())?.toMutableSet()

            if (todos != null) {
                todos.remove(todo)
            }

            prefs.edit().putStringSet("todostrings", todos).apply()

            finish()
        }


    }
}
