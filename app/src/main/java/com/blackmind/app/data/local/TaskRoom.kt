package com.blackmind.app.data.local

import com.blackmind.app.domain.TaskRepository

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