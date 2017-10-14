package ga.nk2ishere.dev.todo.App.Views

import android.view.View
import com.arellomobile.mvp.MvpView

/**
 * Created by nk2 on 08/10/2017.
 */
interface TodoListView: MvpView {
    fun updateTodoLists()
    fun removeTodo(id: String)
    fun initTodoLists()
    fun addTodo()
    fun changeTodoCompleteState(id: String)
    fun clickTodo(id: String)
    fun showBottomSheet(view: View)
}