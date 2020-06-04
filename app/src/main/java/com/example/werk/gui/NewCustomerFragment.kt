package com.example.werk.gui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.werk.R
import kotlinx.android.synthetic.main.fragment_new_customer.*

/**
 * A simple [Fragment] subclass.
 */
class NewCustomerFragment : Fragment() {
    private lateinit var editWordView1: EditText
    private lateinit var editWordView2: EditText
    private lateinit var editWordView3: EditText
    private lateinit var editWordView4: EditText
    private lateinit var editWordView5: EditText
    private lateinit var editWordView6: EditText
    private lateinit var editWordView7: EditText
    private lateinit var editWordView8: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_new_customer, container, false)
        // Inflate the layout for this fragment


        editWordView1 = et_name
        editWordView2 = et_description
        editWordView3 = et_email
        editWordView4 = et_phone
        editWordView5 = et_adress1
        editWordView6 = et_adress2
        editWordView7 = et_btw
        editWordView8 = et_info


        val button = bt_add
        button.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(editWordView1.text)) {
                getActivity()?.setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val name = editWordView1.text.toString()
                replyIntent.putExtra(EXTRA_REPLY, name)
                getActivity()?.setResult(Activity.RESULT_OK, replyIntent)
            }
            getActivity()?.finish()
        }
        return v
    }


    companion object {
        const val EXTRA_REPLY = "com.example.android.customerlistsql.REPLY"
    }

}
