package com.werden.kinedu.ui.article

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.werden.kinedu.R
import com.werden.kinedu.di.component.DaggerFragmentComponent
import com.werden.kinedu.di.module.FragmentModule
import com.werden.kinedu.model.article.Article
import com.werden.kinedu.model.article.Articles
import com.werden.kinedu.ui.article.detailed.DetailedActivity
import com.werden.kinedu.utils.ERROR
import kotlinx.android.synthetic.main.recycler_view.*
import kotlinx.android.synthetic.main.spinner_filter.*
import javax.inject.Inject


class ArticleFragment : Fragment(), ArticleContract.View, ArticleAdapter.onItemClickListener {

    @Inject
    lateinit var presenter: ArticleContract.Presenter
    lateinit var articles: MutableList<Article>
    lateinit var articlesF: MutableList<Article>

    private lateinit var rootView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependency()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_article, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attach(this)
        presenter.subscribe()
        initView()
        swipe_content.setOnRefreshListener {
            initView()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.unsubscribe()
    }

    override fun loadDataSuccess(list: Articles) {
        setMonths(list)
        articles = list.data.articles.toMutableList()
        articlesF = list.data.articles.toMutableList()
        setRecycler()
        runLayoutAnimation()
    }

    private fun runLayoutAnimation() {
        val controller= AnimationUtils.loadLayoutAnimation(activity, R.anim.layout_animation_fall_down)
        recycler_content.layoutAnimation = controller
        recycler_content.scheduleLayoutAnimation()
    }

    private fun setMonths(list: Articles) {
        var months: MutableList<String> = mutableListOf()

        list.data.articles.forEach { item ->
            months.add(item.min_age.toString() + "-" + item.max_age.toString() + " MONTHS")
        }

        months = months.distinct() as MutableList<String>
        months.sorted()
        months.add(0, "ALL MONTHS")

        val adapter = ArrayAdapter(activity, android.R.layout.simple_spinner_dropdown_item, months)
        adapter.setDropDownViewResource(R.layout.spinner_item)
        activity?.spinner_filter_articles?.adapter = adapter
        activity?.spinner_filter_articles?.onItemSelectedListener = itemSelected(months)
    }

    private fun setRecycler() {
        val activityAdapter = ArticleAdapter(this,activity!!.applicationContext, articlesF)
        recycler_content!!.layoutManager = LinearLayoutManager(activity)
        recycler_content!!.adapter = activityAdapter
    }

    private fun itemSelected(months: List<String>): AdapterView.OnItemSelectedListener {
        return object : AdapterView.OnItemSelectedListener,
            AdapterView.OnItemClickListener {
            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            }

            override fun onItemSelected(adapter: AdapterView<*>, v: View, i: Int, lng: Long) {
                if (i > 0) {
                    articlesF = articles.filter { item -> (item.min_age.toString() + "-" + item.max_age.toString() + " MONTHS") == months[i] } as MutableList<Article>
                }
                else {
                    articlesF = articles
                }
                setRecycler()
            }

            override fun onNothingSelected(parentView: AdapterView<*>) {
            }
        }
    }

    private fun injectDependency() {
        val articleComponent = DaggerFragmentComponent
            .builder()
            .fragmentModule(FragmentModule())
            .build()
        articleComponent.inject(this)
    }

    private fun initView() {
        presenter.loadData()
    }

    override fun showProgress(show: Boolean) {
        swipe_content.isRefreshing = show
    }

    override fun showErrorMessage(error: String) {
        Toast.makeText(view?.context, ERROR, Toast.LENGTH_SHORT).show()
    }

    override fun itemDetail(id: Int) {
        val intent = Intent(activity, DetailedActivity::class.java)
        intent.putExtra("id", id)
        startActivity(intent)
    }

}
