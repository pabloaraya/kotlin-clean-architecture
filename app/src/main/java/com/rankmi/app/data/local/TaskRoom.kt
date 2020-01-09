package com.rankmi.app.data.local

import com.rankmi.app.domain.TaskRepository

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