package com.example.werk.gui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.werk.R
import kotlinx.android.synthetic.main.fragment_welcome.*


class WelcomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_welcome, container, false)
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    bt_choose_customer.setOnClickListener {
        view.findNavController()
            .navigate(R.id.action_welcomeFragment_to_customerOverviewFragment)}

        bt_to_jp_overview.setOnClickListener(){
            view.findNavController()
                .navigate(R.id.action_welcomeFragment_to_jobPerformanceOverviewFragment)
        }
        bt_go_to_new_customer.setOnClickListener{
            view.findNavController()
                .navigate(R.id.action_welcomeFragment_to_newCustomerFragment)
    }


}
}