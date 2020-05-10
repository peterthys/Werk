package com.example.werk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.werk.klassen.Customer
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.ticket_overview.*

class MainActivity : AppCompatActivity() {
    var listCustomers = ArrayList<Customer>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listCustomers.add(
            Customer(
                1,
                "Ceulemans Peter",
                "Aannemer",
                " 0476418746 ",
                "peterceulemans.bvba@skynet.be",
                "Schriekstraat 140 2223 Schriek ",
                "",
                "",
                "BE0860 733 953 "
            )
        )

    }
}

