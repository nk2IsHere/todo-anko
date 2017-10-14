package ga.nk2ishere.dev.todo.App.Layouts

import android.content.Context
import android.graphics.Typeface
import android.support.design.widget.FloatingActionButton
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.LinearLayout
import com.flipboard.bottomsheet.BottomSheetLayout
import ga.nk2ishere.dev.todo.R
import ga.nk2ishere.dev.todo.Utils.bottomSheetLayout
import ga.nk2ishere.dev.todo.Utils.dip
import org.jetbrains.anko.*
import org.jetbrains.anko.design.floatingActionButton
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.nestedScrollView
import kotlin.properties.Delegates

/**
 * Created by nk2 on 07/10/2017.
 */
class TodoListLayout: AnkoComponent<Context> {

    var bottomSheetLayout: BottomSheetLayout by Delegates.notNull()
    var listUndone: RecyclerView by Delegates.notNull()
    var listDone: RecyclerView by Delegates.notNull()
    var addTodo: FloatingActionButton by Delegates.notNull()

    override fun createView(ui: AnkoContext<Context>): View = ui.apply {
        bottomSheetLayout = bottomSheetLayout {
            relativeLayout {

                nestedScrollView {

                    linearLayout {
                        orientation = LinearLayout.VERTICAL

                        textView("Не сделано") {
                            textSize = 24f
                            typeface = Typeface.DEFAULT_BOLD
                        }.lparams(width = wrapContent, height = wrapContent) {
                            topMargin = 16.dip()
                            leftMargin = 16.dip()
                        }
                        listUndone = recyclerView().lparams(width = matchParent, height = wrapContent)

                        textView("Сделано") {
                            textSize = 24f
                            typeface = Typeface.DEFAULT_BOLD
                        }.lparams(width = wrapContent, height = wrapContent) {
                            topMargin = 16.dip()
                            leftMargin = 16.dip()
                        }
                        listDone = recyclerView().lparams(width = matchParent, height = wrapContent)
                    }.lparams(width = matchParent, height = wrapContent)

                }.lparams(width = matchParent, height = matchParent)

                addTodo = floatingActionButton {
                    size = FloatingActionButton.SIZE_AUTO
                    image = resources.getDrawable(R.drawable.ic_add)
                }.lparams(width = wrapContent, height = wrapContent) {
                    alignParentBottom()
                    alignParentRight()
                    margin = 16.dip()
                }

            }
        }
    }.view
}