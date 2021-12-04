package dev.example.myplanetapp.model

import com.google.firebase.storage.StorageReference

class VolunteeringEvent(var id: Int? = null,
                        var title: String? = null,
                        var time: String? = null,
                        var spots: Int? = null,
                        var sponsor: String? = null,
                        var day: Int? = null,
                        var month: String? = null,
                        var year: Int? = null,
                        var sponsor_logo: String? = null,
                        var picture: String? = null,
                        var description: String? = null,
                        var selected: Boolean? = null,
                        var place: String? = null,

){}