package org.pabloaraya.places.domain

import androidx.lifecycle.LiveData

interface TaskRepository {

  fun getAllTasks(): LiveData<List<Task>>

  fun addTask()

  fun deleteTask()
}