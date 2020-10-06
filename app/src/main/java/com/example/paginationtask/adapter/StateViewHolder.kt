package id.mustofa.pagingretrofit.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.paginationtask.network.NetworkState
import com.example.paginationtask.network.Status
import id.mustofa.pagingretrofit.ext.visible
import kotlinx.android.synthetic.main.item_state.view.*

class StateViewHolder(view: View, val retryCallback: () -> Unit) : RecyclerView.ViewHolder(view) {

  fun setState(state: NetworkState?) {
    with(itemView) {
      stateProgressBar.visible(state?.status == Status.RUNNING)
      stateRetryBtn.visible(state?.status == Status.FAILED)
      stateRetryBtn.setOnClickListener { retryCallback() }
      stateMessage.visible(state?.msg != null)
      stateMessage.text = state?.msg
    }
  }
}