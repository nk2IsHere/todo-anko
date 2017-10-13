package ga.nk2ishere.dev.todo.Views

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import ga.nk2ishere.dev.todo.Views.Layouts.TodoAddLayout
import ga.nk2ishere.dev.todo.Views.Presenters.TodoAddActivityPresenter
import ga.nk2ishere.dev.todo.Views.Interfaces.TodoAddView
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.setContentView

/**
 * Created by nk2 on 07/10/2017.
 */
class TodoAddActivity: AppCompatActivity(), TodoAddView {

    val layout = TodoAddLayout()
    val presenter = TodoAddActivityPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layout.setContentView(this)
        presenter.init()
        layout.add.onClick { presenter.addTodo(layout.title.text.toString(), layout.description.text.toString()) }
    }

    override fun showErrorName(error: String) {
        layout.title.error = error
    }

    override fun showErrorDesc(error: String) {
        layout.description.error = error
    }

    override fun exit() = finish()
}