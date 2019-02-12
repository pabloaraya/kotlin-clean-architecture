package org.pabloaraya.places.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import org.pabloaraya.places.domain.TaskTestRepository

internal class TaskViewModel(private val repository: TaskTestRepository) : ViewModel() {

    private val tasks: LiveData<List<TaskEntity>>

    init {
        tasks = repository.getTasks()
    }

    fun getAllTask(): LiveData<List<TaskEntity>> = tasks
}
