package com.werden.kinedu.ui.article.detailed

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.View
import android.widget.Toast
import com.squareup.picasso.Picasso
import com.werden.kinedu.R
import com.werden.kinedu.di.component.DaggerActivityComponent
import com.werden.kinedu.di.module.ActivityModule
import com.werden.kinedu.model.detailed.Detailed
import com.werden.kinedu.utils.ERROR
import kotlinx.android.synthetic.main.activity_article_detailed.*
import kotlinx.android.synthetic.main.layout_share.*
import kotlinx.android.synthetic.main.progress_bar.*
import kotlinx.android.synthetic.main.spinner_filter.*
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
        val activityComponent = DaggerActivityComponent
            .builder()
            .activityModule(ActivityModule(this))
            .build()
        activityComponent.inject(this)
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

    override fun loadDataSuccess(articleDetailed: Detailed) {
        Picasso.get().load(articleDetailed.data.article.picture).fit().centerCrop().into(detailed_image)
        detailed_share.visibility = View.VISIBLE

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            detailed_text.text = (Html.fromHtml(articleDetailed.data.article.body, Html.FROM_HTML_OPTION_USE_CSS_COLORS))
        } else {
            detailed_text.text = (Html.fromHtml(articleDetailed.data.article.body))
        }

        detailed_title.text = articleDetailed.data.article.title

        detailed_share.setOnClickListener{
            shareLink(articleDetailed.data.article.link)
        }
    }

    private fun shareLink(url: String){
        val sendIntent = Intent()
        sendIntent.action = Intent.ACTION_SEND
        sendIntent.putExtra(Intent.EXTRA_SUBJECT, "Look at this great article")
        sendIntent.putExtra(Intent.EXTRA_TEXT, url)
        sendIntent.type = "text/plain"
        startActivity(Intent.createChooser(sendIntent, "Share Article"))
    }

    private fun initView() {
        presenter.loadData(intent.getIntExtra("id", 0))
    }
}
