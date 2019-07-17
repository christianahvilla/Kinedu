package com.werden.kinedu.ui.article.detailed

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.squareup.picasso.Picasso
import com.werden.kinedu.R
import com.werden.kinedu.di.component.DaggerDetailedComponent
import com.werden.kinedu.di.module.DetailedModule
import com.werden.kinedu.model.detailed.Detailed
import com.werden.kinedu.utils.ERROR
import kotlinx.android.synthetic.main.activity_article_detailed.*
import kotlinx.android.synthetic.main.progress_bar.*
import javax.inject.Inject

class DetailedActivity : AppCompatActivity(), DetailedContract.View {

    @Inject
    lateinit var presenter: DetailedContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_detailed)

        supportActionBar?.setDisplayHomeAsUpEnabled(true);
        supportActionBar?.setDisplayShowHomeEnabled(true);

        injectDependency()

        presenter.attach(this)
        presenter.subscribe()
        initView()
    }

    private fun injectDependency() {
        val detailedComponent = DaggerDetailedComponent
            .builder()
            .detailedModule(DetailedModule(this))
            .build()
        detailedComponent.inject(this)
    }

    override fun showProgress(show: Boolean) {
        if (show) {
            progressBar.visibility = View.VISIBLE
        } else {
            progressBar.visibility = View.GONE
        }
    }

    override fun showErrorMessage(error: String) {
        Toast.makeText(this@DetailedActivity, ERROR, Toast.LENGTH_SHORT).show()
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun loadDataSuccess(articleDetailed: Detailed) {
        Picasso.get().load(articleDetailed.data.article.picture).fit().centerCrop().into(detailed_image)
        detailed_text.text = (Html.fromHtml(articleDetailed.data.article.body, Html.FROM_HTML_MODE_COMPACT))
    }

    private fun initView() {
        presenter.loadData(intent.getIntExtra("id", 0))
    }
}
