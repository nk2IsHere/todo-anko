package ga.nk2ishere.dev.todo.Views.Presenters

import ga.nk2ishere.dev.todo.Models.TodoEntry
import ga.nk2ishere.dev.todo.Views.Interfaces.TodoAddView
import io.realm.Realm
import org.jetbrains.anko.AnkoAsyncContext
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.custom.async
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.info
import java.util.concurrent.ExecutorService

/**
 * Created by nk2 on 08/10/2017.
 */
class TodoAddActivityPresenter (val todoAddView: TodoAddView) {
    fun init() = AnkoLogger<TodoAddActivityPresenter>().info { "Start activity" }

    fun addTodo(name: String, desc: String) {
        val realm = Realm.getDefaultInstance()
        if(name.isNotEmpty() || name.isNotBlank()) {
               if(desc.isNotBlank() || desc.isNotEmpty()) {
                   realm.beginTransaction()
                   realm.copyToRealm(TodoEntry(name, desc))
                   realm.commitTransaction()
                   todoAddView.exit()
               } else todoAddView.showErrorDesc("Пустое!")
        } else todoAddView.showErrorName("Пустое!")
        realm.close()
    }
}