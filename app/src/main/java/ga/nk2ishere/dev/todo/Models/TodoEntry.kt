package ga.nk2ishere.dev.todo.Models

import com.github.debop.kodatimes.now
import io.realm.Realm
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*
import kotlin.properties.Delegates



/**
 * Created by nk2 on 07/10/2017.
 */
open class TodoEntry() : RealmObject() {
    @PrimaryKey
    var id: String = UUID.randomUUID().toString()
    var title: String = ""
    var description: String = ""
    var created: Long = now().millis
    var complete: Boolean = false

    constructor(title: String, description: String): this() {
        this.title = title
        this.description = description
    }
}