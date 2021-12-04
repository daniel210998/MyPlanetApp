package dev.example.myplanetapp.create_event

import java.util.*

class Evento(
    var id: Int,
    var title: String,
    var time: String,
    var spots: Int,
    var sponsor: String,
    var day: Int,
    var month: String? = null,
    var year: Int? = null,
    var sponsor_logo: String? = null,
    var picture: String? = null
){}