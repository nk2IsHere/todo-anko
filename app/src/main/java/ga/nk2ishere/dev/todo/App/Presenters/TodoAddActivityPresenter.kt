package ga.nk2ishere.dev.todo.App.Presenters

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import ga.nk2ishere.dev.todo.App.Views.TodoAddView
import ga.nk2ishere.dev.todo.Models.TodoEntry
import io.realm.Realm
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

/**
 * Created by nk2 on 08/10/2017.
 */
@InjectViewState
class TodoAddActivityPresenter: MvpPresenter<TodoAddView>() {
    fun init() = AnkoLogger<TodoAddActivityPresenter>().info { "Start activity" }

    fun addTodo(name: String, desc: String) {
        val realm = Realm.getDefaultInstance()
        if(name.isNotEmpty() || name.isNotBlank()) {
               if(desc.isNotBlank() || desc.isNotEmpty()) {
                   realm.beginTransaction()
                   realm.copyToRealm(TodoEntry(name, desc))
                   realm.commitTransaction()
                   viewState.exit()
               } else viewState.showErrorDesc("Пустое!")
        } else viewState.showErrorName("Пустое!")
        realm.close()
    }
}