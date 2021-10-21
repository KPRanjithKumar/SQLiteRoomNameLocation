package ran.am.sqliteroomcurd

import android.content.Context
import kotlin.jvm.Synchronized
import androidx.room.Room

internal class DatabaseClient private constructor(private val mCtx: Context) {
    val appDatabase: AppDatabase

    companion object {
        private var mnInstance: DatabaseClient? = null
        @JvmStatic
        @Synchronized
        fun getInstance(mCtx: Context): DatabaseClient? {
            if (mnInstance == null) {
                mnInstance = DatabaseClient(mCtx)
            }
            return mnInstance
        }
    }

    init {
        appDatabase = Room.databaseBuilder(mCtx, AppDatabase::class.java, "detais").build()
    }
}