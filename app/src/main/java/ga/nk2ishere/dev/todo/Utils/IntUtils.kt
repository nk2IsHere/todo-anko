package ga.nk2ishere.dev.todo.Utils

import android.content.Context
import ga.nk2ishere.dev.todo.Application
import org.jetbrains.anko.*
/**
 * Created by nk2 on 08/10/2017.
 */
//returns dip(dp) dimension value in pixels
fun Int.dip(): Int = (this * Application.context.resources.displayMetrics.density).toInt()
fun Float.dip(): Int = (this * Application.context.resources.displayMetrics.density).toInt()

//return sp dimension value in pixels
fun Int.sp(): Int = (this * Application.context.resources.displayMetrics.scaledDensity).toInt()
fun Float.sp(): Int = (this * Application.context.resources.displayMetrics.scaledDensity).toInt()

//converts px value into dip or sp
fun Int.px2dip(): Float = this.toFloat() / Application.context.resources.displayMetrics.density
fun Float.px2sp(): Float = this / Application.context.resources.displayMetrics.scaledDensity