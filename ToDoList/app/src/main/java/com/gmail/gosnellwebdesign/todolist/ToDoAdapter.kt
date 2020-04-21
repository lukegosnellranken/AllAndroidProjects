package com.gmail.gosnellwebdesign.todolist

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_complete_to_do.view.*

class ToDoAdapter(val todos: List<String>) : RecyclerView.Adapter<ToDoAdapter.ToDoHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ToDoHolder {
        return ToDoHolder(LayoutInflater.from(p0.context).inflate(R.layout.todo_row, p0, false))
    }

    override  fun getItemCount(): Int {
        if (todos.count() != null){
            return todos.count()
        } else {
            return 0
        }
    }

    override fun onBindViewHolder(p0: ToDoHolder, p1: Int) {
        val title = todos[p1]
        p0.bindToDo(title)
    }

    class ToDoHolder(v:View) : RecyclerView.ViewHolder(v), View.OnClickListener {
        var view : View = v
        var title : String = ""

        init {
            v.setOnClickListener(this)
        }

        fun bindToDo(title:String){
            this.title = title
            view.textViewTitleCompleteToDo.text = title
        }

        override fun onClick(v: View?) {
            val intent = Intent(view.context, CompleteToDoActivity::class.java)
            intent.putExtra("title", title)
            startActivity(view.context, intent, null)
        }
    }
}