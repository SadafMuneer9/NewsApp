package android.example.newsapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.gson.Gson

class Description : AppCompatActivity() {
    private lateinit var imageView: ImageView
    private lateinit var newsTitle: TextView
    private lateinit var newsAuthor: TextView
    private lateinit var descriptionNews: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView = findViewById(R.id.newsPic)
        newsTitle = findViewById(R.id.headingNews)
        newsAuthor = findViewById(R.id.authorNews)
        descriptionNews = findViewById(R.id.descriptionNews)

        val newsJson = intent.getStringExtra("newsJson") ?: return
        val newsArticles = Gson().fromJson(newsJson, Articles::class.java)
        Glide.with(this).load(newsArticles.urlToImage).into(imageView)
        newsTitle.text = newsArticles.title
        newsAuthor.text = newsArticles.author
        descriptionNews.text = newsArticles.description
        imageView.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(newsArticles.url))
            startActivity(intent)
        }
    }
}