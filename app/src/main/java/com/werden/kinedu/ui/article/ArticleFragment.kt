package com.werden.kinedu.ui.article

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.werden.kinedu.R
import com.werden.kinedu.di.component.DaggerFragmentComponent
import com.werden.kinedu.di.module.FragmentModule
import com.werden.kinedu.model.article.ArticleData
import com.werden.kinedu.model.article.Articles
import com.werden.kinedu.ui.activity.ActivityAdapter
import com.werden.kinedu.utils.ERROR
import kotlinx.android.synthetic.main.progress_bar.*
import kotlinx.android.synthetic.main.recycler_view.*
import javax.inject.Inject


class ArticleFragment : Fragment(), ArticleContract.View {

    @Inject
    lateinit var presenter: ArticleContract.Presenter

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
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.unsubscribe()
    }

    override fun loadDataSuccess(list: Articles) {
        var articleAdapter = ArticleAdapter(activity!!.applicationContext, list.data.articles.toMutableList())
        recycler_content!!.layoutManager = LinearLayoutManager(activity)
        recycler_content!!.adapter = articleAdapter
    }

    private fun injectDependency() {
        val articleComponent = DaggerFragmentComponent
            .builder()
            .fragmentModule(FragmentModule())
            .build()
        articleComponent.inject(this)
    }

    fun newInstance(): ArticleFragment {
        return ArticleFragment()
    }

    private fun initView() {
        presenter.loadData()
    }

    companion object {
        const val TAG: String = "ArticleFragment"
    }

    override fun showProgress(show: Boolean) {
        if (show) {
            progressBar.visibility = View.VISIBLE
        } else {
            progressBar.visibility = View.GONE
        }
    }

    override fun showErrorMessage(error: String) {
        Toast.makeText(view?.context, ERROR, Toast.LENGTH_SHORT).show()
    }
}
