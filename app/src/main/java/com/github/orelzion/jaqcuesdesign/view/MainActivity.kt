package com.github.orelzion.jaqcuesdesign.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.orelzion.jacques_design.core.domain.Coin
import com.github.orelzion.jacques_design.core.domain.Currency
import com.github.orelzion.jacques_design.core.domain.diamond.Diamond
import com.github.orelzion.jacques_design.core.domain.diamond.DiamondProperties
import com.github.orelzion.jacques_design.core.domain.diamond.Fee
import com.github.orelzion.jacques_design.core.domain.diamond.Parcel
import com.github.orelzion.jaqcuesdesign.R
import com.github.orelzion.jaqcuesdesign.model.FirebaseParcelDataSource
import com.google.firebase.FirebaseApp
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FirebaseApp.initializeApp(this)
    }
}
