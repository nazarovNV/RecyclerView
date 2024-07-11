package otus.gpb.recyclerview

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PageScrollListener(private val layoutManager: LinearLayoutManager)
    : RecyclerView.OnScrollListener() {
        var onLoadMore: (() -> Unit)? = null
    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        val totalItemCount = layoutManager.itemCount
        val visibleItemCount = layoutManager.childCount
        val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()
        if (visibleItemCount + firstVisibleItemPosition >= totalItemCount) {
            onLoadMore?.invoke()
        }
    }

}