package ga.nk2ishere.dev.todo.Views.Interfaces

import android.view.View

/**
 * Created by nk2 on 08/10/2017.
 */
interface TodoListView {
    fun updateTodoLists()
    fun removeTodo(id: String)
    fun initTodoLists()
    fun addTodo()
    fun changeTodoCompleteState(id: String)
    fun clickTodo(id: String)
    fun showBottomSheet(view: View)
}