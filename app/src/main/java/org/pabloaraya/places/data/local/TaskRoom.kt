package org.pabloaraya.places.data.local

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import org.pabloaraya.places.domain.Task
import org.pabloaraya.places.domain.TaskRepository

class TaskRoom(private val taskRoomDao: TaskRoomDao): TaskRepository {

  @WorkerThread
  suspend fun insert(task: Task) {
    taskRoomDao.insert(task)
  }

  override fun getAllTasks(): LiveData<List<Task>> {
   return taskRoomDao.getAll()
  }
}