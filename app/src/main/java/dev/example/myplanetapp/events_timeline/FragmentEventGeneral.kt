package dev.example.myplanetapp.events_timeline

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dev.example.myplanetapp.R
import dev.example.myplanetapp.adapters.ViewPagerAdapterForEvents

class FragmentEventGeneral : Fragment() {

    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout
    private lateinit var tabsName: Map<Int, String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_event_general, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = view.findNavController()
        val appBarConfiguration = AppBarConfiguration(navController.graph)

        viewPager = view.findViewById(R.id.viewpager_events)
        tabLayout = view.findViewById(R.id.tablayout_events)

        val fragments: ArrayList<Fragment> = arrayListOf(
            FragmentAllEvents(),
            //FragmentOnGoing(),
            FragmentMyEvents()
        )

        val adapter = ViewPagerAdapterForEvents(fragments, this)
        viewPager.adapter = adapter

        tabsName = mapOf(0 to "Muro", 1 to "Mis eventos")

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = "${(tabsName[position])}"
        }.attach()

    }
}