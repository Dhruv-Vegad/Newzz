package com.insane.newzz.repos
// Calling all the function we made
import com.insane.newzz.api.RetroFitInstance
import com.insane.newzz.database.ArticleDatabase
import com.insane.newzz.models.Article

class NewsRepository(val db: ArticleDatabase){

    suspend fun headlines(countryCode: String, pageNumber: Int) =
        RetroFitInstance.api.getHeadlines(countryCode, pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetroFitInstance.api.searchForNews(searchQuery, pageNumber)

    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)

    fun getFavouriteNews() = db.getArticleDao().getAllArticles()

    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)
}