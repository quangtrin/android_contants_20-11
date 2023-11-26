package com.example.contants

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), Communicator {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView
                >(R.id.bottom_navigatin_view)
        val navController = findNavController(R.id.nav_fragment)
        bottomNavigationView.setupWithNavController(navController
        )

    }

    override fun passDataCom(contant: ContantModel) {
        val bundle = Bundle()
        bundle.putString("contantAvatar", contant.avatar.toString())
        bundle.putString("contantName", contant.name)
        bundle.putString("contantPhone", contant.numberPhone)

        val transaction = this.supportFragmentManager.beginTransaction()
        val fragmentInformation = InformationFragment()
        fragmentInformation.arguments = bundle
        transaction.commit()

        val bottomNavigationView = findViewById<BottomNavigationView
                >(R.id.bottom_navigatin_view)
        val navController = findNavController(R.id.nav_fragment)
        bottomNavigationView.setupWithNavController(navController
        )

        navController.navigate(R.id.informationFragment, bundle)
    }
}