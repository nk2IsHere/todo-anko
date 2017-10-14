package ga.nk2ishere.dev.todo.App.Layouts

import android.content.Context
import android.graphics.Typeface
import android.text.TextUtils
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.TextView
import ga.nk2ishere.dev.todo.R
import ga.nk2ishere.dev.todo.Utils.dip
import org.jetbrains.anko.*
import kotlin.properties.Delegates

/**
 * Created by nk2 on 08/10/2017.
 */
class TodoItemLayout: AnkoComponent<Context> {

    var title: TextView by Delegates.notNull()
    var shortTitle: TextView by Delegates.notNull()
    var description: TextView by Delegates.notNull()
    var completed: CheckBox by Delegates.notNull()
    var delete: Button by Delegates.notNull()

    override fun createView(ui: AnkoContext<Context>): View = ui.apply {
        relativeLayout {
            gravity = Gravity.CENTER_VERTICAL

            linearLayout {
                orientation = LinearLayout.HORIZONTAL
                relativeLayout {
                    imageView {
                        backgroundResource = R.drawable.bg_circle
                    }.lparams(width = matchParent, height = matchParent)
                    shortTitle = textView {
                        text = "@"
                        textSize = 32f
                        textColor = resources.getColor(R.color.backgroundLight)
                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                        gravity = Gravity.CENTER
                    }.lparams(width = matchParent, height = matchParent) {
                        centerInParent()
                    }
                }.lparams(width = 72.dip(), height = 72.dip()) {
                    leftMargin = 16.dip()
                    rightMargin = 16.dip()
                }

                linearLayout {
                    orientation = LinearLayout.VERTICAL
                    title = textView {
                        typeface = Typeface.DEFAULT_BOLD
                        textSize = 24f
                        maxLines = 1
                        minWidth = 300.dip()
                        maxWidth = 300.dip()
                        ellipsize = TextUtils.TruncateAt.END
                    }
                    description = textView {
                        maxLines = 2
                        minWidth = 300.dip()
                        maxWidth = 300.dip()
                        ellipsize = TextUtils.TruncateAt.END
                    }
                }.lparams(width = matchParent, height = matchParent) {
                    gravity = Gravity.CENTER_VERTICAL
                }
            }.lparams(width = wrapContent, height = wrapContent) {
                topMargin = 16.dip()
            }
            linearLayout {
                delete = button {
                    text = "Удалить"
                    backgroundColor = resources.getColor(R.color.backgroundLight)
                    stateListAnimator = null
                }.lparams {
                    rightMargin = 4.dip()
                }
                completed = checkBox()
            }.lparams(width = wrapContent, height = wrapContent) {
                gravity = Gravity.CENTER or Gravity.CENTER_VERTICAL
                rightMargin = 16.dip()
                topMargin = 16.dip()
                alignParentBottom()
                alignParentRight()
                centerVertically()
            }
        }
    }.view
}