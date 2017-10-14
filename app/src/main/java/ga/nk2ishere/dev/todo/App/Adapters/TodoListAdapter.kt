package ga.nk2ishere.dev.todo.App.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import ga.nk2ishere.dev.todo.Models.TodoEntry
import ga.nk2ishere.dev.todo.App.Layouts.TodoItemLayout
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.sdk25.coroutines.onClick

/**
 * Created by nk2 on 08/10/2017.
 */
class TodoListAdapter(val context: Context, var todoList: ArrayList<TodoEntry>, val onChangeComplete: (String) -> Unit, val onDelete: (String) -> Unit, val onClick: (String) -> Unit): RecyclerView.Adapter<TodoListAdapter.TodoListViewHolder>() {

    override fun onBindViewHolder(holder: TodoListViewHolder, position: Int) {
        holder.title.text = todoList[position].title
        holder.shortTitle.text = todoList[position].title[0].toString().capitalize()
        holder.description.text = todoList[position].description
        holder.completed.isChecked = todoList[position].complete
        holder.completed.onClick { onChangeComplete.invoke(todoList[position].id) }
        holder.delete.onClick { onDelete.invoke(todoList[position].id) }
        holder.itemView.onClick { onClick.invoke(todoList[position].id) }
    }

    override fun getItemCount(): Int = todoList.size
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): TodoListViewHolder {
        val layout = TodoItemLayout()
        return TodoListViewHolder(layout.createView(AnkoContext.Companion.create(context)), layout)
    }

    class TodoListViewHolder(view: View, layout: TodoItemLayout): RecyclerView.ViewHolder(view) {
        val title = layout.title
        val description = layout.description
        val completed = layout.completed
        val shortTitle = layout.shortTitle
        val delete = layout.delete
    }
}