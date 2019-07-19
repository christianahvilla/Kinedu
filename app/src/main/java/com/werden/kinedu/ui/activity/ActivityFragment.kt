package com.werden.kinedu.ui.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.werden.kinedu.R
import com.werden.kinedu.di.component.DaggerFragmentComponent
import com.werden.kinedu.di.module.FragmentModule
import com.werden.kinedu.model.activity.Activities
import com.werden.kinedu.model.activity.Activity
import com.werden.kinedu.utils.ERROR
import kotlinx.android.synthetic.main.recycler_view.*
import kotlinx.android.synthetic.main.spinner_filter.*
import javax.inject.Inject

class ActivityFragment : Fragment(), ActivityContract.View {

    @Inject
    lateinit var presenter: ActivityContract.Presenter
    lateinit var activities: MutableList<Activity>
    lateinit var activitiesF: MutableList<Activity>

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
        swipe_content.setOnRefreshListener {
            initView()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.unsubscribe()
    }

    override fun showProgress(show: Boolean) {
        swipe_content.isRefreshing = show
    }

    override fun showErrorMessage(error: String) {
        Toast.makeText(view?.context, ERROR, Toast.LENGTH_SHORT).show()
    }

    override fun loadDataSuccess(list: Activities) {
        setSpinner(list)
        activities = list.data.activities.toMutableList()
        activitiesF = list.data.activities.toMutableList()
        setRecycler()
        runLayoutAnimation()
    }

    private fun runLayoutAnimation() {
        val controller= AnimationUtils.loadLayoutAnimation(activity, R.anim.layout_animation_fall_down)
        recycler_content.layoutAnimation = controller
        recycler_content.scheduleLayoutAnimation()
    }

    private fun setSpinner(list: Activities) {
        var months: MutableList<String> = mutableListOf()

        list.data.activities.forEach { item ->
            months.add(item.age.toString() + " MONTHS")
        }

        months = months.distinct() as MutableList<String>
        months.sorted()
        months.add(0, "ALL MONTHS")

        val adapter = ArrayAdapter(activity, android.R.layout.simple_spinner_dropdown_item, months)
        adapter.setDropDownViewResource(R.layout.spinner_item)
        activity?.spinner_filter_activities?.adapter = adapter
        activity?.spinner_filter_activities?.onItemSelectedListener = itemSelected(months)
    }

    private fun setRecycler() {
        val activityAdapter = ActivityAdapter(activity!!.applicationContext, activitiesF)
        recycler_content!!.layoutManager = LinearLayoutManager(activity)
        recycler_content!!.adapter = activityAdapter
    }

    fun itemSelected(months: List<String>): OnItemSelectedListener {
        return object : OnItemSelectedListener,
            AdapterView.OnItemClickListener {
            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            }

            override fun onItemSelected(adapter: AdapterView<*>, v: View, i: Int, lng: Long) {
                if (i > 0) {
                    activitiesF = activities.filter { item -> (item.age.toString() + " MONTHS") == months[i] } as MutableList<Activity>
                }
                else {
                    activitiesF = activities
                }
                setRecycler()
            }

            override fun onNothingSelected(parentView: AdapterView<*>) {
            }
        }
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

}
