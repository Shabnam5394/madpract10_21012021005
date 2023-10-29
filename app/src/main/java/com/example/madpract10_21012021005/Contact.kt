package com.example.madpract10_21012021005

class Contact (var id:String, var lat:String, var long:String, var name:String, var phone:String,var address:String) {

    companion object {

        var contactArray: List<Contact> = ArrayList()
    }
}