package org.pabloaraya.places.data.remote

import kotlinx.coroutines.Deferred
import org.pabloaraya.places.data.local.TaskEntity
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface TaskService {

  @GET("tasks/all")
  fun getAllTasksAsync(): Deferred<List<TaskEntity>>

  @POST("tasks/add")
  fun addTask()

  @POST("tasks/{id}/delete")
  fun deleteTask(@Path("id") id: String)
}