package cl.blackmind.app_local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class TaskEntity(
  @PrimaryKey(autoGenerate = true) var id: Long?,
  @ColumnInfo(name = "title") var title: String,
  @ColumnInfo(name = "description") var description: String
)