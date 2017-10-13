package ga.nk2ishere.dev.todo.Utils

import android.view.ViewManager
import com.flipboard.bottomsheet.BottomSheetLayout
import org.jetbrains.anko.custom.ankoView

/**
 * Created by nk2 on 12/10/2017.
 */

inline fun ViewManager.bottomSheetLayout(init: BottomSheetLayout.() -> Unit): BottomSheetLayout {
    return ankoView({ BottomSheetLayout(it) }, theme = 0, init = init)
}