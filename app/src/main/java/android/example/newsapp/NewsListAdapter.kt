package android.example.newsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class NewsListAdapter(
    private val news: ArrayList<Articles>,
    private val listener: MainActivity
) : RecyclerView.Adapter<NewsListAdapter.NewsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        val viewHolder = NewsViewHolder(view)
        view.setOnClickListener {
            listener.onItemClicked(news[viewHolder.adapterPosition])
        }
        return NewsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return news.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val currentItem = news[position]
        holder.titleView.text = currentItem.title
        Glide.with(holder.itemView).load(currentItem.urlToImage).into(holder.imageView)
    }

    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleView: TextView = itemView.findViewById(R.id.titleItem)
        var imageView: ImageView = itemView.findViewById(R.id.imageView)
    }

}
interface onItemClicked {
    val news: ArrayList<Articles>
    fun onItemClicked(item: Articles)
}