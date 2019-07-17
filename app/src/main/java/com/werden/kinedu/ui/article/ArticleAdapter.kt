package com.werden.kinedu.ui.article

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.werden.kinedu.R
import com.werden.kinedu.model.article.Article

class ArticleAdapter(fragment: Fragment, private val context: Context,
                     private val articleList: MutableList<Article>):
    RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>(){

    private val listener: onItemClickListener

    init {
        this.listener = fragment as onItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.card_article, parent, false)
        return ArticleViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return articleList.size
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        Picasso.get().load(articleList[position].picture).fit().centerCrop().into(holder.article_image)
        holder.article_title.text = articleList[position].name
        holder.article_description.text = articleList[position].short_description

        holder.article_layout.setOnClickListener{
            listener.itemDetail(articleList[position].id)
        }
    }

    class ArticleViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val article_image: ImageView = itemView.findViewById(R.id.article_image)
        val article_layout: CardView = itemView.findViewById(R.id.article_layout)
        val article_title: TextView = itemView.findViewById(R.id.article_title)
        val article_description: TextView = itemView.findViewById(R.id.article_description)
    }

    interface onItemClickListener {
        fun itemDetail(id: Int)
    }


}