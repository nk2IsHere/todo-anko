package ga.nk2ishere.dev.todo.App

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.PresenterType
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.arellomobile.mvp.presenter.ProvidePresenterTag
import ga.nk2ishere.dev.todo.App.Layouts.TodoAddLayout
import ga.nk2ishere.dev.todo.App.Presenters.TodoAddActivityPresenter
import ga.nk2ishere.dev.todo.App.Views.TodoAddView
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.setContentView

/**
 * Created by nk2 on 07/10/2017.
 */
class TodoAddActivity: MvpAppCompatActivity(), TodoAddView {

    val layout = TodoAddLayout()

    @InjectPresenter(type = PresenterType.GLOBAL)
    lateinit var presenter: TodoAddActivityPresenter
    @ProvidePresenterTag(presenterClass = TodoAddActivityPresenter::class, type = PresenterType.GLOBAL)
    fun providePresenterTag(): String = "ADD"
    @ProvidePresenter(type = PresenterType.GLOBAL)
    fun providePresenter() = TodoAddActivityPresenter()

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