package com.jo.ArduinoInfoSuite

data class UserModel(
    val userName: String,
    val userImage: String
) {
    constructor():this(
        "",
        "")
}