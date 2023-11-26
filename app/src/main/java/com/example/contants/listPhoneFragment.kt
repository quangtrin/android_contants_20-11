package com.example.contants

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import android.widget.PopupMenu
import androidx.fragment.app.Fragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [listPhoneFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class listPhoneFragment : Fragment(R.layout.fragment_list_phone) {
    lateinit var communicator: Communicator
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        communicator = activity as Communicator
        return inflater.inflate(R.layout.fragment_list_phone, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val items = arrayListOf<ContantModel>()
        repeat(15){
            val index = it + 10
            items.add(ContantModel(
                R.drawable.avatar_mail,
                "Quang ${it}",
                "12345678${it}")
            )
        }
        val gridView = view.findViewById<GridView>(R.id.grid_layout)
        gridView.adapter = ContantAdapter(items)
        gridView.setOnItemClickListener { parent, view, position, id ->
            communicator.passDataCom(items[position]);
        }
        gridView.setOnItemLongClickListener { parent, view, position, id ->
            showPopupMenu(view)
            true
        }
    }

    private fun showPopupMenu(view: View) {
        val popupMenu = PopupMenu(context, view, Gravity.END)
        popupMenu.inflate(R.menu.menu_item)
        popupMenu.show()
    }
}

