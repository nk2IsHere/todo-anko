package ga.nk2ishere.dev.todo.App.Views

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

/**
 * Created by nk2 on 08/10/2017.
 */
interface TodoAddView: MvpView {
    fun showErrorName(error: String)
    fun showErrorDesc(error: String)
    fun exit()
}