package ga.nk2ishere.dev.todo.Views.Presenters

import ga.nk2ishere.dev.todo.Application
import ga.nk2ishere.dev.todo.Models.TodoEntry
import ga.nk2ishere.dev.todo.Views.Adapters.TodoListAdapter
import ga.nk2ishere.dev.todo.Views.Interfaces.TodoListView
import ga.nk2ishere.dev.todo.Views.Layouts.TodoFullItemLayout
import io.realm.Realm
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

/**
 * Created by nk2 on 07/10/2017.
 */
class TodoListActivityPresenter(val todoListView: TodoListView) {
    fun init() {
        AnkoLogger<TodoListActivityPresenter>().info { "Start activity" }
        todoListView.initTodoLists()
    }

    fun onTodoAdd() = todoListView.addTodo()
    fun onTodoClick(id: String) = todoListView.clickTodo(id)
    fun updateAdapter(completed: Boolean, adapter: TodoListAdapter) {
        val realm = Realm.getDefaultInstance()
        adapter.todoList.clear()
        realm.where(TodoEntry::class.java)
                .equalTo("complete", completed)
                .findAllAsync()
                .filter { !adapter.todoList.contains(it) }.forEach {
            println("${it.title} ${it.complete}")
            adapter.todoList.add(it)
        }
        adapter.notifyDataSetChanged()
    }
    fun changeCompleteState(id: String) {
        val realm = Realm.getDefaultInstance()
        realm.where(TodoEntry::class.java)
                .equalTo("id", id)
                .findAllAsync().forEach {
            realm.beginTransaction()
            it.complete = !it.complete
            realm.commitTransaction()
        }
        realm.close()
        todoListView.updateTodoLists()
    }
    fun removeTodo(id: String) {
        val realm = Realm.getDefaultInstance()
        realm.executeTransaction {
            realm.where(TodoEntry::class.java)
                    .equalTo("id", id)
                    .findAll()
                    .deleteAllFromRealm()
        }
        realm.close()
        todoListView.updateTodoLists()
    }
    fun clickTodo(id: String) {
        val realm = Realm.getDefaultInstance()
        realm.where(TodoEntry::class.java)
                .equalTo("id", id)
                .findAllAsync().forEach {
            val layout = TodoFullItemLayout()
            val view = layout.createView(AnkoContext.Companion.create(Application.context)).apply {
                layout.title.text = it.title
                layout.description.text = it.description
            }
            todoListView.showBottomSheet(view)
        }
        realm.close()
    }
    fun onResume() = todoListView.updateTodoLists()
}