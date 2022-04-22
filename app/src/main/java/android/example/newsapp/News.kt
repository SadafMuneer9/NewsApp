package android.example.newsapp

data class News(
    val status: String,
    val articles: ArrayList<Articles>
)

data class Articles(
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String
)