package org.pabloaraya.places.data.remote

import androidx.lifecycle.LiveData
import org.pabloaraya.places.domain.Task
import org.pabloaraya.places.domain.TaskRepository

class TaskRetrofit(private val taskService: TaskService): TaskRepository {

  override fun getAllTasks(): LiveData<List<Task>> {
    //return taskService.getAllTasksAsync().await()
  }

  override fun addTask() {
    taskService.addTask()
  }

  override fun deleteTask() {
    taskService.deleteTask("1")
  }
}