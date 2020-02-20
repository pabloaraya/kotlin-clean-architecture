package cl.blackmind.app_local

import cl.blackmind.app_domain.TaskRepository
import cl.blackmind.app_local.TaskRoomDao

class TaskRoom(private val taskRoomDao: TaskRoomDao):
    TaskRepository {

//  @WorkerThread
//  suspend fun insert(task: Task) {
//    taskRoomDao.insert(task)
//  }
//
//  override fun getAllTasks(): LiveData<List<Task>> {
//   return taskRoomDao.getAll()
//  }
}