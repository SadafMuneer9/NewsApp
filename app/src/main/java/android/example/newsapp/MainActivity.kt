package android.example.newsapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson

class MainActivity: AppCompatActivity(),onItemClicked {
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = NewsListAdapter(getItemList(), this)

    }

    private fun getItemList(): ArrayList<Articles> {
        val newsList = Gson().fromJson(news_api, News::class.java)
        return newsList.articles
    }

    //App is crashing on item click. Check for the crash logs and find a resolution
    private fun showNews(news: Articles) {
        val articleJson = Gson().toJson(news)
        val intent = Intent(this, Description::class.java)
        intent.putExtra("newsJson", articleJson)
        startActivity(intent)
    }

     override fun onItemClicked(item: Articles) {
        showNews(item)
    }
}



