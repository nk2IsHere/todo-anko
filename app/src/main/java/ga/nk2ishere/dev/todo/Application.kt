package ga.nk2ishere.dev.todo

import android.app.Application
import android.content.Context
import io.realm.Realm
import kotlin.properties.Delegates

/**
 * Created by nk2 on 07/10/2017.
 */
class Application: Application() {

    companion object {
        var context: Context by Delegates.notNull()
    }

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        context = this
    }
}