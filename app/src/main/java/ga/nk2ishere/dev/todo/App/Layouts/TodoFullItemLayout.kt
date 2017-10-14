package ga.nk2ishere.dev.todo.App.Layouts

import android.content.Context
import android.graphics.Typeface
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import ga.nk2ishere.dev.todo.R
import ga.nk2ishere.dev.todo.Utils.dip
import org.jetbrains.anko.*
import kotlin.properties.Delegates

/**
 * Created by nk2 on 13/10/2017.
 */
class TodoFullItemLayout: AnkoComponent<Context> {

    var title: TextView by Delegates.notNull()
    var description: TextView by Delegates.notNull()

    override fun createView(ui: AnkoContext<Context>): View = ui.apply {
        linearLayout {
            orientation = LinearLayout.VERTICAL
            backgroundColor = resources.getColor(R.color.backgroundLight)
            title = textView {
                textColor = resources.getColor(R.color.gray)
                textSize = 24f
                typeface = Typeface.DEFAULT_BOLD
            }.lparams(width = wrapContent, height = wrapContent) {
                topMargin = 16.dip()
                leftMargin = 16.dip()
            }
            description = textView {
                textColor = resources.getColor(R.color.gray)
                textSize = 18f
            }.lparams(width = wrapContent, height = wrapContent) {
                topMargin = 16.dip()
                bottomMargin = 16.dip()
                leftMargin = 16.dip()
            }
        }
    }.view
}