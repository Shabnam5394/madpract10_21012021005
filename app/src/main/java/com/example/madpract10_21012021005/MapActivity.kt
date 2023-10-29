package com.example.madpract10_21012021005

import android.content.Intent
import android.os.Bundle
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap


    private var fianllatitude: Double = 0.0
    private var finallongitude: Double = 0.0

    private var personname: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)


        val check1 = intent.getStringExtra("latitudedata")
        val check2 = intent.getStringExtra("longidata")

        personname = intent.getStringExtra("passname").toString()

        if (check1 != null && check1.contains(":")) {
            val parts = check1.split(":")
            fianllatitude = parts.last().trim().toDouble()
        }

        if (check2 != null && check2.contains(":")) {
            val parts = check2.split(":")
            finallongitude = parts.last().trim().toDouble()
        }


        Log.d("Hello", "Starting to print")
        if (check1 != null) {
            Log.d("final lat", check1)
        }
        if (check2 != null) {
            Log.d("finall ong", check2)
        }


        val mapFragment = supportFragmentManager.findFragmentById(R.id.mapFragment) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Create a LatLng object for the location
        val location = LatLng(fianllatitude, finallongitude)

        // Set the camera position and zoom level
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 10f))

        // Add a marker at the specified location
        mMap.addMarker(MarkerOptions().position(location).title(personname))


    }

}
