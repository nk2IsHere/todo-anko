package ga.nk2ishere.dev.todo.App.Layouts

import android.content.Context
import android.text.InputType
import android.view.Gravity
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import ga.nk2ishere.dev.todo.R
import ga.nk2ishere.dev.todo.Utils.dip
import org.jetbrains.anko.*
import kotlin.properties.Delegates

/**
 * Created by nk2 on 07/10/2017.
 */
class TodoAddLayout: AnkoComponent<Context> {

    var title: EditText by Delegates.notNull()
    var description: EditText by Delegates.notNull()
    var add: Button by Delegates.notNull()

    override fun createView(ui: AnkoContext<Context>): View = ui.apply {
        linearLayout {
            orientation = LinearLayout.VERTICAL
            title = editText {
                hint = "Название"
                hintTextColor = resources.getColor(R.color.gray)
                backgroundResource = R.color.theLightestGray
                inputType = InputType.TYPE_CLASS_TEXT
                lines = 1
                padding = 8.dip()

            }.lparams(width = matchParent, height = wrapContent) {
                leftMargin = 16.dip()
                rightMargin = 16.dip()
                topMargin = 16.dip()
            }
            description = editText {
                hint = "Описание"
                hintTextColor = resources.getColor(R.color.gray)
                backgroundResource = R.color.theLightestGray
                inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_MULTI_LINE
                imeOptions = EditorInfo.IME_FLAG_NO_ENTER_ACTION
                lines = 2
                maxLines = 8
                singleLine = false
                padding = 8.dip()
                gravity = Gravity.TOP

            }.lparams(width = matchParent, height = wrapContent) {
                leftMargin = 16.dip()
                rightMargin = 16.dip()
                topMargin = 16.dip()
            }
            add = button {
                text = "Добавить"
                backgroundResource = R.color.backgroundLight
            }.lparams(width = wrapContent, height = wrapContent) {
                rightMargin = 16.dip()
                topMargin = 16.dip()
                gravity = Gravity.RIGHT
            }
        }
    }.view
}