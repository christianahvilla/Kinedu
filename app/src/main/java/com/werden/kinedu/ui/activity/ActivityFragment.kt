package com.werden.kinedu.ui.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager

import com.werden.kinedu.R
import com.werden.kinedu.di.component.DaggerFragmentComponent
import com.werden.kinedu.di.module.FragmentModule
import com.werden.kinedu.model.activity.Activities
import com.werden.kinedu.model.activity.ActivityData
import com.werden.kinedu.utils.ERROR
import kotlinx.android.synthetic.main.fragment_activity.view.*
import kotlinx.android.synthetic.main.fragment_article.*
import kotlinx.android.synthetic.main.progress_bar.*
import kotlinx.android.synthetic.main.recycler_view.*
import javax.inject.Inject

class ActivityFragment : Fragment(), ActivityContract.View {

    @Inject
    lateinit var presenter: ActivityContract.Presenter

    private lateinit var rootView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependency()

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_activity, container, false)
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

    override fun loadDataSuccess(list: Activities) {

        var activityAdapter = ActivityAdapter(activity!!.applicationContext, list.data.activities.toMutableList())
        recycler_content!!.layoutManager = LinearLayoutManager(activity)
        recycler_content!!.adapter = activityAdapter


    }

    private fun injectDependency() {
        val activityComponent = DaggerFragmentComponent
            .builder()
            .fragmentModule(FragmentModule())
            .build()

        activityComponent.inject(this)
    }

    private fun initView() {
        presenter.loadData()
    }

    companion object {
        val TAG: String = "ActivityFragment"
    }

}
