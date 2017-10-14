package ga.nk2ishere.dev.todo.App.Presenters

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import ga.nk2ishere.dev.todo.Application
import ga.nk2ishere.dev.todo.Models.TodoEntry
import ga.nk2ishere.dev.todo.App.Adapters.TodoListAdapter
import ga.nk2ishere.dev.todo.App.Views.TodoListView
import ga.nk2ishere.dev.todo.App.Layouts.TodoFullItemLayout
import io.realm.Realm
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

/**
 * Created by nk2 on 07/10/2017.
 */
@InjectViewState
class TodoListActivityPresenter : MvpPresenter<TodoListView>() {
    fun init() {
        AnkoLogger<TodoListActivityPresenter>().info { "Start activity" }
        viewState.initTodoLists()
    }

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
    fun changeTodoCompleteState(id: String) {
        val realm = Realm.getDefaultInstance()
        realm.where(TodoEntry::class.java)
                .equalTo("id", id)
                .findAllAsync().forEach {
            realm.beginTransaction()
            it.complete = !it.complete
            realm.commitTransaction()
        }
        realm.close()
        viewState.updateTodoLists()
    }

    fun addTodo() = viewState.addTodo()

    fun removeTodo(id: String) {
        val realm = Realm.getDefaultInstance()
        realm.executeTransaction {
            realm.where(TodoEntry::class.java)
                    .equalTo("id", id)
                    .findAll()
                    .deleteAllFromRealm()
        }
        realm.close()
        viewState.updateTodoLists()
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
            viewState.showBottomSheet(view)
        }
        realm.close()
    }
    fun onResume() = viewState.updateTodoLists()
}