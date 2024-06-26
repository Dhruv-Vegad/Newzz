package com.insane.newzz.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.webkit.WebViewClient
import androidx.navigation.fragment.navArgs
import com.insane.newzz.R
import com.insane.newzz.databinding.FragmentArticlesBinding
import com.google.android.material.snackbar.Snackbar
import com.insane.newzz.ui.MainActivity
import com.insane.newzz.ui.NewsViewModel
import com.insane.newzz.models.Article



class Articles : Fragment(R.layout.fragment_articles) {

    lateinit var newsViewModel: NewsViewModel
    val args: ArticlesArgs by navArgs() //using Args means accessing the arguments pass to the fragment
    lateinit var binding: FragmentArticlesBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentArticlesBinding.bind(view)
        //Web view setup
        newsViewModel = (activity as MainActivity).newsViewModel
        val article = args.article

        binding.webView.apply {
            webViewClient = WebViewClient()
            article.url?.let {
                loadUrl(it)
            }
        }
        binding.floatingActionBtn.setOnClickListener {
            newsViewModel.addToFavourites(article)
            Snackbar.make(view, "Article Saved Successfully", Snackbar.LENGTH_SHORT).show()
        }
    }
}