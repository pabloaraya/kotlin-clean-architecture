package com.blackmind.app.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.blackmind.app.domain.TaskTestRepository

internal class TaskViewModel(private val repository: TaskTestRepository) : ViewModel() {

    private val tasks: LiveData<List<TaskEntity>> = repository.getTasks()

    fun getAllTask(): LiveData<List<TaskEntity>> = tasks
}
