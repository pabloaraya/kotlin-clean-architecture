package com.blackmind.app.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.blackmind.app.R

import com.blackmind.app.domain.TaskTestRepository

class TaskFragment : Fragment(),
    TaskAdapter.TaskAdapterOnItemClickHandler {

  private lateinit var taskAdapter: TaskAdapter
  private lateinit var recyclerView: RecyclerView
  private lateinit var loading: ProgressBar
  private lateinit var viewModel: TaskViewModel

  private var position = RecyclerView.NO_POSITION

  override fun onViewCreated(
    view: View,
    savedInstanceState: Bundle?
  ) {
    super.onViewCreated(view, savedInstanceState)

    loading = view.findViewById(R.id.loading)

    taskAdapter = TaskAdapter(this)

    val gridLayoutManager = StaggeredGridLayoutManager(2, RecyclerView.VERTICAL)
        .apply {
          gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_NONE
        }

    recyclerView = view.findViewById<RecyclerView>(R.id.taskRecycler)
        .apply {
          layoutManager = gridLayoutManager
          setHasFixedSize(true)
          adapter = taskAdapter
        }

    viewModel = ViewModelProviders.of(this,
        TaskViewModelFactory(TaskTestRepository())
    )
        .get(TaskViewModel::class.java)

    viewModel.getAllTask()
        .observe(this, Observer<List<TaskEntity>> { entities: List<TaskEntity> ->
          taskAdapter.updateTasks(entities)
          if (position == RecyclerView.NO_POSITION) position = 0
          recyclerView.smoothScrollToPosition(position)

          if (entities.isNotEmpty())
            showTasksDataView()
          else
            showLoading()
        })
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.task_fragment, container, false)
  }

  private fun showTasksDataView() {
    loading.visibility = View.INVISIBLE
    recyclerView.visibility = View.VISIBLE
  }

  private fun showLoading() {
    recyclerView.visibility = View.INVISIBLE
    loading.visibility = View.VISIBLE
  }

  override fun onItemClick(title: String) {

  }
}
