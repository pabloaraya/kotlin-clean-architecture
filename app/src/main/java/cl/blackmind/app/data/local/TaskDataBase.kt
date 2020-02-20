package cl.blackmind.app.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import cl.blackmind.app_local.TaskEntity
import cl.blackmind.app_local.TaskRoomDao

@Database(entities = arrayOf(TaskEntity::class), version = 1)
abstract class TaskDataBase : RoomDatabase() {

    abstract fun weatherDataDao(): TaskRoomDao

    companion object {
        private var INSTANCE: TaskDataBase? = null

        fun getInstance(context: Context): TaskDataBase? {
            if (INSTANCE == null) {
                synchronized(TaskDataBase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.getApplicationContext(),
                        TaskDataBase::class.java, "tasks.db"
                    ).build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}