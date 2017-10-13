package ga.nk2ishere.dev.todo.Views

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.view.View
import android.widget.GridLayout
import ga.nk2ishere.dev.todo.Views.Adapters.TodoListAdapter
import ga.nk2ishere.dev.todo.Views.Layouts.TodoListLayout
import ga.nk2ishere.dev.todo.Views.Presenters.TodoListActivityPresenter
import ga.nk2ishere.dev.todo.Views.Interfaces.TodoListView
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.startActivity

/**
 * Created by nk2 on 07/10/2017.
 */
class TodoListActivity: AppCompatActivity(), TodoListView {

    private val presenter = TodoListActivityPresenter(this)
    val layout = TodoListLayout()

    private var completedAdapter: TodoListAdapter? = null
    private var uncompletedAdapter: TodoListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layout.setContentView(this)
        presenter.init()
        layout.addTodo.onClick { presenter.onTodoAdd() }
    }

    override fun onResume() {
        presenter.onResume()
        super.onResume()
    }

    override fun changeTodoCompleteState(id: String) = presenter.changeCompleteState(id)

    override fun updateTodoLists() {
        completedAdapter?.let { presenter.updateAdapter(true, it) }
        uncompletedAdapter?.let { presenter.updateAdapter(false, it) }
    }

    override fun showBottomSheet(view: View) = layout.bottomSheetLayout.showWithSheetView(view)

    override fun initTodoLists() {
        completedAdapter = TodoListAdapter(this, arrayListOf(), { changeTodoCompleteState(it) }, { removeTodo(it) }, { clickTodo(it) })
        uncompletedAdapter = TodoListAdapter(this, arrayListOf(), { changeTodoCompleteState(it) }, { removeTodo(it) }, { clickTodo(it) })
        layout.listDone.layoutManager = GridLayoutManager(this, 1)
        layout.listUndone.layoutManager = GridLayoutManager(this, 1)
        layout.listDone.adapter = completedAdapter
        layout.listUndone.adapter = uncompletedAdapter
    }

    override fun removeTodo(id: String) = presenter.removeTodo(id)
    override fun clickTodo(id: String) = presenter.clickTodo(id)
    override fun addTodo() = startActivity<TodoAddActivity>()
}